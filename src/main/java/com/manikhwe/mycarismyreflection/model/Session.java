package com.manikhwe.mycarismyreflection.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Session")
@Component
public class Session extends Service implements Serializable, Comparable<Session>{

	private static final long serialVersionUID = -5926344161781510512L;
	
	@Id
	@GeneratedValue
	@Column(name="Session_Id", nullable=false)
	private long sessionId;
	
	@Column(name="Session_Date", nullable=false)
	private String sessionDate = "";
	
	@Column(name="Session_Time", nullable=false)
	private String sessionTime = "";
	
	@Column(name="Session_Cost", nullable=false)
	private double sessionCost;
	
	@Column(name="Sessions_No_Of_Cars", nullable=false)
	private short numberOfCars;
	
	@Column(name="Succeeded", nullable=false)
	private boolean wasSuccessful;
	
	@OneToOne
	private Request request;
	
	public Session() {
		
	}
	
	public Session(Client client, Address sessionAddress) {
		super(client,sessionAddress);
	}
	
	@Override
	public boolean equals(Object o) {
		
		Session newSession = (Session)o;
		
		return sessionAddress.equals(
		newSession.getSessionAddress()) &&
		sessionDate.equals(newSession.getSessionDate())
		&& sessionTime.equals(newSession.getSessionTime());
	}
	
	public boolean isWasSuccessful() {
		return wasSuccessful;
	}

	public void setWasSuccessful(boolean wasSuccessful) {
		this.wasSuccessful = wasSuccessful;
	}

	public String getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}

	public void setSessionDate(String date) {
		
		sessionDate = date;
	}
	
	private String formatDate(String date) {
		
		String preferedDate = "";
		
		preferedDate += date.substring(date.lastIndexOf(" "));
		preferedDate += '-';
		preferedDate += findMonth(date.substring(4, 7));
		preferedDate += '-';
		preferedDate += date.substring(8, 10);
		
		return preferedDate;
	}
	
	private String findMonth(String month) {
		
		String monthAsDigits = "";
		switch(month) {
		case "Jan" : monthAsDigits = "01"; break;
		case "Feb" : monthAsDigits = "02"; break;
		case "Mar" : monthAsDigits = "03"; break;
		case "Apr" : monthAsDigits = "04"; break;
		case "May" : monthAsDigits = "05"; break;
		case "Jun" : monthAsDigits = "06"; break;
		case "Jul" : monthAsDigits = "07"; break;
		case "Aug" : monthAsDigits = "08"; break;
		case "Sep" : monthAsDigits = "09"; break;
		case "Oct" : monthAsDigits = "10"; break;
		case "Nov" : monthAsDigits = "11"; break;
		default : monthAsDigits = "12";
		}
		
		return monthAsDigits;
	}

	public short getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(short numberOfCars) {
		this.numberOfCars = numberOfCars;
	}

	public void setSessionCost(double sessionCost) {
		this.sessionCost = sessionCost;
	}

	public void setSelectedDay(String selectedDay) {
		
		if(sessionDate.equals("") ) {
			final long DAY_MILLISECONDS = 60000*60*24;
			Date prefDate;
			if(selectedDay.equals("Today")) {
				prefDate = new Date(System.currentTimeMillis());
			}
			else if(selectedDay.equals("Tommorow")) {
				prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS);
			}
			else if(selectedDay.equals("Monday")) {
				switch(Calendar.DAY_OF_WEEK) {
				case 1:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*7);
					break;
				case 2:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*6);
					break;
				case 3:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*5);
					break;
				case 4:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*4);
					break;
				case 5:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*3);
					break;
				case 6:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*2);
					break;
				default:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*1);
				}
			}
			else if(selectedDay.equals("Tuesday")) {
				switch(Calendar.DAY_OF_WEEK) {
				case 1:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*1);
					break;
				case 2:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*7);
					break;
				case 3:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*6);
					break;
				case 4:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*5);
					break;
				case 5:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*4);
					break;
				case 6:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*3);
					break;
				default:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*2);
					
				}	
			}
			else if(selectedDay.equals("Wednesday")) {
				switch(Calendar.DAY_OF_WEEK) {
				case 1:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*2);
					break;
				case 2:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*1);
					break;
				case 3:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*7);
					break;
				case 4:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*6);
					break;
				case 5:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*5);
					break;
				case 6:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*4);
					break;
				default:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*3);
				}
			}
			else if(selectedDay.equals("Thursday")) {
				switch(Calendar.DAY_OF_WEEK) {
				case 1:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*3);
					break;
				case 2:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*2);
					break;
				case 3:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*1);
					break;
				case 4:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*7);
					break;
				case 5:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*6);
					break;
				case 6:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*5);
					break;
				default:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*4);
				}
			}
			else if(selectedDay.equals("Friday")) {
				switch(Calendar.DAY_OF_WEEK) {
				case 1:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*4);
					break;
				case 2:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*3);
					break;
				case 3:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*2);
					break;
				case 4:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*1);
					break;
				case 5:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*7);
					break;
				case 6:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*6);
					break;
				default:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*5);
				}
			}
			else if(selectedDay.equals("Surtaday")) {
				switch(Calendar.DAY_OF_WEEK) {
				case 1:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*5);
					break;
				case 2:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*4);
					break;
				case 3:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*3);
					break;
				case 4:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*2);
					break;
				case 5:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*1);
					break;
				case 6:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*7);
					break;
				default:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*6);
				}
			}
			else {
				switch(Calendar.DAY_OF_WEEK) {
				case 1:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*6);
					break;
				case 2:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*5);
					break;
				case 3:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*4);
					break;
				case 4:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*3);
					break;
				case 5:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*2);
					break;
				case 6:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*1);
					break;
				default:
					prefDate = new Date(System.currentTimeMillis()+DAY_MILLISECONDS*7);
				}
			}
			
			sessionDate = formatDate(prefDate.toString());
		}
		
	}
	
	@Override
	public int compareTo(Session session) {
		return sessionDate.compareTo(session.getSessionDate());
	}

	public String getSessionDate() {
		
		return sessionDate;
	}

	public long getSessionId() {
		return sessionId;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}
	
	// Incomplete
	public double getSessionCost() {
		
		return sessionCost;
	}
}


