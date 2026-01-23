package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    private ClinicRepository clinicRepository;

    @Autowired
    public ClinicServiceImplJpa(ClinicRepository clinicRepository){
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAllClinics() throws Exception {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getClinicById(int clinicId) throws Exception {
        return clinicRepository.findByClinicId(clinicId);
    }

    @Override
    public Integer addClinic(Clinic clinic) throws Exception {
        return clinicRepository.save(clinic).getClinicId();
    }

    @Override
    public void updateClinic(Clinic clinic) throws Exception {
        clinicRepository.save(clinic);
    }

    @Override
    public void deleteClinic(int clinicId) throws Exception {
        clinicRepository.deleteById(clinicId);
    }

    @Override
    public List<Clinic> getAllClinicByLocation(String location){
        return clinicRepository.findAllByLocation(location);
    }

    @Override
    public List<Clinic> getAllClinicByDoctorId(int doctorId){
        return clinicRepository.findAllByDoctorId(doctorId);
    }
}