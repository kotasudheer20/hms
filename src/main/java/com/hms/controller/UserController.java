package com.hms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hms.model.LoginUser;
import com.hms.model.User;
import com.hms.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
//	@RequestMapping(value="/registeruserform",method=RequestMethod.POST)
//	public ModelAndView getRegistrationForm(){
//		return new ModelAndView("Registration");
//	}
	
	@RequestMapping(value="/registeruserform",method=RequestMethod.GET)
	public String getRegistrationForm(Model model){
		model.addAttribute("registeruser",new User());
		return "Registration";
	}


	@RequestMapping(value="/registeruserform",method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("registeruser") User user,BindingResult result,Model model){
		System.out.println("Reached Register User");
		
		if(result.hasErrors()){
			return "Registration";
		} else {
//			String isUserValid = userService.registerUser(user);
			model.addAttribute("login", new LoginUser());
			model.addAttribute("message", "User Created Successfully. Please login here!!!");
			return "Login";
		}
//		if(result.toUpperCase().contains("SUCCESS")){
//			model.addAttribute("message", "User registration is successful");
//			return "redirect:login";
//		}else if(result.toUpperCase().contains("USER EXIST")){
//			model.addAttribute("message", "Username already exist. Please use a different user");
//			return "forward:registeruserform";
//		} else {
//			model.addAttribute("message", "User registration is unsuccessful. Try again with correct values");
//			return "forward:registeruserform";
//		} 
	}
}
  