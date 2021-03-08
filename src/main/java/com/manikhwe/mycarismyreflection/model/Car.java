package com.manikhwe.mycarismyreflection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Client_Car")
@Component
public class Car {

	@Id
	@Column(name = "Registration_Number", nullable = false)
	private String carRegistrationNumber;
	@Column(name = "Car_Name", nullable = false)
	private String carName;
	
	@ManyToOne
	@JoinColumn(name="owning_contract_id")
	private Contract contract;
	
	public Car() {
		super();
	}
	
	public Car(String carRegistrationNumber, String carName) {
		super();
		this.carRegistrationNumber = carRegistrationNumber;
		this.carName = carName;
	}



	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	
	
}

