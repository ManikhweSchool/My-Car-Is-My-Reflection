package com.manikhwe.mycarismyreflection.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Request")
@Component
public class Request implements Serializable, Comparable<Request>{

	private static final long serialVersionUID = 375933753039621426L;
	
	@Id
	@GeneratedValue
	@Column(name="Request_Id", nullable=false)
	private long requestId;
	
	@Column(name = "Request_Query_Date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(value = TemporalType.DATE)
	private Date queryDate;
	
	@OneToOne
	private Session session;
	
	private byte numberOfCars;
	
	public Request() {
		queryDate = new Date();
	}
	
	@Override
	public boolean equals(Object o) {
		
		Request newRequest = (Request)o;
		
		return queryDate.equals(
		newRequest.getQueryDate()) &&
		session.equals(newRequest.getSession());
	}

	public Date getQueryDate() {
		return queryDate;
	}
	
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
	
	public byte getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(byte numberOfCars) {
		this.numberOfCars = numberOfCars;
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public long getRequestId() { return requestId;}

	@Override
	public int compareTo(Request request) {
		
		return queryDate.compareTo(request.getQueryDate());
	}

}

