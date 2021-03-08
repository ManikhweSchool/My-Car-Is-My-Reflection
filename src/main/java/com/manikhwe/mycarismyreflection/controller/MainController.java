package com.manikhwe.mycarismyreflection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value="/payments")
	public String visitPayments() {
		
		return "Payments";
	}
	
	@GetMapping(value="/contacts")
	public String visitContacts() {
		
		return "Contacts";
	}
	
	@GetMapping(value="/testimonials")
	public String visitTestimonials() {
		
		return "Testimonials";
	}
}
