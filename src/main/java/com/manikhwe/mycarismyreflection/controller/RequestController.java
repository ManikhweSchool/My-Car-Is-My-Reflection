package com.manikhwe.mycarismyreflection.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.manikhwe.mycarismyreflection.model.Request;
import com.manikhwe.mycarismyreflection.service.RequestService;

@Controller
public class RequestController {
	
	@Autowired
	private RequestService service;

	@GetMapping(value="/index")
	public String visitHome(Model model) {
		
		model.addAttribute("request", new Request());
		return "index";
	}
	
	@PostMapping(value="/create/request")
	public String saveReqeust(
	@ModelAttribute(name="request")Request request,
	Model model) {
		
		String  page;
		String status;
		boolean requestAddedOnDatabase;
		
		Optional<Request> optionalRequest = 
		service.findReqeust(request.getRequestId());
		
		if(optionalRequest.isPresent()) {
			page = "index";
			status = "Request Already Exist.";
			requestAddedOnDatabase = false;
		}
		else{
			page = "RequestConfirmation";
			status = "Request Successfully Added.";
			requestAddedOnDatabase = true;
		}
		
		model.addAttribute("status", status);
		model.addAttribute("requestAddedOnDatabase",
		requestAddedOnDatabase);
		
		return page;
	}
	
	@GetMapping(value="/view/requests")
	public String viewAllRequests(Model model) {
		model.addAttribute("requests", service.findAllRequests());
		return "RequestsData";
	}
}
