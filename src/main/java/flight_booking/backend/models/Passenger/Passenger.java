package flight_booking.backend.models.Passenger;


import flight_booking.backend.controllers.AirportController.AirportDto;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Trips.Trip;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "passenger_id")
    private Long id;
    private String firstName;
    private String surname;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;

//    @OneToMany(mappedBy = "passenger")
//    private List<Trip> trips;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;


    public void updateForm(String firstName, String surname, String phoneNumber, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
