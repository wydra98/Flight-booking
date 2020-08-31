package flight_booking.backend.loaders;

import flight_booking.backend.repository.AirportRepository;
import flight_booking.backend.repository.ConnectionRepository;
import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Connection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class ConnectionLoader implements CommandLineRunner {

    ConnectionRepository connectionRepository;
    AirportRepository airportRepository;

    ConnectionLoader(ConnectionRepository connectionRepository,
                     AirportRepository airportRepository) {
        this.connectionRepository = connectionRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (connectionRepository.amountOfRows() == 0) {

            // ALL AIRPORTS
            Optional<Airport> airport1 = airportRepository.findById(1L);
            Optional<Airport> airport2 = airportRepository.findById(2L);
            Optional<Airport> airport3 = airportRepository.findById(3L);
            Optional<Airport> airport4 = airportRepository.findById(4L);
            Optional<Airport> airport5 = airportRepository.findById(5L);
            Optional<Airport> airport6 = airportRepository.findById(6L);
            Optional<Airport> airport7 = airportRepository.findById(7L);
            Optional<Airport> airport8 = airportRepository.findById(8L);
            Optional<Airport> airport9 = airportRepository.findById(9L);
            Optional<Airport> airport10 = airportRepository.findById(10L);
            Optional<Airport> airport11 = airportRepository.findById(11L);
            Optional<Airport> airport12 = airportRepository.findById(12L);
            Optional<Airport> airport13 = airportRepository.findById(13L);
            Optional<Airport> airport14 = airportRepository.findById(14L);
            Optional<Airport> airport15 = airportRepository.findById(15L);
            Optional<Airport> airport16 = airportRepository.findById(16L);
            Optional<Airport> airport17 = airportRepository.findById(17L);
            Optional<Airport> airport18 = airportRepository.findById(18L);
            Optional<Airport> airport19 = airportRepository.findById(19L);
            Optional<Airport> airport20 = airportRepository.findById(20L);

            // 1. FROM NEW YORK TO CHICAGO
            if (airport1.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 2. FROM CHICAGO TO NEW YORK
            if (airport2.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 3. FROM NEW YORK TO WARSAW
            if (airport1.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 4. FROM WARSAW TO NEW YORK
            if (airport3.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 5. FROM NEW YORK TO PEKIN
            if (airport1.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 6. FROM PEKIN TO NEW YORK
            if (airport4.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 7. FROM PEKIN TO CHICAGO
            if (airport4.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 8. FROM CHICAGO TO PEKIN
            if (airport2.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 9. FROM PEKIN TO WARSAW
            if (airport4.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 10. FROM WARSAW TO PEKIN
            if (airport3.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 11. FROM CHICAGO TO BERLIN
            if (airport2.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 12. FROM BERLIN TO CHICAGO
            if (airport5.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 13. FROM WARSAW TO BERLIN
            if (airport3.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 14. FROM BERLIN TO WARSAW
            if (airport5.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 15. FROM WARSAW TO CHICAGO
            if (airport3.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 16. FROM CHICAGO TO WARSAW
            if (airport2.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 17. FROM SZANGHAI TO NEW YORK
            if (airport6.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 18. FROM NEW YORK TO SZANGHAI
            if (airport1.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 19. FROM SZANGHAI TO PEKIN
            if (airport6.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 20. FROM PEKINU TO SZANGHAI
            if (airport4.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 21. FROM SZANGHAI TO TORONTO
            if (airport6.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 22. FROM TORONTO TO SZANGHAI
            if (airport7.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 23. FROM SZANGHAI TO SYDNEY
            if (airport6.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 24. FROM SYDNEY TO SZANGHAI
            if (airport8.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 25. FROM TORONTO TO PEKIN
            if (airport7.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 26. FROM PEKIN TO TORONTO
            if (airport4.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 27. FROM TORONTO TO CHICAGO
            if (airport7.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 28. FROM CHICAGO TO TORONTO
            if (airport2.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 29. FROM TORONTO TO SYDNEY
            if (airport7.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 30. FROM SYDNEY TO TORONTO
            if (airport8.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 31. FROM SYDNEY TO BERLIN
            if (airport8.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 32. FROM BERLIN TO SYDNEY
            if (airport5.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 33. FROM SYDNEY TO TOKYO
            if (airport8.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 34. FROM TOKYO TO SYDNEY
            if (airport9.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 35. FROM TOKYO TO BERLIN
            if (airport9.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 36. FROM BERLINA TO TOKYO
            if (airport5.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 37. FROM TOKYO TO RIO DE JANEIRO
            if (airport9.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 38. FROM RIO DE JANEIRO TO TOKYO
            if (airport10.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 39. FROM RIO DE JANEIRO TO BERLIN
            if (airport10.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 40. FROM BERLIN TO RIO DE JANEIRO
            if (airport5.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 41. FROM RIO DE JANEIRO TO LOS ANGELES
            if (airport10.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 42. FROM LOS ANGELES TO RIO DE JANEIRO
            if (airport15.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 43. FROM RIO DE JANEIRO TO OSLO
            if (airport10.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 44. FROM OSLO TO RIO DE JANEIRO
            if (airport11.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 45. FROM RIO DE JANEIRO TO BUENOS AIRES
            if (airport10.isPresent() && airport12.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport12.get())
                        .build());
            }

            // 46. FROM BUENOS AIRES TO RIO DE JANEIRO
            if (airport12.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport12.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 47. FROM OSLO TO BUENOS AIRES
            if (airport11.isPresent() && airport12.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport12.get())
                        .build());
            }

            // 48. FROM BUENOS AIRES TO OSLO
            if (airport12.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport12.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 49. FROM OSLO TO PARIS
            if (airport11.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 50. FROM PARIS TO OSLO
            if (airport13.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 51. FROM OSLO TO LONDON
            if (airport11.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 52. FROM LONDON TO OSLO
            if (airport14.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 53. FROM OSLO TO LOS ANGELES
            if (airport11.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 54. FROM LOS ANGELES TO OSLO
            if (airport15.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 55. FROM BUENOS AIRES TO PARIS
            if (airport12.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport12.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 56. FROM PARIS TO BUENOS AIRES
            if (airport13.isPresent() && airport12.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport12.get())
                        .build());
            }

            // 57. FROM PARIS TO LONDON
            if (airport13.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 58. FROM LONDON TO PARIS
            if (airport14.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 59. FROM LONDON TO TORONTO
            if (airport14.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 60. FROM TORONTO TO LONDON
            if (airport7.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 61. FROM LONDON TO CAIRO
            if (airport14.isPresent() && airport17.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport17.get())
                        .build());
            }

            // 62. FROM CAIRO TO LONDON
            if (airport17.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport17.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 63. FROM LONDON TO MOSCOW
            if (airport14.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 64. FROM MOSCOW TO LONDON
            if (airport16.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 65. FROM LONDON TO WARSAW
            if (airport14.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 66. FROM WARSAW TO LONDON
            if (airport3.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 67. FROM LONDON TO LOS ANGELES
            if (airport14.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 68. FROM LOS ANGELES TO LONDON
            if (airport15.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 69. FROM LOS ANGELES TO BERLIN
            if (airport15.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 70. FROM BERLIN TO LOS ANGELES
            if (airport5.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 71. FROM LOS ANGELES TO CHICAGO
            if (airport15.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 72. FROM CHICAGO TO LOS ANGELES
            if (airport2.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 73. FROM LOS ANGELES TO WARSAW
            if (airport15.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 74. FROM WARSAW TO LOS ANGELES
            if (airport3.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 75. FROM LOS ANGELES TO KIEV
            if (airport15.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 76. FROM KIEV TO LOS ANGELES
            if (airport20.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 77. FROM MOSCOW TO DELHI
            if (airport16.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 78. FROM DELHI TO MOSCOW
            if (airport19.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 79. FROM MOSCOW TO CRACOW
            if (airport16.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 80. FROM CRACOW TO MOSCOW
            if (airport18.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 81. FROM MOSCOW TO NEW YORK
            if (airport16.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 82. FROM NEW YORK TO MOSCOW
            if (airport1.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 83. FROM MOSCOW TO WARSAW
            if (airport16.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 84. FROM WARSAW TO MOSCOW
            if (airport3.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 85. FROM MOSCOW TO LOS ANGELES
            if (airport16.isPresent() && airport15.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport15.get())
                        .build());
            }

            // 86. FROM LOS ANGELES TO MOSCOW
            if (airport15.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport15.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 87. FROM CAIRO TO DELHI
            if (airport17.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport17.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 88. FROM DELHI TO CAIRO
            if (airport19.isPresent() && airport17.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport17.get())
                        .build());
            }

            // 89. FROM CAIRO TO CRACOW
            if (airport17.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport17.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 90. FROM CRACOW TO CAIRO
            if (airport18.isPresent() && airport17.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport17.get())
                        .build());
            }

            // 91. FROM CRACOW TO DELHI
            if (airport18.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 92. FROM DELHI TO CRACOW
            if (airport19.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 93. FROM CRACOW TO KIEV
            if (airport18.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 94. FROM KIEV TO CRACOW
            if (airport20.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 95. FROM CRACOW TO NEW YORK
            if (airport18.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 96. FROM NEW YORK TO CRACOW
            if (airport1.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 97. FROM DELHI TO KIEV
            if (airport19.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 98. FROM KIEV TO DELHI
            if (airport20.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 99. FROM KIEV TO NEW YORK
            if (airport20.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 100. FROM NEW YORK TO KIEV
            if (airport1.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 101. FROM PEKIN TO CRACOW
            if (airport4.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 102. FROM CRACOW TO PEKIN
            if (airport18.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 103. FROM SZANGHAI TO DELHI
            if (airport6.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 104. FROM DELHI TO SZANGHAI
            if (airport19.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 105. FROM CHICAGO TO KIEV
            if (airport2.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 106. FROM KIEV TO CHICAGO
            if (airport20.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 107. FROM NEW YORK TO OSLO
            if (airport1.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 108. FROM OSLO TO NEW YORK
            if (airport11.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 109. FROM SZANGHAI TO BERLIN
            if (airport6.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 110. FROM BERLIN TO SZANGHAI
            if (airport5.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 111. FROM PEKIN TO TOKIO
            if (airport4.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 112. FROM TOKIO TO PEKIN
            if (airport9.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 113. FROM TOKIO TO LONDON
            if (airport9.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 114. FROM LONDON TO TOKIO
            if (airport14.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 115. FROM CAIRO TO BERLIN
            if (airport17.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport17.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 116. FROM BERLIN TO CAIRO
            if (airport5.isPresent() && airport17.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 117. FROM CAIRO TO SZANGHAI
            if (airport17.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport17.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 118. FROM SZANGHAI TO CAIRO
            if (airport6.isPresent() && airport17.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport17.get())
                        .build());
            }

            // 119. FROM PARIS TO MOSCOW
            if (airport13.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 120. FROM MOSCOW TO PARIS
            if (airport16.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 121. FROM SYDNEY TO CHICAGO
            if (airport8.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 122. FROM CHICAGO TO SYDNEY
            if (airport2.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 123. FROM KIEV TO MOSCOW
            if (airport20.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 124. FROM MOSCOW TO KIEV
            if (airport16.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 125. FROM WARSAW TO CRACOW
            if (airport3.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 126. FROM CRACOW TO WARSAW
            if (airport18.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 127. FROM BERLIN TO OSLO
            if (airport5.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 128. FROM OSLO TO BERLIN
            if (airport11.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 129. FROM TOKIO TO PARIS
            if (airport9.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 130. FROM PARIS TO TOKIO
            if (airport13.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 131. FROM BERLIN TO PARIS
            if (airport5.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 132. FROM PARIS TO BERLIN
            if (airport13.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 133. FROM PEKIN TO LONDON
            if (airport4.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 134. FROM LONDON TO PEKIN
            if (airport14.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 135. FROM LONDON TO TOKIO
            if (airport14.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 136. FROM TOKIO TO LONDON
            if (airport9.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 137. FROM CRACOW TO PARIS
            if (airport18.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 138. FROM PARIS TO CRACOW
            if (airport13.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 139. FROM PEKIN TO PARIS
            if (airport4.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 140. FROM PARIS TO PEKIN
            if (airport13.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 141. FROM NEW YORK TO PARIS
            if (airport1.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 142. FROM PARIS TO NEW YORK
            if (airport13.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 143. FROM WARSAW TO PARIS
            if (airport3.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 144. FROM PARIS TO WARSAW
            if (airport13.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 145. FROM RIO DE JANEIRO TO PARIS
            if (airport10.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 146. FROM PARIS TO RIO DE JANEIRO
            if (airport13.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 147. FROM CHICAGO TO PARIS
            if (airport2.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 148. FROM PARIS TO CHICAGO
            if (airport13.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 149. FROM TORONTO TO PARIS
            if (airport7.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 150. FROM PARIS TO TORONTO
            if (airport13.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 151. FROM TOKIO TO SZANGHAI
            if (airport9.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 152. FROM SZANGHAI TO TOKIO
            if (airport6.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 153. FROM TORONTO TO NEW YORK
            if (airport7.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 154. FROM NEW YORK TO TORONTO
            if (airport1.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 155. FROM TORONTO TO DELHI
            if (airport7.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 156. FROM DELHI TO TORONTO
            if (airport19.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 157. FROM WARSAW TO KIEV
            if (airport3.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 158. FROM KIEV TO WARSAW
            if (airport20.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 159. FROM KIEV TO KAIR
            if (airport20.isPresent() && airport17.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport17.get())
                        .build());
            }

            // 160. FROM KAIR TO KIEV
            if (airport17.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport17.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 161. FROM DELHI TO PARIS
            if (airport19.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 162. FROM PARIS TO DELHI
            if (airport13.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 163. FROM DELHI TO LONDON
            if (airport19.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport19.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 164. FROM LONDON TO DELHI
            if (airport14.isPresent() && airport19.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport19.get())
                        .build());
            }

            // 165. FROM NEW YORK TO RIO DE JANEIRO
            if (airport1.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport1.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 166. FROM RIO DE JANEIRO TO NEW YORK
            if (airport10.isPresent() && airport1.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport1.get())
                        .build());
            }

            // 167. FROM MOSCOW TO SYDNEY
            if (airport16.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 168. FROM SYDNEY TO MOSCOW
            if (airport8.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 169. FROM WARSAW TO OSLO
            if (airport3.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport3.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 170. FROM OSLO TO WARSAW
            if (airport11.isPresent() && airport3.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport3.get())
                        .build());
            }

            // 171. FROM CRACOW TO OSLO
            if (airport18.isPresent() && airport11.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport11.get())
                        .build());
            }

            // 172. FROM OSLO TO CRACOW
            if (airport11.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport11.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 173. FROM CHICAGO TO TOKIO
            if (airport2.isPresent() && airport9.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport9.get())
                        .build());
            }

            // 174. FROM TOKIO TO CHICAGO
            if (airport9.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport9.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 175. FROM SYDNEY TO RIO DE JANEIRO
            if (airport8.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 176. FROM RIO DE JANEIRO TO SYDNEY
            if (airport10.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 177. FROM LONDON TO BUENOS AIRES
            if (airport14.isPresent() && airport12.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport12.get())
                        .build());
            }

            // 178. FROM BUENOS AIRES TO LONDON
            if (airport12.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport12.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 179. FROM BERLIN TO PARIS
            if (airport5.isPresent() && airport13.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport13.get())
                        .build());
            }

            // 180. FROM PARIS TO BERLIN
            if (airport13.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport13.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 181. FROM KIEV TO RIO DE JANEIRO
            if (airport20.isPresent() && airport10.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport20.get())
                        .dstAirport(airport10.get())
                        .build());
            }

            // 182. FROM RIO DE JANEIRO TO KIEV
            if (airport10.isPresent() && airport20.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport10.get())
                        .dstAirport(airport20.get())
                        .build());
            }

            // 183. FROM SZANGHAI TO LONDON
            if (airport6.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport6.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 184. FROM LONDON TO SZANHGAI
            if (airport14.isPresent() && airport6.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport6.get())
                        .build());
            }

            // 185. FROM PEKIN TO CRACOW
            if (airport4.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 186. FROM CRACOW TO PEKIN
            if (airport18.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 187. FROM PEKIN TO MOSCOW
            if (airport4.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport16.get())
                        .build());
            }

            // 188. FROM MOSCOW TO PEKIN
            if (airport16.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 189. FROM PEKIN TO BERLIN
            if (airport4.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport4.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 190. FROM BERLIN TO PEKIN
            if (airport5.isPresent() && airport4.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport4.get())
                        .build());
            }

            // 191. FROM CRACOW TO LONDON
            if (airport18.isPresent() && airport14.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport18.get())
                        .dstAirport(airport14.get())
                        .build());
            }

            // 192. FROM LONDON TO CRACOW
            if (airport14.isPresent() && airport18.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport14.get())
                        .dstAirport(airport18.get())
                        .build());
            }

            // 193. FROM SYDNEY TO KAIR
            if (airport17.isPresent() && airport8.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport17.get())
                        .dstAirport(airport8.get())
                        .build());
            }

            // 194. FROM KAIR TO SYDNEY
            if (airport8.isPresent() && airport17.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport8.get())
                        .dstAirport(airport17.get())
                        .build());
            }

            // 195. FROM TORONTO TO BUENOS AIRES
            if (airport7.isPresent() && airport12.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport7.get())
                        .dstAirport(airport12.get())
                        .build());
            }

            // 196. FROM BUENOS AIRES TO TORONTO
            if (airport12.isPresent() && airport7.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport12.get())
                        .dstAirport(airport7.get())
                        .build());
            }

            // 197. FROM CHICAGO TO BUENOS AIRES
            if (airport2.isPresent() && airport12.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport2.get())
                        .dstAirport(airport12.get())
                        .build());
            }

            // 198. FROM BUENOS AIRES TO CHICAGO
            if (airport12.isPresent() && airport2.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport12.get())
                        .dstAirport(airport2.get())
                        .build());
            }

            // 199. FROM MOSCOW TO BERLIN
            if (airport16.isPresent() && airport5.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport16.get())
                        .dstAirport(airport5.get())
                        .build());
            }

            // 200. FROM BERLIN TO MOSCOW
            if (airport5.isPresent() && airport16.isPresent()) {
                connectionRepository.save(Connection.builder()
                        .srcAirport(airport5.get())
                        .dstAirport(airport16.get())
                        .build());
            }
        }
    }
}