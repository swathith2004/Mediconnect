package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientServiceImplArraylist patientServiceImplArraylist;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return null;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        return null;
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Void> updatePatient(@PathVariable int patientId,@RequestBody Patient patient) {

        return null;
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientId) {
        return null;
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        return new ResponseEntity<List<Patient>>(patientServiceImplArraylist.getAllPatients(), HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList(Patient patient) {
        try {
            patientServiceImplArraylist.addPatient(patient);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
         catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        try {
            return new ResponseEntity<List<Patient>>(patientServiceImplArraylist.getAllPatientSortedByName(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}