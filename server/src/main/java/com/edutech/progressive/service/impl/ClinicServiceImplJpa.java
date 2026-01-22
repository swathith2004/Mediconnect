package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.service.ClinicService;

public class ClinicServiceImplJpa implements ClinicService {

    private ClinicRepository clinicRepository;

    @Autowired
    public ClinicServiceImplJpa(ClinicRepository clinicRepository){
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAllClinics() throws Exception {
        return null;
    }

    @Override
    public Clinic getClinicById(int clinicId) throws Exception {
        return null;
    }

    @Override
    public Integer addClinic(Clinic clinic) throws Exception {
        return -1;
    }

    @Override
    public void updateClinic(Clinic clinic) throws Exception {

    }

    @Override
    public void deleteClinic(int clinicId) throws Exception {
        
    }

    @Override
    public List<Clinic> getAllClinicByLocation(String location){
        return null;
    }

    @Override
    public List<Clinic> getAllClinicByDoctorId(int doctorId){
        return null;
    }
}