package junia.airshare.data;

import junia.airshare.core.entity.Flight;
import junia.airshare.core.entity.Form;
import junia.airshare.core.entity.User;
import junia.airshare.core.service.FlightService;
import junia.airshare.core.service.FormService;
import junia.airshare.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("junia.airshare.core.config");

        final UserService userService = context.getBean(UserService.class);

        final FlightService flightService = context.getBean(FlightService.class);


        cleanDBuser(userService);

        final Map<String, User> users = registerUsers(userService);
        final Map<String, Flight> flights = registerFlight(flightService);

    }

    private static void cleanDBuser(final UserService userService) {
        userService.deleteAll();

    }

    private static Map<String, User> registerUsers(final UserService userService) {
        Map<String, User> users = new HashMap<>();
        users.put("user0", createUser("Admin", "jtblanqui@hotmail.fr", "$argon2i$v=19$m=65536,t=5,p=1$vSP1RFz4ReVSY8gOvvT9RtNAi9xt2j2yvReeH8mQzAQQ3jSnoftwQ+atgAwisDstwyp1OnCNdkk7N27kFLWGeSEsYgvY2xLFfHKephBNoPbV1FprBnpvaatf7ObSRtquOw7JBLSf98fcUBYywWi3lYFJkN3otbrOiaxJimPeYZ8$frb7prQ4VFzqnvALYWGS+qrNAwKesyZViEoveDLLJ9T5gSEUG32Yt82Tz0CI5Ur3RtYv0iE/B5FQtcyEz13/eaib3JOd/qFmxsdhAw+2BFQgxh3+tLdBRQy/trdnFDkKUsyxApnGm7fBRdOOPXXMqYDqG/okhbeaBITseEpLag0", 0, userService));
        users.put("user1", createUser("Zaki", "zaki@gouizi", "$argon2i$v=19$m=65536,t=5,p=1$XaFM64hXgPuRKBWZ58eT+IR4y69KGMZQcxbuTS1v3wVvrnvlDNLkEJYAa4d3KX4Vl4uvjGDZpp+0rs/5SZNAvlVTwylzMKHtBikaKAxhl9FDXskR1I16htM4uFFK6KQEA6TM1+Ku3dnLFxtf5Kuaw+WbJ4SbGHwhz98RRbmNBB4$4LHfRaHBnXtrnwG51LFLlV+g2tjCHAddBoAUpB/qwxSo03eij5zcmURNkF7UXqPdJGuomNE/5mrC2fjfqbfQK5aGeIGCwhm0dJKHcs1NF0HyLflpcsDzbAsBS6psy8dswMMHF0zEo+BLft90cniyQg7r7Bon2eG4saUakThUu20", 1, userService));
        users.put("user2", createUser("request1", "request1@pilot", "$argon2i$v=19$m=65536,t=5,p=1$HZ2qy2mjHw/VCTnAhWGEDUXxSrHMd01c6dw4V8pnmvEizSA6Xtm2jwbVcg3v6kFHnS33+YqRFbhxyaGCJii0hH1df3ZRXaufvttt9sXVAko5Ad1lb8HGuzfobOPigpsf+4QZ9GHAYZAEdGTNh9c0IhDTVfleqpPWu3Trw4/BS94$hyERZuj5MuBJDiWKgjdZ4suS6zDd65HWgV7jQt4JV4QLlFb+Ek0eDPjycmROZshdDzHzoW1BjZm41Kwmv3/+5Gwnsb5GhM3h5DXPaTBOGGjp8+FPyAf8Zt2D5byBuulpf5EEdd6x3Urc2Frn1tfGZO/0Jfft86owA1kAiBwNPVw", 10, userService));
        users.put("user3", createUser("request2", "request2@pilot", "$argon2i$v=19$m=65536,t=5,p=1$HZ2qy2mjHw/VCTnAhWGEDUXxSrHMd01c6dw4V8pnmvEizSA6Xtm2jwbVcg3v6kFHnS33+YqRFbhxyaGCJii0hH1df3ZRXaufvttt9sXVAko5Ad1lb8HGuzfobOPigpsf+4QZ9GHAYZAEdGTNh9c0IhDTVfleqpPWu3Trw4/BS94$hyERZuj5MuBJDiWKgjdZ4suS6zDd65HWgV7jQt4JV4QLlFb+Ek0eDPjycmROZshdDzHzoW1BjZm41Kwmv3/+5Gwnsb5GhM3h5DXPaTBOGGjp8+FPyAf8Zt2D5byBuulpf5EEdd6x3Urc2Frn1tfGZO/0Jfft86owA1kAiBwNPVw", 10, userService));
        users.put("user4", createUser("pilot", "request3@pilot", "$argon2i$v=19$m=65536,t=5,p=1$HZ2qy2mjHw/VCTnAhWGEDUXxSrHMd01c6dw4V8pnmvEizSA6Xtm2jwbVcg3v6kFHnS33+YqRFbhxyaGCJii0hH1df3ZRXaufvttt9sXVAko5Ad1lb8HGuzfobOPigpsf+4QZ9GHAYZAEdGTNh9c0IhDTVfleqpPWu3Trw4/BS94$hyERZuj5MuBJDiWKgjdZ4suS6zDd65HWgV7jQt4JV4QLlFb+Ek0eDPjycmROZshdDzHzoW1BjZm41Kwmv3/+5Gwnsb5GhM3h5DXPaTBOGGjp8+FPyAf8Zt2D5byBuulpf5EEdd6x3Urc2Frn1tfGZO/0Jfft86owA1kAiBwNPVw", 2, userService));

        return users;
    }

    private static Map<String, Flight> registerFlight(final FlightService flightService) {
        Map<String, Flight> flights = new HashMap<>();
        flights.put("flight1", createFlight(new Date(), new Date(), 300, flightService));
        flights.put("flight2", createFlight(new Date(), new Date(), 500, flightService));

        return flights;
    }

    private static User createUser(String userLogin, String email, String password, int status, final UserService userService) {
        User user = new User(userLogin, email, password, status);

        System.out.println("user Registration : "+user.toString());

        userService.saveUser(user);
        return user;
    }

    private static Flight createFlight(Date departureDate, Date arrivalDate, int flightTime, final FlightService flightService) {
        Flight flight = new Flight(departureDate, arrivalDate, flightTime);

        System.out.println("flight Registration : "+flight.toString());


        flightService.saveFlight(flight);

        return flight;

    }

    /*private static Form createForm(String firstname, String lastname, String licence, Date licence_date, String nationality, final FormService formService) {
        Form form = new Form(firstname, lastname, licence, licence_date, nationality);
        form.setUser(new User());

        formService.saveForm(form);
        return form;
    }

    private static Map<String, Form> registerForms(final FormService formService) {
        Map<String, Form> forms = new HashMap<>();
        forms.put("form0", createForm("Jonh", "Doe", "F-LPA008", new Date(), "USA", formService));

        return forms;
    }*/

}