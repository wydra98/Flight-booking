package flight_booking.backend.models.Passengers;


import flight_booking.backend.models.Tickets.Ticket;
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
    private String pesel;
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
