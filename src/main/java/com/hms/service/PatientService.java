package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hms.dao.PatientDao;
import com.hms.model.Patient;

public class PatientService {

		
	@Autowired
	PatientDao patientDao;
	
	public List<Patient> getPatients(){
		return patientDao.getAllPatients();
	}
	
	public String addPatient(Patient patient) throws Exception{
		return patientDao.addPatient(patient);
	}
	
	 public List<Patient> getPatientByFNLN(String firstName, String lastName) {
		 return patientDao.getPatientByFNLN(firstName,lastName);
	}
}
