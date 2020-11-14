package flight_booking.backend.services;

import flight_booking.backend.models.Airline;
import flight_booking.backend.repository.AirlineRepository;
import org.springframework.stereotype.Service;
import flight_booking.backend.controllers.airline.AirlineDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository repository;

    public AirlineService(AirlineRepository repository) {
        this.repository = repository;
    }

    public List<Airline> findAll() {
        return repository.findAll();
    }

    public Optional<Airline> findById(Long id) {
        return repository.findById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean checkIfAirlineExists(AirlineDto airlineDto) {
        return repository.checkIfAirlineExists(airlineDto.getName(), airlineDto.getCountry()) > 0;
    }

    public void validateNewAirline(AirlineDto airlineDto) {
        if (checkIfAirlineExists(airlineDto)) {
            throw new IllegalStateException("Taka linia lotnicza istnieje już w bazie!");
        }
    }

    public void validateId(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Taka linia lotnicza nie istnieje w bazie!");
        }
    }

    public Airline addNewAirline(AirlineDto airlineDto) {
        Airline airline = Airline.builder()
                .name(airlineDto.getName())
                .country(airlineDto.getCountry())
                .build();

        repository.save(airline);
        return airline;
    }

    public Airline save(Airline airline) {
        return repository.save(airline);
    }

    public void deleteAirline(Airline airline) {
        repository.deleteById(airline.getId());
    }
}
