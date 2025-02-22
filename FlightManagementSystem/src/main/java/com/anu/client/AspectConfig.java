package com.anu.client;

import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfig {
	
	@After("execution(* com.anu.client.FlightResources.createFlight(..))")
	public void added(JoinPoint joinPoint) {
		long time=System.currentTimeMillis();
//		System.out.println("Joinpoint signature :" + joinPoint.getSignature());
		System.out.println("Booking time : "+ DateFormat.getDateTimeInstance().format(time)+"\n");
		
	}

}
