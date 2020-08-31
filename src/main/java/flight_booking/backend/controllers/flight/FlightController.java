package flight_booking.backend.controllers.flight;

import flight_booking.backend.models.Airline;
import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Connection;
import flight_booking.backend.models.Flight;
import flight_booking.backend.service.AirlineService;
import flight_booking.backend.service.AirportService;
import flight_booking.backend.service.ConnectionService;
import flight_booking.backend.service.FlightService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final ConnectionService connectionService;
    private final FlightService flightService;
    private final AirlineService airlineService;
    private final AirportService airportService;
    private final FlightMapper flightMapper;

    FlightController(ConnectionService connectionService,
                     FlightService flightService,
                     AirlineService airlineService,
                     AirportService airportService) {
        this.connectionService = connectionService;
        this.flightService = flightService;
        this.airlineService = airlineService;
        this.airportService = airportService;
        this.flightMapper = new FlightMapper();
    }

    @ApiOperation(value = "Get all flights")
    @GetMapping
    ResponseEntity<List<FlightDto>> getAllFlights() {
        List<Flight> flights = flightService.findAll();

        ArrayList<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight : flights) {
            Connection connection = flightService.findConnection(flight.getId());
            flightDtos.add(flightMapper.map(flight, connection));
        }
        return ResponseEntity.ok(flightDtos);
    }

    //TODO read about twice @Requestbody in arguments of one function
    //TODO add validators for examples like "if airlineId exists"
    @ApiOperation(value = "Add new flight")
    @PostMapping
    ResponseEntity<Flight> addNewFlight(@RequestParam Long airlineDtoId,
                                        @RequestParam int numberSeats,
                                        @RequestParam double price,
                                        @RequestParam Long srcAirportId,
                                        @RequestParam Long dstAirportId,
                                        @RequestParam String departureDate,
                                        @RequestParam String departureTime,
                                        @RequestParam String flightTime) {

        Connection connection = connectionService.addNewConnection(srcAirportId, dstAirportId);
        Flight flight = flightService.addNewFlight(airlineDtoId, numberSeats, price, departureDate,
                departureTime, flightTime, connection);
        return ResponseEntity.created(URI.create("/" + flight.getId())).body(flight);

    }

    //TODO add validators for examples like "if airlineId exists"
    @ApiOperation(value = "Update flight")
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateFlight(@RequestParam Long flightId,
                                      @RequestParam Long airlineId,
                                      @RequestParam int numberSeats,
                                      @RequestParam double price,
                                      @RequestParam Long srcAirportId,
                                      @RequestParam Long dstAirportId,
                                      @RequestParam String departureDate,
                                      @RequestParam String departureTime,
                                      @RequestParam String flightTime) {

        if (!flightService.existsById(flightId)) {
            throw new NoSuchElementException("Flight with that id not exist!");
        }

        if (!connectionService.existsById(flightId)) {
            throw new NoSuchElementException("Connection with that id not exist!");
        }

        Optional<Flight> flightOptional = flightService.findById(flightId);
        Connection connection = flightService.findConnection(flightId);
        Optional<Airline> airline = airlineService.findById(airlineId);
        Optional<Airport> srcAirport = airportService.findById(srcAirportId);
        Optional<Airport> dstAirport = airportService.findById(dstAirportId);

        connection.updateForm(
                srcAirport.get(),
                dstAirport.get()
        );

        flightOptional.get().updateForm(
                airline.get(),
                numberSeats,
                price,
                departureDate,
                departureTime,
                flightTime
        );

        if (flightOptional.isPresent()) {
            flightService.save(flightOptional.get());
            connectionService.save(connection);
        }

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete flight")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {

        if (!flightService.existsById(id)) {
            throw new NoSuchElementException("Flight with that id not exist!");
        }

        flightService.deleteConnection(id);
        return ResponseEntity.ok(id);
    }


    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<?> handleConnectionNotExistsException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }
}