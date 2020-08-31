package flight_booking.backend.controllers.ticket;

import flight_booking.backend.controllers.flight.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TicketDto {
   // private Long id;
    private FlightDto flightDto;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private int seatNumber;
    private double totalPrice;
}