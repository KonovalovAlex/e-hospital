package kz.astonline.ehospital.controller;



import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Controller
@SpringViewScoped
public class AuthorizationController implements Serializable {

    @Autowired
    private AuthenticationManager authenticationManager;
    private String login;
    private String password;

    public String login() {

        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(this.getLogin(), this.getPassword());
            Authentication result = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(result);
            return "cabinet";
        } catch (AuthenticationException e) {
            String errorMessage = "employee.authorization.failed";
            FacesContext.getCurrentInstance().addMessage("authorizationForm", new FacesMessage(errorMessage, errorMessage));
            login = null;
            return null;
        }
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
