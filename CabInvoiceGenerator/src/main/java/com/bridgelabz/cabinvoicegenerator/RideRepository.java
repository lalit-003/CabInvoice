package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {

	Map<String,ArrayList<Ride>> rideRepository =  null;
	
	public RideRepository()
	{
		this.rideRepository = new HashMap<>();
	}

	public void addRides(String userId, Ride[] rides) {
         	  this.rideRepository.put(userId, new ArrayList<>(Arrays.asList(rides)));
	}

	public Ride[] getRides(String userId) {
		return this.rideRepository.get(userId).toArray(new Ride[0]);
	}
	
}
