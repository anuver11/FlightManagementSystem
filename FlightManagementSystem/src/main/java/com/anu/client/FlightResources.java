package com.anu.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.anu.domain.Flight;
import com.anu.service.FlightService;
import com.anu.service.FlightServiceImpl;

@Component
public class FlightResources {
	
	public void displayMenu() {
		      String line="********************************";
		System.out.println(line);
		System.out.println("*           M E N U            *");
		System.out.println(line);
		System.out.println("* 1. Book Flight               *");	
		System.out.println("* 2. Check Your Flight Details *");
		System.out.println("* 3. Search Flight             *");
		System.out.println("* 4. Exit                      *");
		System.out.println(line+"\n");
	}
	
	 public void createFlight(Scanner sc,FlightService flightService,Flight flight) {
		 
	    	String dateString=travelDate(sc);
	    	String monthStr= dateString.substring(3,5);
	    	int month=Integer.parseInt(monthStr);
	    	search(sc, month);
	    	
	    	System.out.println("Enter Flight Details.......\n");
	    	
	    	
	    	int routeNo = takeRoute(sc);  	
	    	sc.nextLine();
	    	
	    	System.out.println("Enter AirLine Nane : ");
	    	String fName = sc.nextLine();
	    	flight.setAirlines(fName);
	    	
	    	System.out.println("Enter Seat Count : ");
	    	
	    	int fcount = seatCount(sc);
	    	flight.setSeatCount(fcount);
	    	
	    	routeSet(routeNo, flight,month,fcount);
	    	flight.setJourneyDate(dateString);
	    	flightService.save(flight);
	    	
	    	
	    	System.out.println("                       Booking Details");
	    	System.out.println("*******************************************************************");
	    	System.out.println(flight+"\n");	
	    	
	    }
	 
	public double fare(int month, double rate) {		
		
		if(month>=9 && month<=12) {
			rate=rate*1.2;
		}
		return rate;		
	}
	
	 public void search(Scanner sc, int month) {		    	
	    	
	    	System.out.println("      Avaliable flights and Fares");
	    	System.out.println("******************************************");
	    	System.out.println("   Source        Destination       Fare");
	    	System.out.println("1. Mumbai        Bangluru         "+fare(month, 12000));
	    	System.out.println("2. Mumbai        Goa              "+fare(month, 15000));
	    	System.out.println("3. Bangluru      Hydrabad         "+fare(month, 19000)+"\n");
	    }
	 
	 public void find(Scanner sc,FlightService fs) {
		 System.out.println("Enter FlightID : ");
		 int id=sc.nextInt();		 
		 
		 Flight flight=fs.find(id);
		 
		 if(flight==null) {
			 System.out.println("No records found\n");
		 }else {			 
			 System.out.println(flight+"\n");
		 }		 
	 }
	 
	 public void routeSet(int route, Flight flight, int month, int seatCount) {
		 
		 if(route==1) {
			 flight.setSource("Mumbai");
			 flight.setDestination("Bangaluru");	
			 flight.setFare(seatCount*fare(month, 12000));
			 			 
		 }else if(route==2) {
			 flight.setSource("Mumbai");
			 flight.setDestination("Goa");
			 flight.setFare(seatCount*fare(month, 15000));
			
		 }else {
			 flight.setSource("Bangaluru");
			 flight.setDestination("Hyderabad");
			 flight.setFare(seatCount*fare(month, 19000));			 
		 }
		 
	 }
	 public String travelDate(Scanner sc) {
		 
		 String dateString ="";
		 boolean flag=true;	        
	        
	        while(flag) {
	        	try {  
	        		System.out.println("Enter Travelling Date(dd/MM/yyyy) : ");      
	                String dateStr = sc.next();  
	               
	                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	                Date date = sdf.parse(dateStr);
	                dateString=sdf.format(date);
	                flag=false;               
	                System.out.println();
	            } catch (ParseException e) {
	            	System.out.println("\nInvalid Date Format.");
	                System.out.println("Please Enter Date in Required Format.\n");  
	            }  
	        }
			return dateString;	    	
	 }
	 
	 public int takeRoute(Scanner sc) {
		 
		 int routeNo=0;		 
		 
		 while(routeNo<1 || routeNo>3) {
			 try {
				 System.out.println("Enter Route No : ");
				 routeNo= sc.nextInt();	
				 if(routeNo>3 || routeNo<1) {
					 System.out.println("Please enter correct Route Number");					 
				 }
			 }catch (Exception e) {
				System.out.println("Please enter correct Route Number.");
				sc.nextLine();
			}
		 }
		 return routeNo;
	 }
	 
	 public int seatCount(Scanner sc) {
		 
		 int count=0;
		 boolean flag=true;
		 
		 while(flag) {
			 try {
				 count=sc.nextInt();
				 flag=false;
				 if(count<0) {
					 flag=true;
					 System.out.println("Enter valid Number.");
				 }				 				 
			 }catch (Exception e) {
				System.out.println("Enter valid Number.");
				sc.nextLine();
			}
		 }
		 return count;
	 }

}
