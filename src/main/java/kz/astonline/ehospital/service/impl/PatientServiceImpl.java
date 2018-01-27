package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.repository.PatientRepository;
import kz.astonline.ehospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient saveOrUpdate(Patient entity) {
        return null;
    }

    @Override
    public Patient findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public Patient getAllPatients() {
        return null;
    }

    @Override
    public Patient findPatientFullName(String name, String surName) {
        return patientRepository.findByFullName(name, surName);

    }
}
