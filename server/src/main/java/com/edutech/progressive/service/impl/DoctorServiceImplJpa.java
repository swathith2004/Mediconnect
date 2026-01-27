package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.exception.DoctorAlreadyExistsException;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.service.DoctorService;
@Service
public class DoctorServiceImplJpa implements DoctorService {
    
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    public DoctorServiceImplJpa(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() throws Exception {
        return doctorRepository.findAll();
    }

    @Override
    public Integer addDoctor(Doctor doctor) throws Exception {
        Doctor existingDoctor = doctorRepository.findByEmail(doctor.getEmail());
        if(existingDoctor != null){
            throw new DoctorAlreadyExistsException("Doctor with email" + doctor.getEmail() + " already exists.");
        }
        return doctorRepository.save(doctor).getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() throws Exception {
        List<Doctor> doctorList = doctorRepository.findAll();
        doctorList.sort(Comparator.comparing(Doctor::getFullName));
        return doctorList;
    }

    @Override
    public void updateDoctor(Doctor doctor) throws Exception {
        Doctor existingDoctor = doctorRepository.findByEmail(doctor.getEmail());
        if(existingDoctor != null){
            throw new DoctorAlreadyExistsException("Doctor with email" + doctor.getEmail() + " already exists.");
        }
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(int doctorId) throws Exception {
        clinicRepository.deleteByDoctorId(doctorId);
        doctorRepository.deleteById(doctorId);
    }

    @Override
    public Doctor getDoctorById(int doctorId) throws Exception {
        return doctorRepository.findByDoctorId(doctorId);
    }

}