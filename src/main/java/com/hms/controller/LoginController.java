package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.LoginUser;
import com.hms.model.User;
import com.hms.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView loginPage = new ModelAndView("Login");
		return loginPage;
	}
	
	@RequestMapping(value="/submitlogin", method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("submitlogin") LoginUser loginUser,BindingResult result,Model model){
//		ModelAndView mav = null;
		if(!result.hasErrors()){
			User user=userService.validateUser(loginUser);
			if(user!=null){
//				mav = new ModelAndView("Home");
				return "redirect:patientsearch";
			} else {
//				mav = new ModelAndView("Login");
				model.addAttribute("error_message", "Username or Password are not matched!!.. Please try again");
				return "Login";
			}
		} else
		{
//			mav = new ModelAndView("Login");
			model.addAttribute("error_message", "Please check values ");
			return "Login";
		}
	
//		return mav;
	}
}

