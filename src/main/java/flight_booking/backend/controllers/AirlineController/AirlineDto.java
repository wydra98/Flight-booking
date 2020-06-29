package flight_booking.backend.controllers.AirlineController;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AirlineDto {
    private Long id;
    private String name;
}