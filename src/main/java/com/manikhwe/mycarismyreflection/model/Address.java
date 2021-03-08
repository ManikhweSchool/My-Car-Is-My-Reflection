package com.manikhwe.mycarismyreflection.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Address")
@Component
public class Address implements Serializable{

	private static final long serialVersionUID = -6636931282916339257L;
	
	@Column(name="Located_In_Durban", nullable=false)
	private boolean isInDurban;
	@Column(name="Township_Or_Surbub", nullable=false)
	private String townshipOrSurbub;
	@Id
	@Column(name="Durban_Area_Address", nullable=false)
	private String fullAddress;
	
	private Collection<Service> services;
	
	public static final TreeMap<String,Double> 
	distancesFromMayville = new TreeMap<>();
	
	public Address() {
		
		fullAddress = "";
		townshipOrSurbub = "";
	}
	
	public Address(String fullAddress, 
	String townshipOrSurbub, boolean isInDurban) {
		
		setFullAddress(fullAddress);
		setIsInDurban(isInDurban);
		setTownshipOrSurbub(townshipOrSurbub);
	}
	
	public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
	}

	public void setInDurban(boolean isInDurban) {
		this.isInDurban = isInDurban;
	}

	@Override
	public boolean equals(Object o) {
		
		Address newAddress = (Address)o;
		
		return isInDurban==newAddress.getIsInDurban()
			&& townshipOrSurbub.equals(
			newAddress.getTownshipOrSurbub()) &&
			fullAddress.equals(newAddress.getFullAddress());
	}
	
	public boolean getIsInDurban() {
		return isInDurban;
	}

	public void setIsInDurban(boolean isInDurban) {
		this.isInDurban = isInDurban;
	}

	public String getTownshipOrSurbub() {
		return townshipOrSurbub;
	}

	public void setTownshipOrSurbub(String townshipOrSurbub) {
		this.townshipOrSurbub = townshipOrSurbub;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	
	public String getFullAddress() { return fullAddress;}
}

