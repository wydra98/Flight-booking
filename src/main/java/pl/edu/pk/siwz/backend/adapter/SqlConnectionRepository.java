package pl.edu.pk.siwz.backend.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pk.siwz.backend.models.Connection.Connection;
import pl.edu.pk.siwz.backend.models.Connection.ConnectionRepository;


public interface SqlConnectionRepository extends ConnectionRepository, JpaRepository<Connection, Long> {

    @Query(value = "SELECT COUNT (c.connection_id) FROM connections c", nativeQuery = true)
    int amountOfRows();
}
