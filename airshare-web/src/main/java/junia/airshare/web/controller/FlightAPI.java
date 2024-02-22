package junia.airshare.web.controller;

import junia.airshare.core.entity.Flight;
import junia.airshare.core.service.FlightService;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Named
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class FlightAPI implements RestController{

    FlightService flightService;

    public FlightAPI(FlightService flightService) {
        this.flightService = flightService;
    }

    @POST
    @Path("/pilot/addFlight")
    public Response addFlyght(Flight flight) {
        flightService.saveFlight(flight);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/allFlights")
    public List<Flight> getAllFlights() {

        return flightService.getAllFlights();
    }

}
