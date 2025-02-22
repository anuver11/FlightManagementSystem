package com.anu.service;

import com.anu.domain.Flight;

public interface FlightService {
	
	public void save(Flight flight);
	public Flight find(int fid);

}
