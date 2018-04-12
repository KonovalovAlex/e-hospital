package kz.online.ehospital.service.impl;

import kz.online.ehospital.enumiration.AlertStatus;
import kz.online.ehospital.model.Alert;
import kz.online.ehospital.model.Employee;

import kz.online.ehospital.repository.AlertRepository;
import kz.online.ehospital.service.AlertService;
import kz.online.ehospital.enumiration.AlertStatus;
import kz.online.ehospital.repository.AlertRepository;
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
