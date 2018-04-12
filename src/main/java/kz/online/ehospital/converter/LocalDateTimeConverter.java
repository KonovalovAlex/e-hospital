package kz.online.ehospital.converter;

import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



@Component
public class LocalDateTimeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String pattern = "dd.MM.yyyy HH:mm";//(String) component.getAttributes().get("pattern");
        LocalDateTime localDateTime = null;
        if (value.toLowerCase().contains("май")){
            value = value.toLowerCase().replaceFirst("май", "05");
            return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        }
        localDateTime = LocalDateTime.parse(value.toLowerCase(), DateTimeFormatter.ofPattern(pattern).withLocale(new Locale("ru")));
        return localDateTime;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String pattern = "dd.MM.yyyy HH:mm";
        String dateTime;
        try{
            dateTime = ((LocalDateTime) value).format(DateTimeFormatter.ofPattern(pattern));
        }catch (Exception ex){
            throw  new ConverterException(ex);
        }
        return dateTime;
    }

    public String format(LocalDateTime dateTime){
        if (dateTime == null) return "";
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")).toString().toLowerCase();
    }

    public String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return null;
        if (pattern == null) {
            pattern = "dd.MM.yyyy HH:mm";
        }
        String resultDateTime;
        try{
            resultDateTime = dateTime.format(DateTimeFormatter.ofPattern(pattern));
        }catch (Exception ex){
            throw  new ConverterException(ex);
        }
        return resultDateTime;
    }

}