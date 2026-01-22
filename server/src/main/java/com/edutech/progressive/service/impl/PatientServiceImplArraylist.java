package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;
@Service
public class PatientServiceImplArraylist implements PatientService {
    private static List<Patient> patientList = new ArrayList<>();
    
    @Override
    public List<Patient> getAllPatients() {
        return patientList;
    }

    @Override
    public Integer addPatient(Patient patient) {
        patientList.add(patient);
        return patient.getPatientId();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        Collections.sort(patientList, NameComparator);
        return patientList;
    }

    public static Comparator<Patient> NameComparator = new Comparator<Patient>() {

        @Override
        public int compare(Patient arg0, Patient arg1) {
            return arg0.getFullName().compareTo(arg1.getFullName());
        }
        
    };

    public void emptyArrayList(){
        patientList.clear();
    }

}