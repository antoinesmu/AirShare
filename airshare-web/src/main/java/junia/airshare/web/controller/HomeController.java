package junia.airshare.web.controller;

import junia.airshare.core.entity.User;
import junia.airshare.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private UserService userDAO;
    public HomeController(UserService userDAO) {
        this.userDAO = userDAO;
    }

    /*--------------------  HOME PAGE   --------------------*/
    @GetMapping("/")
    public String Home(){
        return "home";
    }


    /*--------------------  HOME PAGE ADMIN   --------------------*/
    @GetMapping("/admin/home")
    public String HomeAdmin(HttpSession httpSession){

        if (httpSession.getAttribute("UserLogged") == null ) {
            LOGGER.info("\n\n\n----- USER IS NOT CONNECTED -----\n\n\n");
            return "redirect:../login";
        } else {
            User userChecked = (User) httpSession.getAttribute("UserLogged");
            int UserStatus = userChecked.getStatus();
            LOGGER.info("\n\n\n----- STATUS OF THE CONNECTED USER --> " + UserStatus + " -----\n\n\n");

            if (UserStatus != 0) {
                LOGGER.info("\n\n\n----- PAGE FORBIDDEN -----\n\n\n");
                return "forbiddenPage";
            } else {
                LOGGER.info("\n\n\n----- GET THE HOMEPAGE OF THE ADMIN -----\n\n\n");
                return "homePageAdmin";
            }
        }
    }

    @PostMapping("/admin/home")
    public String LogOutAdmin(HttpSession httpSession) {

        httpSession.removeAttribute("UserLogged");

        return "redirect:../login";
    }

    /*--------------------  HOME PAGE USER   --------------------*/
    @GetMapping("/user/home")
    public String HomeUser(HttpSession httpSession) {

        if (httpSession.getAttribute("UserLogged") == null ) {
            LOGGER.info("\n\n\n----- USER IS NOT CONNECTED -----\n\n\n");
            return "redirect:../login";
        } else {
            User userChecked = (User) httpSession.getAttribute("UserLogged");
            int UserStatus = userChecked.getStatus();
            LOGGER.info("\n\n\n----- STATUS OF THE CONNECTED USER --> " + UserStatus + " -----\n\n\n");

            if (UserStatus != 1 && UserStatus != 10) {
                LOGGER.info("\n\n\n----- PAGE FORBIDDEN -----\n\n\n");
                return "forbiddenPage";
            } else {
                LOGGER.info("\n\n\n----- GET THE HOMEPAGE OF THE USER -----\n\n\n");
                return "homePageUser";
            }
        }
    }

    @PostMapping("/user/home")
    public String LogOutUser(HttpSession httpSession) {

        httpSession.removeAttribute("UserLogged");

        return "redirect:../login";
    }

    /*--------------------  HOME PAGE PILOT   --------------------*/
    @GetMapping("/pilot/home")
    public String HomePilot(HttpSession httpSession){

        if (httpSession.getAttribute("UserLogged") == null ) {
            LOGGER.info("\n\n\n----- USER IS NOT CONNECTED -----\n\n\n");
            return "redirect:../login";
        } else {
            User userChecked = (User) httpSession.getAttribute("UserLogged");
            int UserStatus = userChecked.getStatus();
            LOGGER.info("\n\n\n----- STATUS OF THE CONNECTED USER --> " + UserStatus + " -----\n\n\n");

            if (UserStatus != 2) {
                LOGGER.info("\n\n\n----- PAGE FORBIDDEN -----\n\n\n");
                return "forbiddenPage";
            } else {
                LOGGER.info("\n\n\n----- GET THE HOMEPAGE OF THE PILOT -----\n\n\n");
                return "homePagePilot";
            }
        }
    }

    @PostMapping("/pilot/home")
    public String LogOutPilot(HttpSession httpSession) {

        httpSession.removeAttribute("UserLogged");

        return "redirect:../login";
    }
}
