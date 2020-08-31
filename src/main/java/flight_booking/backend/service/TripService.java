package flight_booking.backend.service;


import flight_booking.backend.controllers.flight.FlightDto;
import flight_booking.backend.controllers.ticket.TicketDto;
import flight_booking.backend.models.Flight;
import flight_booking.backend.models.Ticket;
import flight_booking.backend.models.Trip;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.controllers.trip.TripDto;

import flight_booking.backend.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TicketService ticketService;
    private final FlightService flightService;

    TripService(TripRepository tripRepository,
                TicketService ticketService,
                FlightService flightService) {
        this.tripRepository = tripRepository;
        this.ticketService = ticketService;
        this.flightService = flightService;
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

    public Trip addNewTrip(List<Passenger> passengers, TripDto tripDto) {
        String uniqueID = UUID.randomUUID().toString();
        boolean flag = true;
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

                for (Passenger passenger: passengers) {
                    flight.get().setAvailableSeats(flight.get().getAvailableSeats()-1);
                    flightService.save(flight.get());

                    Period period = Period.between(passenger.getDateOfBirth(), LocalDate.now());
                    double price = 0;
                    if(period.getYears()<18){
                        price =  flight.get().getPrice() * 0.8;
                    }
                    else{
                        price =  flight.get().getPrice();
                    }

                    Ticket ticket = ticketService.save(Ticket.builder()
                            .passenger(passenger)
                            .flight(flight.get())
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
        }

        return actualTrip;
    }

    private int generateSeatNumber(int seatNumbers){

        Random random = new Random();
        return random.nextInt(seatNumbers) + 1;
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
}
