package junia.airshare.core.dao;

import junia.airshare.core.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightDAO extends JpaRepository<Flight, Long> {

}
