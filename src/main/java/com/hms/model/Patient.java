package com.hms.model;

import java.util.ArrayList;
import java.util.Date;

public class Patient {
	int patientID;
	String firstName,lastName,address,gender;
	Date dob;
	ArrayList<Diagnosis> listOfdiagnosis;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public ArrayList<Diagnosis> getListOfdiagnosis() {
		return listOfdiagnosis;
	}
	public void setListOfdiagnosis(ArrayList<Diagnosis> listOfdiagnosis) {
		this.listOfdiagnosis = listOfdiagnosis;
	}
	
	
}
