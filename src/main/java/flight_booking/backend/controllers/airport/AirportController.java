package flight_booking.backend.controllers.airport;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.models.*;
import flight_booking.backend.services.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;

@RestController
@ExceptionProcessing
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;
    private final ConnectionService connectionService;
    private final FlightService flightService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final AirportMapper mapper = new AirportMapper();

    public AirportController(AirportService airportService,
                             ConnectionService connectionService,
                             FlightService flightService,
                             TicketService ticketService,
                             TripService tripService) {
        this.airportService = airportService;
        this.connectionService = connectionService;
        this.flightService = flightService;
        this.ticketService = ticketService;
        this.tripService = tripService;
    }

    @ApiOperation(value = "Get all airports", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    ResponseEntity<List<AirportDto>> getAllAirports() {

        List<Airport> airports = airportService.findAll();

        ArrayList<AirportDto> airportsDtos = new ArrayList<>();
        for (Airport airport : airports) {
            airportsDtos.add(mapper.map(airport));
        }
        return ResponseEntity.ok(airportsDtos);
    }

    @ApiOperation(value = "Add new airport", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @PostMapping
    ResponseEntity<Airport> addNewAirport(@RequestBody AirportDto airportDto,
                                          @RequestParam double longitude,
                                          @RequestParam double latitude) {

        airportService.validateNewAirport(airportDto, longitude, latitude);
        Airport airport = airportService.addNewAirport(airportDto, longitude, latitude);
        return ResponseEntity.created(URI.create("/" + airport.getId())).body(airport);
    }

    @ApiOperation(value = "Delete airport", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @DeleteMapping("/delete")
    public ResponseEntity<Long> deleteAirport(@RequestParam Long id) {

        airportService.validateId(id);
        Optional<Airport> airport = airportService.findById(id);

        if (airport.isPresent()) {
            List<Connection> connections;
            List<Flight> flights = new ArrayList<>();
            List<Ticket> tickets;
            Set<Trip> trips = new HashSet<>();

            connections = connectionService.findConnectionsByAirport(airport.get());
            if (!connections.isEmpty()) {
                flights = flightService.findFlightsByConnections(connections);
                if (!flights.isEmpty()) {
                    tickets = ticketService.findTicketsByFlights(flights);
                    if (!tickets.isEmpty()) {
                        trips = tripService.findTripsByTickets(tickets);
                    }
                }
            }

            if (!trips.isEmpty()) {
                tripService.deleteTrips(trips);
            }
            if (!flights.isEmpty()) {
                flightService.deleteFlights(flights);
            }
            if (!connections.isEmpty()) {
                connectionService.deleteConnections(connections);
            }
            airportService.deleteAirport(airport.get());

        }
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Update airport", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateAirport(@RequestBody AirportDto airportDto,
                                       @RequestParam double longitude,
                                       @RequestParam double latitude) {

        airportService.validateId(airportDto.getId());

        Optional<Airport> airport = airportService.findById(airportDto.getId());
        if (airport.isPresent()) {
            airport.get().updateForm(airportDto, longitude, latitude);
            airportService.save(airport.get());
        }

        return ResponseEntity.noContent().build();
    }
}
