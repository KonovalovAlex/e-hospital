package kz.online.ehospital.converter.datetime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = false)
public class LocalDateTimePersistenceConverter implements
        AttributeConverter<LocalDateTime, Timestamp>, Serializable {
    @Override
    public java.sql.Timestamp convertToDatabaseColumn(
            LocalDateTime entityValue) {
        return Timestamp.valueOf(entityValue);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(
            java.sql.Timestamp databaseValue) {
        return databaseValue.toLocalDateTime();
    }
}