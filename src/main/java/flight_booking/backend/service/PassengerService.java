package flight_booking.backend.service;

import flight_booking.backend.controllers.PassengerController.PassengerDto;
import flight_booking.backend.models.Passenger.Passenger;
import flight_booking.backend.models.Passenger.PassengerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Passenger addNewPassenger(PassengerDto passengerDto) {

        Passenger passenger = Passenger.builder()
                .firstName(passengerDto.getFirstName())
                .surname(passengerDto.getSurname())
                .dateOfBirth(LocalDate.parse(passengerDto.getDateOfBirth()))
                .phoneNumber(passengerDto.getPhoneNumber())
                .email(passengerDto.getEmail())
                .build();
        passengerRepository.save(passenger);

        return passenger;
    }

    public boolean checkIfPassengerExists(String email, String phoneNumber) {
        if (passengerRepository.checkIfPassengerExistsThroughEmail(email) > 0
                || passengerRepository.checkIfPassengerExistsThroughPhoneNumber(phoneNumber) > 0)
            return true;
        else
            return false;

    }

    public boolean existsById(Long id) {
        if (passengerRepository.existsById(id))
            return true;
        else
            return false;
    }

    public void deleteConnection(Long id) {
        passengerRepository.deleteById(id);
    }

}
