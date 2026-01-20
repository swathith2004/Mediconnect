package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Clinic;

public class ClinicDAOImpl implements ClinicDAO {

    public ClinicDAOImpl() {
    }

    @Override
    public int addClinic(Clinic clinic) throws SQLException {
        String query = "INSERT INTO  clinic (clinic_name, location, doctor_id, contact_number, established_year) VALUES(?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet key = null;
        int id = -1;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clinic.getClinicName());
            ps.setString(2, clinic.getLocation());
            ps.setInt(3, clinic.getDoctorId());
            ps.setString(4, clinic.getContactNumber());
            ps.setInt(5, clinic.getEstablishedYear());

            int rows = ps.executeUpdate();
            if(rows == 0){
                throw new SQLException("No rows affected.");
            }
            key = ps.getGeneratedKeys();
            if(key.next()){
                id = key.getInt(1);
                clinic.setClinicId(id);
            }
            else{
                throw new SQLException("No ID obtained");
            }

        } catch (SQLException e) {
            throw e;
        }
        catch(Exception e){
            throw new SQLException("Unexpected error", e);
        }
        finally{
            closeQuietly(key);
            closeQuietly(ps);
            closeQuietly(connection);
        }
        return id;
    }

    @Override
    public Clinic getClinicById(int clinicId) throws SQLException {
        String query = "SELECT * FROM clinic WHERE clinic_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, clinicId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Clinic c = new Clinic();
                
                c.setClinicId(clinicId);
                c.setClinicName(rs.getString("clinic_name"));
                c.setLocation(rs.getString("location"));
                c.setDoctorId(rs.getInt("doctor_id"));
                c.setContactNumber(rs.getString("contact_number"));
                c.setEstablishedYear(rs.getInt("established_year"));

                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        finally{
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(connection);
        }
        return null;
    }

    @Override
    public void updateClinic(Clinic clinic) throws SQLException{
        String query = "UPDATE clinic SET clinic_name = ?, location = ?, doctor_id = ?, contact_number = ?, established_year = ? WHERE clinic_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);
            
            ps.setString(1, clinic.getClinicName());
            ps.setString(2, clinic.getLocation());
            ps.setInt(3, clinic.getDoctorId());
            ps.setString(4, clinic.getContactNumber());
            ps.setInt(5, clinic.getEstablishedYear());
            ps.setInt(6, clinic.getClinicId());

            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        }
        catch(Exception e){
            throw new SQLException("Unexpected error", e);
        }
        finally{
            closeQuietly(ps);
            closeQuietly(connection);
        }
    }

    @Override
    public void deleteClinic(int clinicId) throws SQLException {
        String query = "DELETE FROM clinic WHERE clinic_id = ?";

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, clinicId);
            ps.executeUpdate();
            // int rows = ps.executeUpdate();
            // System.out.println(rows);
            // if(rows == 0){
            //     throw new SQLException("Record not found");
            // }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        // catch(Exception e){
        //     throw new SQLException("Unexpected error", e);
        // }
        finally{
            closeQuietly(ps);
            closeQuietly(connection);
        }
    }

    @Override
    public List<Clinic> getAllClinics() throws SQLException {
        String query = "SELECT * FROM clinic";
        
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Clinic> clinics = new ArrayList<>();
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                int clinicId = rs.getInt("clinic_id");
                Clinic c = new Clinic();
                c.setClinicId(clinicId);
                c.setClinicName(rs.getString("clinic_name"));
                c.setLocation(rs.getString("location"));
                c.setDoctorId(rs.getInt("doctor_id"));
                c.setContactNumber(rs.getString("contact_number"));
                c.setEstablishedYear(rs.getInt("established_year"));

                System.out.println(c);

                clinics.add(c);
            }
            
        } catch (SQLException e) {
            throw e;
        }
        catch(Exception e){
            throw new SQLException("Unexpected error", e);
        }
        finally{
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(connection);
        }

        return clinics;
    }

    private void closeQuietly(AutoCloseable a){
        if(a != null){
            try {
                a.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}