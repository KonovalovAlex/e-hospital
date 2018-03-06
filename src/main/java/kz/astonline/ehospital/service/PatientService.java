package kz.astonline.ehospital.service;

import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.base.BaseService;

import java.util.List;

public interface PatientService extends BaseService<Patient,Long> {
    Patient getAllPatients();
    List<Patient> findPatientByFullName(String name, String surName);
    List<Patient> findByFullNameAndOpeningCard(String name, String surName, Boolean isActive);
    Patient saveOrUpdate(Patient patient);
    List<Patient> findAllBelongToEmp(long idEmp);
    List<Patient> notExaminedTherapist(long idEmp);
}
