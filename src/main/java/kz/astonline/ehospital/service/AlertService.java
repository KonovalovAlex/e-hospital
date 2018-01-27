package kz.astonline.ehospital.service;

import kz.astonline.ehospital.enumiration.AlertStatus;
import kz.astonline.ehospital.model.Alert;
import kz.astonline.ehospital.model.Employee;

import kz.astonline.ehospital.service.base.BaseService;

import java.time.LocalDateTime;
import java.util.List;

public interface AlertService extends BaseService<Alert,Long> {

    public List<Alert> getAllAlertsForEmployeeByStatus(Employee employee, AlertStatus status);

    public List<Alert> getAllAlertsForEmployee(Employee employee);



    public List<Alert> getAllAlertsByStatus(AlertStatus status);

    public void deleteByDate(LocalDateTime localDateTime);

//    public List<Alert> getConfirmedAndDeniedConsultation(MedicalCard medicalCard);

}
