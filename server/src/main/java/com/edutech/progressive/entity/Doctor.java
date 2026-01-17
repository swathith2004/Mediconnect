package com.edutech.progressive.entity;

public class Doctor {
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    private int doctorId;
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    private String fullName;
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    private String specialty;
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    private String contactNumber;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    private String email;
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public Doctor() {
    }
    public Doctor(int doctorId, String fullName, String specialty, String contactNumber, String email,
            int yearsOfExperience) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.specialty = specialty;
        this.contactNumber = contactNumber;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
    }
    private int yearsOfExperience;

}