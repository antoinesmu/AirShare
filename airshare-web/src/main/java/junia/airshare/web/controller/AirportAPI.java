package junia.airshare.web.controller;

import junia.airshare.core.entity.Airport;
import junia.airshare.core.service.AirportService;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Named
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class AirportAPI implements RestController {

    AirportService airportService;

    public AirportAPI(AirportService airportService) {
        this.airportService = airportService;
    }

    @POST
    @Path("/pilot/addAirport")
    public Response addAirport(Airport airport) {
        airportService.saveAirport(airport);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/allAirports")
    public List<Airport> getAllAirports() {

        return airportService.getAllAirports();
    }


}
