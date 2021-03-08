package com.manikhwe.mycarismyreflection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Car_Owner")
@Component
public class Client  implements Serializable{

	private static final long serialVersionUID = 4285189014099181236L;
	
	@Id
	@Column(name = "Client_Number", nullable = false)
	private String clientPhoneNumber;
	@Column(name="Client_Name", nullable = false)
	private String clientName;
	@Column(name="Client_Surname", nullable = false)
	private String clientSurname;
	@Column(name="On_Contract", nullable = false)
	private boolean isOnContract;
	
	@OneToMany
	private Collection<Service> services;
	
	public Client() {
		clientName = "";
		clientSurname = "";
		clientPhoneNumber = "";
		services = new ArrayList<>();
	}
	
	public Client(String name, String surname, String email, String phoneNumber) {
		
		clientName = name;
		clientSurname = surname;
		clientPhoneNumber = phoneNumber;
		
	}
	
	public void addService(Service service) {
		services.add(service);
	}
	
	public String getClientName() { return clientName;}
	public String getClientSurname() { return clientSurname;}
	public String getClientPhoneNumber() { return clientPhoneNumber;}
	
	public void setClientName(String clientName) { this.clientName = clientName;}
	public void setClientSurname(String clientSurname) { this.clientSurname = clientSurname;}
	
	public void setClientPhoneNumber(String phoneNumber) {
		
		if(isPhoneNoValid(phoneNumber)) 
			clientPhoneNumber = phoneNumber;
		
		
	}
	
	private boolean isPhoneNoValid(String phoneNumber) {
		
		boolean isValid = true;
		
		if((phoneNumber.length() != 10 && phoneNumber.length() != 12) || 
		(!phoneNumber.startsWith("+27") &&
		!phoneNumber.startsWith("031") && 
		!phoneNumber.startsWith("06") && 
		!phoneNumber.startsWith("07") &&
		!phoneNumber.startsWith("08")))
			isValid = !isValid;
		else {
			for(int i = 2; i < 10; i++) {
				if(!Character.isDigit(phoneNumber.charAt(i)))
					isValid = !isValid;
			}
		}
		
		return isValid;
	}

	public boolean isOnContract() {
		return isOnContract;
	}

	public void setOnContract(boolean isOnContract) {
		this.isOnContract = isOnContract;
	}
}


