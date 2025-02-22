package com.anu.repository;

import com.anu.domain.Flight;

public interface FlightRepository {
	
	public void saveFlight(Flight flight);
	public Flight findFlight(int fid);

}
