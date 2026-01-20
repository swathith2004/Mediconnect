package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.DoctorDAO;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplJdbc implements DoctorService {
    private final DoctorDAO doctorDAO;
    public DoctorServiceImplJdbc(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Override
    public List<Doctor> getAllDoctors() throws Exception {
        try {
            return doctorDAO.getAllDoctors();
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
        
    }

    @Override
    public Integer addDoctor(Doctor doctor) throws Exception {
        try {
            return doctorDAO.addDoctor(doctor);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
        
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() throws Exception {
        try {
            List<Doctor> sortedList = doctorDAO.getAllDoctors();
            Collections.sort(sortedList, Comparator.comparingInt(Doctor::getYearsOfExperience));
            return sortedList;
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
        
    }

    @Override
    public Doctor getDoctorById(int doctorId) throws Exception{
        try {
            return doctorDAO.getDoctorById(doctorId);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
        
    }

    @Override
    public void updateDoctor(Doctor doctor) throws Exception {
        try {
            doctorDAO.updateDoctor(doctor);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}

    }
    
    @Override
    public void deleteDoctor(int doctorId) throws Exception{
        try {
            doctorDAO.deleteDoctor(doctorId);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        }finally{}
    }

}