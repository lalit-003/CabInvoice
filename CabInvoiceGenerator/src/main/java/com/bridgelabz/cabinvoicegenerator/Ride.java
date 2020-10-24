package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	public double distance;
	public double time;
	public CabRideType cabRideType;
	
	public Ride(CabRideType cabRideType, double distance,double time)
	{
		this.cabRideType=cabRideType;
		this.time = time;
		this.distance = distance;
	}
}
