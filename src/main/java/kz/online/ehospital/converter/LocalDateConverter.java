package kz.online.ehospital.converter;

import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String pattern = (String) component.getAttributes().get("pattern");
        LocalDate localDate = null;
        try{
            localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
        }catch (Exception ex){
            throw new ConverterException(ex.getMessage(), ex);
        }
        return localDate;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String pattern = "dd.MM.yyyy";
        String dateTime;
        try{
            dateTime = ((LocalDate) value).format(DateTimeFormatter.ofPattern(pattern));
        }catch (Exception ex){
            throw  new ConverterException(ex);
        }
        return dateTime;
    }

    public String format(LocalDate date){
        if (date == null) return "";
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString();
    }
    public String formatOnlyMonthAndYear(LocalDate date){
        if (date == null) return "";
        return date.format(DateTimeFormatter.ofPattern("MMM-yyyy")).toString();
    }
}
