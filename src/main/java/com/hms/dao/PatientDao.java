package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.hms.model.Patient;
import com.hms.model.User;

public class PatientDao {
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 public List<Patient> getAllPatients() {
	    String sql = "select * from patient";
	    List<Patient> patients= jdbcTemplate.query(sql, new PatientMapper());
	    return patients;
	 }
	 
	 public List<Patient> getPatientsbyPage(int pageNumber) {
	    String sql = "SELECT * FROM Patient order by patientid desc OFFSET ((" + pageNumber+ " - 1) * 10) ROWS FETCH NEXT 10 ROWS ONLY";
	    List<Patient> patients= jdbcTemplate.query(sql, new PatientMapper());
	    return patients;
	 }
	 
	 public List<Patient> getPatientsbyID(int patientID) {
		String sql = "SELECT TOP 1 * FROM Patient where patientID = " + patientID;
	    List<Patient> patients= jdbcTemplate.query(sql, new PatientMapper());
	    return patients;
	}
	 
	 public List<Patient> getPatientByFNLN(String firstName, String lastName) {
	    String sql = "SELECT TOP 1 * FROM Patient where firstname = '" + firstName + "' and lastname = '"+ lastName +"' order by patientid desc";
	    List<Patient> patients= jdbcTemplate.query(sql, new PatientMapper());
	    return patients;
	}
	 
	 public String addPatient(final Patient patient) throws Exception{
		 try{
			final String  sql1 = "Insert into Patient(Firstname,Lastname,DOB,Address,Gender,CreatedDate) Values(?,?,?,?,?,?)";
			int result = jdbcTemplate.update(new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						// TODO Auto-generated method stub
						PreparedStatement statement = datasource.getConnection().prepareStatement(sql1);
						statement.setString(1, patient.getFirstName());
						statement.setString(2, patient.getLastName());
						statement.setDate(3, new java.sql.Date(patient.getDob().getTime()));
						statement.setString(4, patient.getAddress());
						statement.setString(5, patient.getGender());
						statement.setDate(6, new java.sql.Date(new Date().getTime()));
						return statement;
					}
			});
			System.out.println("Add Patient Result:"+ result);	 
			if(result == 1){
		    	return "Success";
		    } else {
		    	return "Fail";
		    }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 throw e;
		 }
	 }
	 
}
 class PatientMapper implements RowMapper<Patient> {
	public Patient mapRow(ResultSet rs, int arg1) throws SQLException {
	  Patient patient = new Patient();
	  patient.setPatientID(rs.getInt("patientID"));
	  patient.setFirstName(rs.getString("firstname"));
	  patient.setLastName(rs.getString("lastname"));
	  patient.setGender(rs.getString("Gender"));
	  patient.setDob(rs.getDate("DOB"));
	  patient.setAddress(rs.getString("address"));
	  return patient;
	}
}
