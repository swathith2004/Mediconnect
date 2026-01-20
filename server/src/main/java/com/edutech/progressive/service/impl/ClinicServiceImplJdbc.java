package com.edutech.progressive.service.impl;

import java.util.List;

import com.edutech.progressive.dao.ClinicDAO;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

public class ClinicServiceImplJdbc implements ClinicService{
    private final ClinicDAO clinicDAO;

    public ClinicServiceImplJdbc(ClinicDAO clinicDAO) {
        this.clinicDAO = clinicDAO;
    }

    @Override
    public List<Clinic> getAllClinics() throws Exception{
        try {
            return clinicDAO.getAllClinics();
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Error fetching all clinics", e);
        }finally{}
    }

    @Override
    public Clinic getClinicById(int clinicId) throws Exception{
        try {
            Clinic clinic = clinicDAO.getClinicById(clinicId);
            return clinic;
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Error fetching clinic with id " + clinicId, e);
        }finally{}
        
    }

    @Override
    public Integer addClinic(Clinic clinic) throws Exception{
        try {
            return clinicDAO.addClinic(clinic);
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Error adding clinic: " + clinic.getClinicName(), e);
        }finally{}
        
    }

    @Override
    public void updateClinic(Clinic clinic) throws Exception{
        try {
            clinicDAO.updateClinic(clinic);
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Error updating clinic with ID " + clinic.getClinicId(), e);
        }finally{}
        
    }

    @Override
    public void deleteClinic(int clinicId) throws Exception{
        try {
            clinicDAO.deleteClinic(clinicId);
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Error deleting clinic with ID " + clinicId, e);
        }finally{}
        
    }
    
}