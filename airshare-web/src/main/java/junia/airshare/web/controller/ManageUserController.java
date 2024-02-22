package junia.airshare.web.controller;

import junia.airshare.core.entity.User;
import junia.airshare.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ManageUserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ManageUserController.class);

    private UserService userService;

    public ManageUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "admin/manage_user", method = RequestMethod.GET)
    public String ManageUsersPage(HttpSession httpSession) {

        if (httpSession.getAttribute("UserLogged")  == null) {
            LOGGER.info("\n\n\n----- USER IS NOT CONNECTED -----\n\n\n");
            return "redirect:../login";
        } else {
            User userChecked =(User) httpSession.getAttribute("UserLogged");
            int UserStatus = userChecked.getStatus();
            LOGGER.info("\n\n\n----- STATUS OF THE CONNECTED USER --> "+UserStatus+" -----\n\n\n");

            if (UserStatus != 0) {
                LOGGER.info("\n\n\n----- PAGE FORBIDDEN -----\n\n\n");
                return "forbiddenPage";
            } else {
                LOGGER.info("\n\n\n----- GET THE MANAGEMENT OF THE USERS -----\n\n\n");
                LOGGER.info("\n\n\n----- Listing all the users -----\n\n\n");
                return "manage_user";
            }
        }
    }

    @GetMapping("/admin/all_users")
    public String DisplayAllUsers(HttpSession httpSession, ModelMap modelMap) {

        if (httpSession.getAttribute("UserLogged")  == null) {
            LOGGER.info("\n\n\n----- USER IS NOT CONNECTED -----\n\n\n");
            return "redirect:../login";
        } else {
            User userChecked =(User) httpSession.getAttribute("UserLogged");
            int UserStatus = userChecked.getStatus();
            LOGGER.info("\n\n\n----- STATUS OF THE CONNECTED USER --> "+UserStatus+" -----\n\n\n");

            if (UserStatus != 0) {
                LOGGER.info("\n\n\n----- PAGE FORBIDDEN -----\n\n\n");
                return "forbiddenPage";
            } else {
                LOGGER.info("\n\n\n----- GET THE LIST OF USERS -----\n\n\n");


                modelMap.addAttribute("all_users", userService.getAllUsers());
                return "display_all_users";
            }
        }

    }
}
