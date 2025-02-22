package com.anu.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.anu.domain.Flight;
import com.anu.repository.FlightRepository;
import com.anu.repository.FlightRepositoryImpl;
import com.anu.service.FlightService;
import com.anu.service.FlightServiceImpl;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.anu")
public class Config {
	
//	@Bean
//	public Flight flight() {
//		return new Flight();
//	}
//	@Bean
//	public FlightResources flightResources() {
//		return new FlightResources();
//	}
//	@Bean
//	public FlightRepository flightRepository() {
//		return new FlightRepositoryImpl();
//	}
//	@Bean
//	public FlightService flightService() {
//		FlightServiceImpl flightService=new FlightServiceImpl();
//		flightService.setfRepo(flightRepository());
//		return flightService;
//	}

}
