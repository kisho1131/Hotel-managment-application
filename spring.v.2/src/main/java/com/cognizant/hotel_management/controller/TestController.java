package com.cognizant.hotel_management.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;

//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")  
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/hms")
public class TestController {
	@GetMapping("/admin")
	public String basicauth_admin() {
		System.out.println("Success login");
		//return new String("admin authenticated");
		return null;
	}
	
	@GetMapping("/user")
	public String basicauth_user() {
		//return new String("user authenticated");
		return null;
	}
/*
	@RequestMapping("/")
	public ModelAndView defaultHome() {
		return new ModelAndView("login");
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/dashboard")
	public ModelAndView userDashboard() {
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping("/accessdenied")
	public ModelAndView userAccessError() {
		return new ModelAndView("accessdenied");
	}
	
	@RequestMapping("/admin/")
	public ModelAndView admin() {
		return new ModelAndView("admin/login");
	}

	@RequestMapping("/admin/login")
	public ModelAndView adminlogin() {
		return new ModelAndView("admin/login");
	}

	@RequestMapping("/admin/dashboard")
	public ModelAndView admindashboard() {
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping("/admin/accessdenied")
	public ModelAndView adminAccessError() {
		return new ModelAndView("admin/accessdenied");
	}
	*/
	
}