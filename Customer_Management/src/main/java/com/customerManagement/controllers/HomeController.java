package com.customerManagement.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customerManagement.Models.Customer;
import com.customerManagement.services.Services;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private Services services;

	// Add mapping for list
	@RequestMapping("/")
	public String listStudents(Model theModel) {

		// get Students from db
		List<Customer> theCustomer = services.findAll();

		// Add to the spring model
		theModel.addAttribute("Customer", theCustomer);

		return "home";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//Create model attribute to bind from data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("Customer", theCustomer);
		
		return "customer-form";
		
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
		
		// get the customer from the service
		Customer theCustomer = services.findById(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);
	
		//send over to our form
		return "customer-form ";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name, @RequestParam("email_id") String email_id) {
		
		System.out.println(id);
		Customer theCustomer;
		if(id != 0) {
			theCustomer = services.findById(id);
			theCustomer.setFirst_name(first_name);
			theCustomer.setLast_name(last_name);
			theCustomer.setEmail_id(email_id);
		} else 
			theCustomer = new Customer(first_name , last_name, email_id);
		
		// save the Customer
		services.save(theCustomer);
		
		//use a redirest to prevent duplicate submissions
		return "redirect:/";
	}
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int id) {
		
		// deleting the book
		services.deleteById(id);
		
		//redirecting to main page
		return "redirect:/";
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("id") int id, Model theModel) {

		// get the customer from the service
		Customer theCustomer = services.findById(id);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
