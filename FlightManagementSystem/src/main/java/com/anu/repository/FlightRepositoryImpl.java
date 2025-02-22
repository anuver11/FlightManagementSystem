package com.anu.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anu.domain.Flight;

@Repository(value = "flightRepository")
public class FlightRepositoryImpl implements FlightRepository{
	
	private int flightid=1001;
	
	static private Map<Integer, Flight> map=new HashMap<>();

	@Override
	public void saveFlight(Flight flight) {
		flight.setFlightId(flightid++);
		map.put(flight.getFlightId(), flight);
	}

	@Override
	public Flight findFlight(int fid) {
		
		return map.get(fid);		
	}

}
