package com.manikhwe.mycarismyreflection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhwe.mycarismyreflection.dao.RequestRepository;
import com.manikhwe.mycarismyreflection.model.Request;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;
	
	public Request saveReqeust(Request request) {
		
		return repository.save(request);
	}
	
	public Optional<Request> findReqeust(long requestId){
		
		return repository.findById(requestId);
	}
	
	public List<Request> findAllRequests(){
		return repository.findAll();
	}
}
