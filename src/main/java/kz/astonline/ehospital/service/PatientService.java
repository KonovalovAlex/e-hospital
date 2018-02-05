package kz.astonline.ehospital.service;

import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.base.BaseService;

public interface PatientService extends BaseService<Patient,Long> {
    Patient getAllPatients();
    Patient findPatientByFullName(String name, String surName);
    Patient saveOrUpdate(Patient patient);
}
