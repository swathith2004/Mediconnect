package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientServiceImplJpa patientServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return null;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(int patientId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addPatient(Patient patient) {
        return null;
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Void> updatePatient(int patientId, Patient patient) {
        return null;
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(int patientId) {
        return null;
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        return null;
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList() {
        return null;
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        return null;
    }
}