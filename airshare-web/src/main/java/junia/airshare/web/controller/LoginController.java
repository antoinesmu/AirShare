package junia.airshare.web.controller;

import junia.airshare.core.entity.User;
import junia.airshare.core.service.UserService;
import junia.airshare.core.utils.MotDePasseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private UserService userDAO;
    public LoginController(UserService userDAO) {
        this.userDAO = userDAO;
    }

    private String feedback = "* required";



    /*--------------------  LOGIN PAGE   --------------------*/

    @GetMapping("/login")
    public String AuthentificationPage(ModelMap model) {
        LOGGER.info("\n\n\n----- GET THE LOGIN PAGE -----\n\n\n");
        model.addAttribute("feedback_sign-in", feedback);
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/login")
    public String LogUser(@ModelAttribute("user") User user, HttpSession httpSession) {

        User checkUser;

        if (user.getEmail() == null) {
            LOGGER.info("\n\n\n----- CONNECTION OF THE USER -----\n\n\n");
            LOGGER.info("\n----- USER IDENTIFICATION : " + user.getLogin() + " -----\n");

            try {
                checkUser = userDAO.findUserByLoginOrEmail(user.getLogin());
                LOGGER.info("\n\n\n----- USER FOUND : " + checkUser.toString() + " -----\n\n\n");

                if (MotDePasseUtils.validerMotDePasse(user.getPassword(), checkUser.getPassword())) {

                    httpSession.setAttribute("UserLogged", checkUser);

                    if (checkUser.getStatus() == 0) {
                        return "redirect:admin/home";
                    } else if (checkUser.getStatus() == 1 || checkUser.getStatus() == 10) {
                        return "redirect:user/home";
                    } else if (checkUser.getStatus() == 2 ) {
                        return "redirect:pilot/home";
                    } else {
                        return "redirect:login";
                    }
                } else {
                    feedback = "Invalid credentials";
                    return "redirect:login";
                }

            } catch (Exception e) {
                LOGGER.info("\n\n\n----- USER NOT FOUND : -----\n\n\n");
                feedback = "User unknown";
                return "redirect:login";

            }

        } else {
            LOGGER.info("\n\n\n----- REGISTRING OF THE USER -----\n\n\n");
            user.setPassword(MotDePasseUtils.genererMotDePasse(user.getPassword()));
            user.setStatus(1);
            userDAO.saveUser(user);
            feedback = "* required";
            return "redirect:login";
        }
    }

    /*--------------------  LOGOUT   --------------------*/

    @GetMapping("/logOut")
    public String LogOut(HttpSession httpSession) {
        httpSession.removeAttribute("UserLogged");

        return "redirect:/";
    }

}
