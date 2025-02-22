package com.anu.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.anu.domain.Flight;
import com.anu.service.FlightService;
import com.anu.service.FlightServiceImpl;

public class FlightClient{
	
    public static void main( String[] args ){    	
    	
    	AbstractApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
    	FlightResources client= (FlightResources)context.getBean("flightResources");    	
    	FlightService flightService= (FlightService)context.getBean("flightService");
    	Scanner sc= new Scanner(System.in);
    	int choice=0;
    	while(choice!=4) {
    		try {
    			client.displayMenu();
    			System.out.println("Enter your choice : ");
    			choice=sc.nextInt();
    			switch(choice) {
    			case 1:
    				Flight flight=(Flight)context.getBean("flight");
    				client.createFlight(sc,flightService,flight);
    				break;
    			case 2:
    				client.find(sc,flightService);
    				break;
    			case 3:
    		    	String monthStr=client.travelDate(sc).substring(3,5);
    		    	int month=Integer.parseInt(monthStr);    		    	
    		    	client.search(sc, month);
    				break;    			
    			case 4:
    				sc.close();
    				System.exit(1);
    				break;
				default:
					System.out.println("Invalid choice!!, Please enter your choice again");
					break;    			
    			}
    		}catch (Exception e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
    	}
    }    
}
