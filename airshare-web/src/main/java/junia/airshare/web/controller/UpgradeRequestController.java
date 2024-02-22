package junia.airshare.web.controller;

import junia.airshare.core.entity.Form;
import junia.airshare.core.entity.User;
import junia.airshare.core.service.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;

@Controller
public class UpgradeRequestController {

    FormService formService;

    public UpgradeRequestController(FormService formService) {
        this.formService = formService;
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(UpgradeRequestController.class);


    @GetMapping("/user/upgrade")
    public String UpgradeUser(Model model, HttpSession httpSession) {

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
                LOGGER.info("\n\n\n----- GET THE REQUEST PAGE TO BECOME PILOT -----\n\n\n");
                model.addAttribute("userId", ((User) httpSession.getAttribute("UserLogged")).getId());
                return "upgradeRequest";
            }
        }
    }

}
