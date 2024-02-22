package junia.airshare.core.dao;

import junia.airshare.core.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AirportDAO extends JpaRepository<Airport, Long> {


}
