package com.manikhwe.mycarismyreflection.model;

import java.util.Map;
import java.util.TreeMap;

import javax.persistence.ElementCollection;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name = "Service")
@Inheritance(strategy = InheritanceType.JOINED)
@Component
public class Service {

	@ManyToOne
	protected Address sessionAddress;
	@ManyToOne
	protected Client client;
	@ElementCollection
	protected Map<String,String> sessionDaysAndTimes;
	
	protected Service() {
		sessionDaysAndTimes = new TreeMap<>();
	}
	
	protected Service(Client client, Address sessionAddress) {
		this.client = client;
		this.sessionAddress = sessionAddress;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Address getSessionAddress() { return sessionAddress;}
	
	public void setSessionAddress(Address sessionAddress) { 
		this.sessionAddress = sessionAddress;
	}

	public Map<String, String> getSessionDaysAndTimes() {
		return sessionDaysAndTimes;
	}

	public void setSessionDaysAndTimes(Map<String, String> sessionDaysAndTimes) {
		this.sessionDaysAndTimes = sessionDaysAndTimes;
	}
	
	
}

