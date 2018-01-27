package kz.astonline.ehospital.converter.datetime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = false)
public class LocalDatePersistenceConverter implements
        AttributeConverter<LocalDate, Date>, Serializable {
    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
        return java.sql.Date.valueOf(entityValue);
    }

    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
        return databaseValue.toLocalDate();
    }
}