package com.hms.model;

import java.util.Date;

public class Diagnosis {
	int diagnosisID;
	String diagnosisName,assignedDoctorFirstName,assignedDoctorLastName;
	
	int diagnosisType,assignedDoctorID;
	Date treatmentDate;
	
	public String getAssignedDoctorFirstName() {
		return assignedDoctorFirstName;
	}
	public void setAssignedDoctorFirstName(String assignedDoctorFirstName) {
		this.assignedDoctorFirstName = assignedDoctorFirstName;
	}
	public String getAssignedDoctorLastName() {
		return assignedDoctorLastName;
	}
	public void setAssignedDoctorLastName(String assignedDoctorLastName) {
		this.assignedDoctorLastName = assignedDoctorLastName;
	}
	
	public int getDiagnosisID() {
		return diagnosisID;
	}
	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
	}
	public String getDiagnosisName() {
		return diagnosisName;
	}
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}
	public int getDiagnosisType() {
		return diagnosisType;
	}
	public void setDiagnosisType(int diagnosisType) {
		this.diagnosisType = diagnosisType;
	}
	public int getAssignedDoctorID() {
		return assignedDoctorID;
	}
	public void setAssignedDoctorID(int assignedDoctorID) {
		this.assignedDoctorID = assignedDoctorID;
	}
	public Date getTreatmentDate() {
		return treatmentDate;
	}
	public void setTreatmentDate(Date treatmentDate) {
		this.treatmentDate = treatmentDate;
	}
	
}
