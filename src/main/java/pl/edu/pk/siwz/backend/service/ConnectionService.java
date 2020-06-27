package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.controllers.ConnectionController.ConnectionDto;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airline.AirlineRepository;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;
import pl.edu.pk.siwz.backend.models.Connection.Connection;
import pl.edu.pk.siwz.backend.models.Connection.ConnectionRepository;
import pl.edu.pk.siwz.backend.models.Times;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;

    public ConnectionService(ConnectionRepository connectionRepository,
                             AirlineRepository airlineRepository,
                             AirportRepository airportRepository) {

        this.connectionRepository = connectionRepository;
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
    }

    public Connection addNewConnection(ConnectionDto connectionDto) {

        Optional<Airline> airline1 = airlineRepository.findById(connectionDto.getAirlineDto().getId());
        Optional<Airport> srcAirport1 = airportRepository.findById(connectionDto.getSrcAirportDto().getId());
        Optional<Airport> dstAirport1 = airportRepository.findById(connectionDto.getDstAirportDto().getId());

        Connection connection = Connection.builder()
                .srcAirport(srcAirport1.get())
                .dstAirport(dstAirport1.get())
                .airline(airline1.get())
                .times(Times.builder()
                        .departureDate(LocalDate.parse(connectionDto.getDepartureDate()))
                        .arrivalDate(LocalDate.parse(connectionDto.getArrivalDate()))
                        .arrivalTime(LocalTime.parse(connectionDto.getArrivalTime()))
                        .departureTime(LocalTime.parse(connectionDto.getDepartureTime()))
                        .build())
                .numberSeats(connectionDto.getNumberSeats())
                .price(connectionDto.getPrice())
                .build();
        connectionRepository.save(connection);
        return connection;
    }

    public void deleteConnectionWithAirlineId(Long id) {
        connectionRepository.deleteAllConnectionWithAirlineId(id);
    }

    public void deleteConnectionWithAirportId(Long id) {
        connectionRepository.deleteAllConnectionWithAirportId(id);
    }

    public List<Connection> findAll() {
        return connectionRepository.findAll();
    }

    public boolean existsById(Long id) {
        return connectionRepository.existsById(id);
    }

    public void deleteConnection(Long id) {
        connectionRepository.deleteById(id);
    }

    public Optional<Connection> findById(Long id){
       return connectionRepository.findById(id);
    }

    public void save(Connection connection){
        connectionRepository.save(connection);
    }


}
