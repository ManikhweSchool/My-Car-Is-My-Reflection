package com.manikhwe.mycarismyreflection.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Contract")
@Component
public class Contract extends Service implements Serializable{
	
	private static final long serialVersionUID = -5979459699852625033L;
	
	@Id
	@GeneratedValue
	@Column(name="Contract_Id", nullable=false)
	private long contractId;
	
	@Column(name = "Contract_Start_Date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(value = TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "Contract_End_Date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(value = TemporalType.DATE)
	private Date endDate;
	
	@OneToMany(
		mappedBy="contract",
		cascade= CascadeType.ALL,
		orphanRemoval = true
	)
	private Collection<Car> cars;
	
	@ElementCollection
	private Collection<String> preferedDays;
	
	@ElementCollection
	private Collection<String> preferedTimes;
	
	@Column(name="Monthly_Payment", nullable=false)
	private double monthlyPayment;
	
	public Contract() {
		cars = new HashSet<>();
		preferedDays = new HashSet<>();
		preferedTimes = new HashSet<>();
	}

	public Contract(Date startDate, Date endDate, Collection<Car> cars, Collection<String> preferedDays,
			Collection<String> preferedTimes) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.cars = cars;
		this.preferedDays = preferedDays;
		this.preferedTimes = preferedTimes;
	}

	public Date getStartDate() {
		return startDate;
	}
	
	// Incomplete
	public double calculateMonthlyPayment() {
		return monthlyPayment;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}

	public Collection<String> getPreferedDays() {
		return preferedDays;
	}

	public void setPreferedDays(Collection<String> preferedDays) {
		this.preferedDays = preferedDays;
	}

	public Collection<String> getPreferedTimes() {
		return preferedTimes;
	}

	public void setPreferedTimes(Collection<String> preferedTimes) {
		this.preferedTimes = preferedTimes;
	}
	
	public long getContractId() {
		return contractId;
	}
	
}

