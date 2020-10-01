package flight_booking.backend.service;


import flight_booking.backend.controllers.flight.FlightDto;
import flight_booking.backend.controllers.ticket.TicketDto;
import flight_booking.backend.models.*;
import flight_booking.backend.controllers.trip.TripDto;

import flight_booking.backend.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TicketService ticketService;
    private final FlightService flightService;
    private final UserService userService;
    private final SeatService seatService;

    TripService(TripRepository tripRepository,
                TicketService ticketService,
                FlightService flightService,
                UserService userService,
                SeatService seatService) {
        this.tripRepository = tripRepository;
        this.ticketService = ticketService;
        this.flightService = flightService;
        this.userService = userService;
        this.seatService = seatService;
    }

//    public List<Trip> findAllTripsFromUserId(Long id) {
//        List<Trip> trips = tripRepository.findAllTripFromUserId(id);
//
//        return trips;
//    }

    public List<Trip> findAllAvailableTrips(Long srcAirportId, Long dstAirportId,
                                            LocalDate departureDate, int passengerNumber) {

        return ticketService.findAllTrips(srcAirportId, dstAirportId, departureDate, passengerNumber);
    }

    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }

    public Trip findTripByCode(String code) {

        return tripRepository.findTripByCode(code);
    }

    public boolean existsById(Long id) {

        return tripRepository.existsById(id);
    }

    public boolean existsByCode(String code) {

        boolean flag = true;
        Trip trip = tripRepository.findTripByCode(code);
        if (trip == null) {
            flag = false;
        }

        return flag;
    }

    public Set<Trip> findTripsByTickets(List<Ticket> tickets) {

        Set<Trip> trips = new HashSet<>();
        for (Ticket ticket : tickets) {
            Trip trip = ticket.getTrip();
            trips.add(trip);
        }
        return trips;
    }

    public Trip addNewTrip(List<Passenger> passengers, TripDto tripDto, long userId) {
        String uniqueID = UUID.randomUUID().toString();
        boolean flag = true;
        Optional<User> user = userService.findById(userId);
        Trip trip = tripRepository.save(Trip.builder()
                .code(uniqueID)
                .tickets(new ArrayList<>())
                .departureDate(LocalDate.parse(tripDto.getDepartureDate()))
                .departureTime(LocalTime.parse(tripDto.getDepartureTime()))
                .arrivalDate(LocalDate.parse(tripDto.getArrivalDate()))
                .arrivalTime(LocalTime.parse(tripDto.getArrivalTime()))
                .purchaseDate(LocalDate.now())
                .purchaseTime(LocalTime.now())
                .price(tripDto.getTotalPrice())
                .build());

        for (TicketDto ticketDto : tripDto.getArraysTicket()) {
            FlightDto flightDto = ticketDto.getFlightDto();
            Optional<Flight> flight = flightService.findById(flightDto.getId());

            if (flight.isPresent()) {

                for (Passenger passenger : passengers) {
                    flight.get().setAvailableSeats(flight.get().getAvailableSeats() - 1);

                    int numberSeat = 0;
                    List<Integer> seats = seatService.findAllBusySeat(flight.get());


                    do {
                        numberSeat = flight.get().getNumberSeats();
                    }
                    while (checkIfNumberSeatIsCorrectAndFree(seats, numberSeat, flight.get()));


                    flight.get().addSeat(Seat.builder()
                            .seatNumber(generateSeatNumber(flight.get().getNumberSeats()))
                            .flight(flight.get())
                            .build());
                    flightService.save(flight.get());

                    Period period = Period.between(passenger.getDateOfBirth(), LocalDate.now());
                    double price = 0;
                    if (period.getYears() < 18) {
                        price = flight.get().getPrice() * 0.8;
                    } else {
                        price = flight.get().getPrice();
                    }

                    Ticket ticket = ticketService.save(Ticket.builder()
                            .passenger(passenger)
                            .flight(flight.get())
                            .trip(trip)
                            .seatNumber(generateSeatNumber(flight.get().getNumberSeats()))
                            .price(price)
                            .build());

                    trip.addTicket(ticket);
                }

            } else {
                flag = false;
                break;
            }
        }

        Trip actualTrip = null;
        if (flag) {
            actualTrip = tripRepository.save(trip);

            if (user.isPresent()) {
                user.get().addTrip(actualTrip);
                userService.save(user.get());
            }

        }


        return actualTrip;
    }

    private int generateSeatNumber(int seatNumbers) {

        Random random = new Random();
        return random.nextInt(seatNumbers) + 1;
    }

    private boolean checkIfNumberSeatIsCorrectAndFree(List<Integer> seatsNumber, int numberSeat, Flight flight) {

        Boolean flag = true;

        if (numberSeat > flight.getNumberSeats() || numberSeat < 1) {
            flag = false;
        }

        if (flag) {
            for (Integer seatNumber : seatsNumber) {
                if(seatNumber == numberSeat){
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public void deleteTrips(Set<Trip> trips) {

        for (Trip trip : trips) {
            ticketService.deleteTickets(trip.getTickets());
            tripRepository.deleteById(trip.getId());
        }
    }

    public void deleteTripsWithTimeLimit(Trip trip) {
        LocalDateTime departureTime = LocalDateTime.of(trip.getDepartureDate(), trip.getDepartureTime());
        LocalDateTime currentTime = LocalDateTime.now();
        long hours = Duration.between(currentTime, departureTime).toHours();
        System.out.println(hours);
        if (currentTime.isAfter(departureTime) || currentTime.isEqual(departureTime) || hours < 24) {
            throw new IllegalStateException("The user cannot cancel the flight in the last 24 hours before departure");
        }

        if (currentTime.isAfter(departureTime) || currentTime.isEqual(departureTime)) {
            throw new IllegalStateException("Trip is archived.");
        }

        if (hours < 24) {
            throw new IllegalStateException("The user cannot cancel the flight in the last 24 hours before departure");
        }

        ticketService.deleteTickets(trip.getTickets());
        tripRepository.deleteById(trip.getId());
    }
}
