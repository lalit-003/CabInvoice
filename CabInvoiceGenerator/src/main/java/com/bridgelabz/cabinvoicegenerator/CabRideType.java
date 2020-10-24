package com.bridgelabz.cabinvoicegenerator;

public enum CabRideType {
    NORMAL_RIDE(10.0,1.0,5.0) , PREMIUM_RIDE(15.0,2.0,20.0);

	public double costPerKM ;
	public double costPerTime;
	public double minimum_Fare;
	
	private CabRideType(double costPerKM, double costPerTime, double minimum_Fare) {
		this.costPerKM = costPerKM;
		this.costPerTime = costPerTime;
		this.minimum_Fare = minimum_Fare;
	}	
	
	public double calculateRideCost(Ride ride)
	{
		double rideCost = ride.distance * costPerKM + ride.time * costPerTime;
		return Math.max(rideCost, minimum_Fare);
	}
	
		
}
