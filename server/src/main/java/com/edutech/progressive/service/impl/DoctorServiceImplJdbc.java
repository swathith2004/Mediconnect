package com.edutech.progressive.service.impl;

import java.util.List;

import com.edutech.progressive.dao.DoctorDAO;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplJdbc implements DoctorService {

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        return -1;
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        return null;
    }

    @Override
    public void deleteDoctor(int doctorId) {

    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        
    }
    
    
}