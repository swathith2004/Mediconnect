package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Patient;

public class PatientDAOImpl implements PatientDAO {
    public PatientDAOImpl(){}

    @Override
    public int addPatient(Patient patient) throws SQLException{
        String query = "INSERT INTO patient (full_name, date_of_birth, contact_number, email, address) VALUES(?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, patient.getFullName());
            ps.setDate(2, new java.sql.Date (patient.getDateOfBirth().getTime()));
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                patient.setPatientId(id);
                return patient.getPatientId();
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
    public Patient getPatientById(int patientId) throws SQLException {
        String query = "SELECT * FROM patient WHERE patient_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, patientId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Date sqlDate = rs.getDate("date_of_birth");
                Date utilDate = sqlDate == null ? null : new Date(sqlDate.getTime());
                Patient p = new Patient(
                    rs.getInt(1),
                    rs.getString(2),
                    utilDate,
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                );

                return p;
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
    public void updatePatient(Patient patient) throws SQLException {
        String query = "UPDATE patient SET full_name = ?, date_of_birth = ?, contact_number = ?, email = ?, address = ? WHERE patient_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, patient.getFullName());
            ps.setDate(2, new java.sql.Date (patient.getDateOfBirth().getTime()));
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setInt(6, patient.getPatientId());

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
    public void deletePatient(int patientId) throws SQLException {
        String query = "DELETE FROM patient WHERE patient_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, patientId);
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
    public List<Patient> getAllPatients() throws SQLException {
        String query = "SELECT * FROM patient";
        
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Patient> patients = new ArrayList<>();
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Date sqlDate = rs.getDate("date_of_birth");
                Date utilDate = sqlDate == null ? null : new Date(sqlDate.getTime());
                Patient p = new Patient(
                    rs.getInt(1),
                    rs.getString(2),
                    utilDate,
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                );

                patients.add(p);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw e;
        }finally{
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(connection);
        }
        return patients;
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