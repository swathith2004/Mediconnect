package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplJpa implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImplJpa(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() throws Exception {
        return null;
    }

    @Override
    public Integer addDoctor(Doctor doctor) throws Exception {
        return -1;
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() throws Exception {
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) throws Exception {

    }

    @Override
    public void deleteDoctor(int doctorId) throws Exception {

    }

    @Override
    public Doctor getDoctorById(int doctorId) throws Exception {
        return null;
    }

}