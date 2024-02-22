package junia.airshare.web.controller;


import junia.airshare.core.entity.Form;
import junia.airshare.core.service.FormService;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Named
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class UpgradeRequestAPI implements RestController {


    FormService formService;

    public UpgradeRequestAPI(FormService formService) {
        this.formService = formService;
    }

    @GET
    @Path("/requests/all_users")
    public List<Form> getAllUserRequest() {

        return formService.getFormFromUserRequests();
    }

    @POST
    @Path("/requests")
    public Response postForm(Form form) {
        formService.saveForm(form);

        return Response.status(Response.Status.CREATED).build();
    }

}
