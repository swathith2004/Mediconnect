package com.edutech.progressive.service.impl;

import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.progressive.entity.Patient;
// import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplJpa implements PatientService {

    // @Autowired
    // private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() throws Exception {
        return new ArrayList<>();
        // return patientRepository.findAll();
    }

    @Override
    public Integer addPatient(Patient patient) throws Exception {
        return null;
        // return patientRepository.save(patient).getPatientId();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() throws Exception {
        return new ArrayList<>();
        // List<Patient> patientList = patientRepository.findAll();
        // patientList.sort(Comparator.comparing(Patient::getFullName));
        // return patientList; 
    }

}