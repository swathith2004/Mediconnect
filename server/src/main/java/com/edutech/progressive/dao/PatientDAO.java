package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Patient;

import java.util.List;

public interface PatientDAO {
    public int addPatient(Patient patient);

    public Patient getPatientById(int patientId);

    public void updatePatient(Patient patient);

    public void deletePatient(int patientId);

    public List<Patient> getAllPatients();
}