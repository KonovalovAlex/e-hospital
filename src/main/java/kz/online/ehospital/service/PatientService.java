package kz.online.ehospital.service;

import kz.online.ehospital.model.Patient;
import kz.online.ehospital.service.base.BaseService;
import kz.online.ehospital.service.base.BaseService;

import java.util.List;

public interface PatientService extends BaseService<Patient,Long> {
    Patient getAllPatients();
    List<Patient> findPatientByFullName(String name, String surName);
    List<Patient> findByFullNameAndOpeningCard(String name, String surName, Boolean isActive);
    Patient saveOrUpdate(Patient patient);
    List<Patient> findAllBelongToEmp(long idEmp);
    List<Patient> notExaminedTherapist(long idEmp);
}
