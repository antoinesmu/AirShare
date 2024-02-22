package junia.airshare.core.service;

import junia.airshare.core.dao.AirportDAO;
import junia.airshare.core.entity.Airport;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Service
@Transactional
public class AirportService {

    private AirportDAO airportDAO;

    public AirportService(AirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    public List<Airport> getAllAirports() { return airportDAO.findAll(); }

    public void saveAirport(Airport airport) { airportDAO.save(airport); }

    public Airport getAirportById(Long id) { return airportDAO.getReferenceById(id); }

}
