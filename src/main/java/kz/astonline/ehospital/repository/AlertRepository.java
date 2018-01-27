package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.enumiration.AlertStatus;
import kz.astonline.ehospital.model.Alert;
import kz.astonline.ehospital.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.time.LocalDateTime;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert,Long> {

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("Select en from Alert en where en.recipient = :employee and en.alertStatus = :status")
    public List<Alert> getAllAlertsForEmployeeByStatus(@Param("employee") Employee employee, @Param("status") AlertStatus status);


    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("Select en from Alert en where en.recipient = :employee")
    public List<Alert> getAllAlertsForEmployee(@Param("employee") Employee employee);



    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("Select en from Alert en where en.alertStatus = :status")
    public List<Alert> getAllAlertsByStatus(@Param("status") AlertStatus status);

    @Modifying
    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("Delete from Alert a where a.date < :localDateTime")
     public void deleteByDate(@Param("localDateTime") LocalDateTime localDateTime);

//    @Query("Select en from Alert en where (en.alertStatus = :denied or en.alertStatus = :confirmed) and en.medicalCard = :medicalCard")
//    public List<Alert> getConfirmedAndDeniedAlerts(@Param("medicalCard") MedicalCard medicalCard, @Param("denied") AlertStatus denied, @Param("confirmed") AlertStatus confirmed);
}
