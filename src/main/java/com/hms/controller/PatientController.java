package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Patient;
import com.hms.service.PatientService;

@Controller

public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping(value="/patientsearch")
	public String viewSearchPatientPage(){
		return "Home";
	}
	
	@RequestMapping(value="/patientsearch",method=RequestMethod.POST)
	public ModelAndView searchPatients(){
//		PagedListHolder pagelistPatients ;
		List<Patient> patients =  patientService.getPatients();
		ModelAndView mav = new ModelAndView("Home");;
		if(patients==null || patients.size()==0){
			mav.addObject("information_message","No patient with serach criteria");
		} else {
//			pagelistPatients = new PagedListHolder(patients);
			mav.addObject("information_message","Records:");
			mav.addObject("patients",patients);
		}
		return mav;
	}
	
	
	@RequestMapping(value="/addpatient",method=RequestMethod.GET)
	public String addPatientForm(Model model){
		System.out.println("Reached addPatientForm");
		model.addAttribute("patient",new Patient());
		return "AddPatient";
	}
	
	@RequestMapping(value="/addpatient",method=RequestMethod.POST)
	public String addPatient(@ModelAttribute("patient") Patient patient,BindingResult result,Model model){
		System.out.println("Reached addPatient");
		try {
			String addPatietnResult = patientService.addPatient(patient);
			if(addPatietnResult.equalsIgnoreCase("Success")){
				model.addAttribute("patient", patientService.getPatientByFNLN(patient.getFirstName(), patient.getLastName()).get(0));
				return "UpdatePatient";
			} else {
				model.addAttribute("message", "Please check errors");
				return "AddPatient";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message", "Please check errors");
			return "AddPatient";
		}
		
	}
}
