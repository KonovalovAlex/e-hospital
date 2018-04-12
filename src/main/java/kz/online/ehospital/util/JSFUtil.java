package kz.online.ehospital.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

public class JSFUtil implements Serializable{

    public void redirect(String url){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findSentParameter(String parameterName){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().
                getRequest();
        return request.getParameter(parameterName);
    }

    public Long findSentLongParameter(String parameterName){
        if (parameterName == null) return null;
        if (parameterName.isEmpty()) return null;
        Long result = null;
        try {
            result =  Long.parseLong(findSentParameter(parameterName));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return result;
    }

    public int findSentIntParameter(String parameterName){
        return Integer.parseInt(findSentParameter(parameterName));
    }

}
