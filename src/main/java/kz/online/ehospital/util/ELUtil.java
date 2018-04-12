package kz.online.ehospital.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Component
@Scope(value = "singleton")
public class ELUtil implements Serializable{

    public String pullValue(String elKey){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getParameter(elKey);
    }

    public Long pullLongValue(String elKey){
        String value = pullValue(elKey);
        if (value == null || value.matches("[^0-9]")) return null;
        return Long.parseLong(value);
    }

    public Integer pullIntValue(String elKey){
        String value = pullValue(elKey);
        if (value == null) return null;
        return Integer.parseInt(value);
    }

}
