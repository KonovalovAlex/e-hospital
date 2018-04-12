package kz.online.ehospital.converter;

import kz.online.ehospital.service.EmployeeService;
import kz.online.ehospital.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class UserConverter implements Converter {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value!=null ){
            Long id;
            id = Long.parseLong(value);
            return employeeService.findById(id);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return null;
    }
}
