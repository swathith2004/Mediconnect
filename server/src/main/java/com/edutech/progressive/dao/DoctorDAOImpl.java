package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Doctor;

public class DoctorDAOImpl implements DoctorDAO{
public DoctorDAOImpl(){}
    @Override
    public int addDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctor (full_name, specialty, contact_number, email, years_of_experience) VALUES(?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());
            
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                doctor.setDoctorId(id);
                return doctor.getDoctorId();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw e;
        }finally{
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(connection);
        }
        return -1;
    }

    @Override
    public Doctor getDoctorById(int doctorId) throws SQLException {
        String query = "SELECT * FROM doctor WHERE doctor_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, doctorId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt(1));
                d.setFullName(rs.getString("full_name"));
                d.setSpecialty(rs.getString("specialty"));
                d.setContactNumber(rs.getString("contact_number"));
                d.setEmail(rs.getString("email"));
                d.setYearsOfExperience(rs.getInt("years_of_experience"));

                return d;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw e;
        }finally{
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(connection);
        }
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) throws SQLException {
        String query = "UPDATE doctor SET full_name = ?, specialty = ?, contact_number = ?, email = ?, years_of_experience = ? WHERE doctor_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());
            ps.setInt(6, doctor.getDoctorId());

            ps.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw e;
        }finally{
            closeQuietly(ps);
            closeQuietly(connection);
        }
    }

    @Override
    public void deleteDoctor(int doctorId) throws SQLException {
        String query = "DELETE FROM doctor WHERE doctor_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, doctorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw e;
        }finally{
            closeQuietly(ps);
            closeQuietly(connection);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() throws SQLException {
        String query = "SELECT * FROM doctor";
        
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Doctor> doctors = new ArrayList<>();
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Doctor d = new Doctor(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6)
                );

                doctors.add(d);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw e;
        }finally{
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(connection);
        }

        return doctors;
    }
    
    private void closeQuietly(AutoCloseable a){
        if(a != null){
            try {
                a.close();
            } catch (Exception e) {

            }
        }
    }

}