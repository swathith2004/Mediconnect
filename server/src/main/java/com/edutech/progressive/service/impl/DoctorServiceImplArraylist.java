package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;
public class DoctorServiceImplArraylist implements DoctorService {
    private static List<Doctor> doctorList = new ArrayList<>();

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        if(doctorList.add(doctor)){
            return doctor.getDoctorId();
        }else{
            return -1;
        }

    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        Collections.sort(doctorList,experienceComparator);
        return doctorList;
    }
    public static Comparator<Doctor> experienceComparator=new Comparator<Doctor>() {

        @Override
        public int compare(Doctor arg0, Doctor arg1) {
            return Integer.compare(arg0.getYearsOfExperience(),arg1.getYearsOfExperience());
        }
        
    };

    @Override
    public void emptyArrayList() {
        doctorList.clear();
    }

}