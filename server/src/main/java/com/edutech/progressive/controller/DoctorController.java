package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.exception.DoctorAlreadyExistsException;
import com.edutech.progressive.service.impl.DoctorServiceImplJpa;

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
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImplJpa doctorServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            return new ResponseEntity<List<Doctor>>(doctorServiceImplJpa.getAllDoctors(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId) {
        try {
            return new ResponseEntity<Doctor>(doctorServiceImplJpa.getDoctorById(doctorId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor) {
        try {
            return new ResponseEntity<Integer>(doctorServiceImplJpa.addDoctor(doctor), HttpStatus.CREATED);
        } 
        catch(DoctorAlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<Void> updateDoctor(@PathVariable int doctorId,@RequestBody Doctor doctor) {
        try {
            doctor.setDoctorId(doctorId);
            doctorServiceImplJpa.updateDoctor(doctor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch(DoctorAlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int doctorId) {
        try {
            doctorServiceImplJpa.deleteDoctor(doctorId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Doctor>> getDoctorSortedByExperience() {
        try {
            return new ResponseEntity<List<Doctor>>(doctorServiceImplJpa.getDoctorSortedByExperience(), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}