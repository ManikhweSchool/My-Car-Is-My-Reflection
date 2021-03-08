package com.manikhwe.mycarismyreflection.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manikhwe.mycarismyreflection.model.Session;
import com.manikhwe.mycarismyreflection.service.SessionService;

@Controller
public class SessionController {
	
	@Autowired
	private SessionService service;

	@RequestMapping(value="/create/session", 
	method=RequestMethod.POST)
	public void saveSession(Session session) {
		
		service.saveSession(session);
	}
	
	@RequestMapping(value="/sessions/{sessionId}", 
	method=RequestMethod.GET)
	public Optional<Session> findSession(
	@PathVariable long sessionId){
		return service.findSession(sessionId);
	}
	
	@RequestMapping(value="/sessions", 
	method=RequestMethod.GET)
	public List<Session> findAllSessions(){
		return service.findSessions();
	}
	
	@GetMapping(value="/view/sessions")
	public String viewAllSessions(Model model) {
		model.addAttribute("sessions", findAllSessions());
		return "SessionsData";
	}
}
