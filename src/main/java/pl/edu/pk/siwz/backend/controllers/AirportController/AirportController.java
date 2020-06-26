package pl.edu.pk.siwz.backend.controllers.AirportController;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.exception.AirportAlreadyExistsException;
import pl.edu.pk.siwz.backend.exception.AirportNotExistsException;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.service.AirportService;
import pl.edu.pk.siwz.backend.service.ConnectionService;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportMapper mapper = new AirportMapper();
    private AirportService airportService;
    private final ConnectionService connectionService;

    public AirportController(AirportService airportService, ConnectionService connectionService) {
        this.airportService = airportService;
        this.connectionService = connectionService;
    }

    @ApiOperation(value = "Get all airports")
    @GetMapping
    ResponseEntity<List<AirportDto>> getAllAirports() {
        List<Airport> airports = airportService.findAll();

        ArrayList<AirportDto> airportsDtos = new ArrayList<>();
        for (Airport airport : airports) {
            airportsDtos.add(mapper.map(airport));
        }
        return ResponseEntity.ok(airportsDtos);
    }

    @ApiOperation(value = "Add new airport")
    @PostMapping
    ResponseEntity<Airport> addNewAirline(@RequestBody AirportDto airportDto,
                                          @RequestParam double longitude,
                                          @RequestParam double latitude) {

        if (airportService.checkIfAirportExists(airportDto, longitude, latitude)) {
            throw new AirportAlreadyExistsException("Airport with these data already exist in datebase!");
        }

        Airport airport = airportService.addNewAirport(airportDto, longitude, latitude);
        return ResponseEntity.created(URI.create("/" + airport.getId())).body(airport);
    }

    @ApiOperation(value = "Delete airport")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteAirport(@PathVariable Long id) {

        if (!airportService.existsById(id)) {
            throw new AirportNotExistsException("Airport with that id not exist!");
        }

        connectionService.deleteConnectionWithAirportId(id);
        airportService.deleteAirport(id);
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Update airport")
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateAirport(@RequestBody AirportDto airportDto,
                                       @RequestParam double longitude,
                                       @RequestParam double latitude) {

        if (!airportService.existsById(airportDto.getId())) {
            throw new AirportNotExistsException("Airport with that id not exist!");
        }

        Optional<Airport> airportOptional = airportService.findById(airportDto.getId());
        airportOptional.get().updateForm(airportDto, longitude, latitude);
        airportService.save(airportOptional.get());

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(AirportAlreadyExistsException.class)
    ResponseEntity<String> handleAirportAlreadyExistsException(AirportAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(AirportNotExistsException.class)
    ResponseEntity<?> handleAirportNotExistsException(AirportNotExistsException e) {
        return ResponseEntity.notFound().build();
    }

}
