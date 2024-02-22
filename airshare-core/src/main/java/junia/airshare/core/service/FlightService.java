package junia.airshare.core.service;

import junia.airshare.core.dao.FlightDAO;
import junia.airshare.core.entity.Flight;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Service
@Transactional
public class FlightService {

    private FlightDAO flightDAO;

    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public List<Flight> getAllFlights() { return flightDAO.findAll(); }

    public void saveFlight(Flight flight) { flightDAO.save(flight); }

    public void deleteAll() { flightDAO.deleteAll(); }
}
