package junia.airshare.web.controller;

import junia.airshare.core.entity.User;
import junia.airshare.core.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;

@Controller
public class FlightController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    /*--------------------  CREATE FLIGHT PAGE   --------------------*/
    @GetMapping("/pilot/addFlight")
    public String addFlight(HttpSession httpSession) {

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
                LOGGER.info("\n\n\n----- GET THE PAGE TO ADD A FLIGHT -----\n\n\n");

                return "addFlight";
            }
        }
    }

    @PostMapping("/pilot/addFlight")
    public String postFlight() {
        return "redirect:/pilot/home";
    }

    @GetMapping("showFlights")
    public String getFlights(HttpSession httpSession, ModelMap modelMap) {

        if (httpSession.getAttribute("UserLogged") == null) {
            LOGGER.info("\n\n\n----- USER IS NOT CONNECTED -----\n\n\n");
            return "redirect:../login";
        } else {
            User userChecked = (User) httpSession.getAttribute("UserLogged");
            int UserStatus = userChecked.getStatus();
            LOGGER.info("\n\n\n----- STATUS OF THE CONNECTED USER --> " + UserStatus + " -----\n\n\n");

            if (UserStatus == 1) {
                modelMap.addAttribute("all_flights", flightService.getAllFlights());

                return "displayFlightsUser";
            } else if (UserStatus == 2) {
                LOGGER.info("\n\n\n----- GET THE PAGE TO ADD A FLIGHT -----\n\n\n");
                modelMap.addAttribute("all_flights", flightService.getAllFlights());
                return "displayFlightsPilot";

            }else {
                LOGGER.info("\n\n\n----- PAGE FORBIDDEN -----\n\n\n");

                return "forbiddenPage";
            }

        }
    }
}
