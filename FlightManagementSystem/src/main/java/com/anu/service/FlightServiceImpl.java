package com.anu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import com.anu.client.Config;
import com.anu.domain.Flight;
import com.anu.repository.FlightRepository;
import com.anu.repository.FlightRepositoryImpl;

@Service(value="flightService")
public class FlightServiceImpl implements FlightService{
 	@Autowired
	private FlightRepository fRepo;
	
	public void setfRepo(FlightRepository fRepo) {
		this.fRepo = fRepo;
	}

	@Override
	public void save(Flight flight) {
		fRepo.saveFlight(flight);		
	}

	@Override
	public Flight find(int fid) {
		
		 return fRepo.findFlight(fid);
	}

}