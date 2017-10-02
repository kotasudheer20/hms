package com.hms.model;

import java.util.Date;

public class Diagnosis {
	int diagnosisID;
	String diagnosisName;
	int diagnosisType,assignedDoctorID;
	Date treatmentDate;
	
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
