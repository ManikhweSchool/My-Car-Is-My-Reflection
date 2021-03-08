package com.manikhwe.mycarismyreflection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhwe.mycarismyreflection.dao.SessionRepository;
import com.manikhwe.mycarismyreflection.model.Session;

@Service
public class SessionService {

	@Autowired
	private SessionRepository repository;
	
	public Session saveSession(Session session) {
		
		return repository.save(session);
	}
	
	public Optional<Session> findSession(long sessionId){
		
		return repository.findById(sessionId);
	}
	
	public List<Session> findSessions(){
		
		return repository.findAll();
	}
}
