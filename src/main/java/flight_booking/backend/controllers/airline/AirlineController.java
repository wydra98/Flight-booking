package flight_booking.backend.controllers.airline;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.controllers.airport.AirportDto;
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
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService;
    private final FlightService flightService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final AirlineMapper mapper = new AirlineMapper();

    public AirlineController(AirlineService airlineService,
                             FlightService flightService,
                             TicketService ticketService,
                             TripService tripService) {
        this.airlineService = airlineService;
        this.flightService = flightService;
        this.ticketService = ticketService;
        this.tripService = tripService;
    }

    @ApiOperation(value = "Get all airlines", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    ResponseEntity<List<AirlineDto>> getAllAirlines() {

        List<Airline> airlines = airlineService.findAll();

        ArrayList<AirlineDto> airlineDtos = new ArrayList<>();
        for (Airline airline : airlines) {
            airlineDtos.add(mapper.map(airline));
        }

        return ResponseEntity.ok(airlineDtos);
    }

    @ApiOperation(value = "Add new airline", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @PostMapping
    ResponseEntity<Airline> addNewAirline(@RequestBody AirlineDto airlineDto) {

        airlineService.validateNewAirline(airlineDto);

        Airline airline = airlineService.addNewAirline(airlineDto);
        return ResponseEntity.created(URI.create("/" + airline.getId())).body(airline);
    }

    @ApiOperation(value = "Delete airline", authorizations = {@Authorization(value = "authkey")})
    @Transactional
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete")
    ResponseEntity<Long> deleteAirline(@RequestParam Long id) throws InterruptedException {

        airlineService.validateId(id);
        Optional<Airline> airline = airlineService.findById(id);

        if (airline.isPresent()) {
            List<Flight> flights;
            List<Ticket> tickets;
            Set<Trip> trips = new HashSet<>();

            flights = flightService.findFlightsByAirline(airline.get());
            if (!flights.isEmpty()) {
                tickets = ticketService.findTicketsByFlights(flights);
                if (!tickets.isEmpty()) {
                    trips = tripService.findTripsByTickets(tickets);
                }
            }

            if (!trips.isEmpty()) {
                tripService.deleteTrips(trips);
            }

            if (!flights.isEmpty()) {
                flightService.deleteFlights(flights);
            }

            airlineService.deleteAirline(airline.get());
        }
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Update airline", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @PutMapping
    ResponseEntity<AirlineDto> updateAirline(@RequestBody AirlineDto airlineDto) {

        airlineService.validateId(airlineDto.getId());

        Optional<Airline> airlineOptional = airlineService.findById(airlineDto.getId());
        Airline saveAirline = null;
        if (airlineOptional.isPresent()) {
            airlineOptional.get().updateForm(airlineDto);
            saveAirline = airlineService.save(airlineOptional.get());
        }
        AirlineDto airlineToReturn = mapper.map(saveAirline);

        return ResponseEntity.ok(airlineToReturn);
    }
}

