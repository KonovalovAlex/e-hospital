package kz.astonline.ehospital.controller;

import org.springframework.stereotype.Controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@SessionScoped
@Controller
public class MessageController implements Serializable {
    private String messageType;
    static final String  MESSAGE_WIKI = "w";
    static final String  MESSAGE_MAIL = "m";

    public MessageController() {
    }

    public void logout(){
        String message = "logout";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,message,message ));
    }
    public void edit(String action){
        String message = "action" + action;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,message,message ));
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public static String getMessageWiki() {
        return MESSAGE_WIKI;
    }

    public static String getMessageMail() {
        return MESSAGE_MAIL;
    }
}
