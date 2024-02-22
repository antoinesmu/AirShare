package junia.airshare.web.controller;


import junia.airshare.core.entity.User;
import junia.airshare.core.service.UserService;
import junia.airshare.web.dto.UserDTO;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Named
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class UserAPI implements RestController{

    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/all_users")
    public List<UserDTO> getAllUsers() {

        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userService.findAll();

        for (User user : userList) {

            UserDTO userDTO = new UserDTO(user.getId(), user.getLogin(), user.getEmail(), user.getStatus(), user.getDate());
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @GET
    @Path("/all_users/{userId}")
    public User getUser(@PathParam("userId") long id) {

        return userService.getUserById(id);
    }

    @PUT
    @Path("/admin/upgrade/{userId}")
    public Response UpgradeUserRequest(@PathParam("userId") long userId) {
        User userToUpgrade = userService.getUserById(userId);
        userToUpgrade.setStatus(2);
        userService.saveUser(userToUpgrade);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/admin/decline/{userId}")
    public Response DeclineUserRequest(@PathParam("userId") long userId) {
        User userToDecline = userService.getUserById(userId);
        userToDecline.setStatus(1);
        userService.saveUser(userToDecline);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/UserRequest/{userId}")
    public Response UserRequest(@PathParam("userId") long userId) {
        User UserRequesting = userService.getUserById(userId);
        UserRequesting.setStatus(10);
        userService.saveUser(UserRequesting);

        return Response.status(Response.Status.CREATED).build();
    }

}
