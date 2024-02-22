package junia.airshare.web.controller;

import junia.airshare.core.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AirportController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AirportController.class);

    @GetMapping("/pilot/addAirport")
    public String addAirport(HttpSession httpSession) {

        if (httpSession.getAttribute("UserLogged") == null) {
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
                LOGGER.info("\n\n\n----- GET THE PAGE TO ADD AN AIRPORT -----\n\n\n");

                return "addAirport";
            }
        }
    }

    @PostMapping("/pilot/addAirport")
    public String postAirport() {
        return "redirect:/pilot/home";
    }

}