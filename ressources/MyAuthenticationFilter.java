package junia.airshare.web.config;


import junia.airshare.core.entity.User;
import junia.airshare.core.service.UserService;
import junia.airshare.web.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/test/admin/manage_user")
public class MyAuthenticationFilter extends GenericFilterBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyAuthenticationFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        LOGGER.info("\n\n\n----- Filter -----\n\n\n");



        LOGGER.info("\n\n\n----- Filter end-----\n\n\n");

        if (true){
            //OK
            chain.doFilter(request, response);
        } else {

            //KO
            httpResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpResponse.getWriter().println("You can not acces this page");
        }
    }

}
