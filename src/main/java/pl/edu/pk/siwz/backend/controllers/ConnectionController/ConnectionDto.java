package pl.edu.pk.siwz.backend.controllers.ConnectionController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ConnectionDto {
    private Long srcAirportId;
    private Long dstAirportId;
    private Long airlineId;
    private int numberSeats;
    private String departureDate;
    private String arrivalDate;
    private String departureTime;
    private String arrivalTime;
    private double price;
}
