package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Clinic;

import java.util.List;

public interface ClinicDAO {
    public int addClinic(Clinic clinic);

    public Clinic getClinicById(int clinicId);

    public void updateClinic(Clinic clinic);

    public void deleteClinic(int clinicId);

    public List<Clinic> getAllClinics();
}