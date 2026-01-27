package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.exception.ClinicAlreadyExistsException;
import com.edutech.progressive.service.impl.ClinicServiceImplJpa;

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
@RequestMapping("/clinic")
public class ClinicController {
    
    private ClinicServiceImplJpa clinicServiceImplJpa;

    @Autowired
    public ClinicController(ClinicServiceImplJpa clinicServiceImplJpa) {
        this.clinicServiceImplJpa = clinicServiceImplJpa;
    }

    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() {
        try {
            return new ResponseEntity<List<Clinic>>(clinicServiceImplJpa.getAllClinics(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{clinicId}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable int clinicId) {
        try {
            return new ResponseEntity<Clinic>(clinicServiceImplJpa.getClinicById(clinicId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addClinic(@RequestBody Clinic clinic) {
        try {
            return new ResponseEntity<Integer>(clinicServiceImplJpa.addClinic(clinic), HttpStatus.CREATED);
        }catch(ClinicAlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{clinicId}")
    public ResponseEntity<Void> updateClinic(@PathVariable int clinicId, @RequestBody Clinic clinic) {
        try {
            clinic.setClinicId(clinicId);
            clinicServiceImplJpa.updateClinic(clinic);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch(ClinicAlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }  
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{clinicId}")
    public ResponseEntity<Void> deleteClinic(@PathVariable int clinicId) {
        try {
            clinicServiceImplJpa.deleteClinic(clinicId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Clinic>> getAllClinicByLocation(@PathVariable String location) {
        try {
            return new ResponseEntity<List<Clinic>>(clinicServiceImplJpa.getAllClinicByLocation(location), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Clinic>> getAllClinicByDoctorId(@PathVariable int doctorId) {
        try {
            return new ResponseEntity<List<Clinic>>(clinicServiceImplJpa.getAllClinicByDoctorId(doctorId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}