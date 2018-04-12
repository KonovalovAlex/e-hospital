package kz.online.ehospital.converter;

import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Component
public class LocalTimeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        value = value.trim();
        String pattern = (String) component.getAttributes().get("pattern");
        LocalTime localTime;

        localTime = LocalTime.parse(value, DateTimeFormatter.ofPattern(pattern));
        return localTime;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String pattern = "HH:mm";
        String time;
        try{
            time = ((LocalTime) value).format(DateTimeFormatter.ofPattern(pattern));
        }catch (Exception ex){
            throw  new ConverterException(ex);
        }
        return time;
    }

    public String format(LocalTime time, String pattern) {
        if (pattern == null) {
            pattern = "HH:mm";
        }
        String resultTime;
        try{
            resultTime = time.format(DateTimeFormatter.ofPattern(pattern));
        }catch (Exception ex){
            throw  new ConverterException(ex);
        }
        return resultTime;
    }

}