package kz.online.ehospital.model;

import kz.online.ehospital.enumiration.AlertStatus;
import kz.online.ehospital.model.base.BaseEntity;
import kz.online.ehospital.enumiration.AlertStatus;
import kz.online.ehospital.model.base.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @DynamicUpdate @DynamicInsert
@Table(name = "ALERT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alert extends BaseEntity {

    @Column
    private LocalDateTime date;

    @Column
    private LocalDateTime dateOfResponse;

    @Column(length=1024)
    private String description;

    @Column
    private AlertStatus alertStatus;



    @ManyToOne
    @JoinColumn(name = "RECIPIENT", referencedColumnName = "ID")
    private Employee recipient;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Employee getRecipient() {
        return recipient;
    }

    public void setRecipient(Employee recipient) {
        this.recipient = recipient;
    }

    public AlertStatus getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(AlertStatus alertStatus) {
        this.alertStatus = alertStatus;
    }

    public LocalDateTime getDateOfResponse() {
        return dateOfResponse;
    }

    public void setDateOfResponse(LocalDateTime dateOfResponse) {
        this.dateOfResponse = dateOfResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alert)) return false;
        Alert alert = (Alert) o;
        if (description != null ? !description.equals(alert.description) : alert.description != null) return false;
//        if (medicalCard != null ? !medicalCard.equals(alert.medicalCard) : alert.medicalCard != null) return false;
//        if (recipient != null ? !recipient.equals(alert.recipient) : alert.recipient != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (dateOfResponse != null ? dateOfResponse.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);

        result = 31 * result + (recipient != null ? recipient.hashCode() : 0);
        return result;
    }
}
