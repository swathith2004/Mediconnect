package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.PatientDAO;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplJdbc implements PatientService{
    private final PatientDAO patientDAO;

    public PatientServiceImplJdbc(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public List<Patient> getAllPatients() throws Exception {
        try {
            return patientDAO.getAllPatients();
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
        
    }

    @Override
    public Integer addPatient(Patient patient) throws Exception {
        try {
            return patientDAO.addPatient(patient);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
    }

    @Override
    public List<Patient> getAllPatientSortedByName() throws Exception {
        try {
            List<Patient> sortPatients = patientDAO.getAllPatients();
            Collections.sort(sortPatients, Comparator.comparing(Patient::getFullName));
            return sortPatients;
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
    }

    public void updatePatient(Patient patient) throws Exception{
        try {
            patientDAO.updatePatient(patient);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
    }

    public void deletePatient(int patientId) throws Exception{
        try {
            patientDAO.deletePatient(patientId);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
    }
    
    public Patient getPatientById(int patientId) throws Exception{
        try {
            return patientDAO.getPatientById(patientId);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
    }
    
}