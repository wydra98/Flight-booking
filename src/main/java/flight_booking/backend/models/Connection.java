package flight_booking.backend.models;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import flight_booking.backend.models.Airport;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "connections")
public class Connection {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "connection_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_src_airport")
    private Airport srcAirport;
    @ManyToOne
    @JoinColumn(name = "id_dst_airport")
    private Airport dstAirport;

    public void updateForm(Airport srcAirport, Airport dstAirport) {
        this.srcAirport = srcAirport;
        this.dstAirport = dstAirport;
    }
}
