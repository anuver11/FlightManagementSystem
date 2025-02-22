package com.anu.domain;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Flight {
	
	private int flightId;
    private String airlines;
    private String source;
    private String destination;
    private Double fare;
    private String journeyDate;
    private Integer seatCount;    
	
	public Flight() {
		super();
	}
	public Flight(int flightId, String airlines, String source, String destination, Double fare, String journeyDate,
			Integer seatCount) {
		super();
		this.flightId = flightId;
		this.airlines = airlines;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.journeyDate = journeyDate;
		this.seatCount = seatCount;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Integer getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	
	@Override
	public String toString() {
		System.out.println("FlightID  Airline  Source  Destination  JourneyDate  SeatCount  Fare");
		return flightId + "	  " + airlines + "   " + source + "   "
				+ destination + "    " + journeyDate + " 	 " + seatCount + "      "+fare ;
	}
    

}
