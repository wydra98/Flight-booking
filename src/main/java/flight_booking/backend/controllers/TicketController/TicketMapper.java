package flight_booking.backend.controllers.TicketController;

import flight_booking.backend.controllers.FlightController.FlightMapper;
import flight_booking.backend.models.Tickets.Ticket;

public class TicketMapper {

    FlightMapper flightMapper = new FlightMapper();

    public TicketDto map(Ticket ticket) {
        return TicketDto.builder()
                .id(ticket.getId())
                .flightDto(flightMapper.map(ticket.getFlight(), ticket.getFlight().getConnection()))
                .purchaseDate(ticket.getPurchaseDate().toString())
                .purchaseTime(ticket.getPurchaseTime().toString())
                .totalPrice(ticket.getPrice())
                .build();
    }
}
