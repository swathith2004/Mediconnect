package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    public int addDoctor(Doctor doctor);

    public Doctor getDoctorById(int doctorId);

    public void updateDoctor(Doctor doctor);

    public void deleteDoctor(int doctorId);

    public List<Doctor> getAllDoctors();
}
