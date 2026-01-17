package com.edutech.progressive.entity;

public class Clinic {
    public int getClinicId() {
        return clinicId;
    }
    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }
    //parameterized constructor
    public Clinic(int clinicId, String clinicName, String location, int doctorId, String contactNumber,
            int establishedYear) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.location = location;
        this.doctorId = doctorId;
        this.contactNumber = contactNumber;
        this.establishedYear = establishedYear;
    }
    //default cons
    public Clinic() {
    }

    private int clinicId;

    public String getClinicName() {
        return clinicName;
    }
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
    private String clinicName;

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    private String location;

    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    private int doctorId;

    private String contactNumber;
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }
    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }
    private int establishedYear;
}