package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.enumiration.AlertStatus;
import kz.astonline.ehospital.model.Alert;
import kz.astonline.ehospital.model.Employee;

import kz.astonline.ehospital.repository.AlertRepository;
import kz.astonline.ehospital.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertRepository alertRepository;

    @Override
    public Alert saveOrUpdate(Alert entity) {
        return alertRepository.save(entity);
    }

    @Override
    public Alert findById(Long id) {
        return alertRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Alert> findAll() {
        return alertRepository.findAll();
    }

    @Override
    public List<Alert> getAllAlertsForEmployeeByStatus(Employee employee, AlertStatus status) {
        return alertRepository.getAllAlertsForEmployeeByStatus(employee, status);
    }

    @Override
    public List<Alert> getAllAlertsForEmployee(Employee employee) {
        return alertRepository.getAllAlertsForEmployee(employee);
    }


    @Override
    public List<Alert> getAllAlertsByStatus(AlertStatus status) {
        return alertRepository.getAllAlertsByStatus(status);
    }

    @Override
    public void deleteByDate(LocalDateTime localDateTime) {
        alertRepository.deleteByDate(localDateTime);
    }

}
