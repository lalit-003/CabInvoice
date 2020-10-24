package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {

	public double CostPerKM = 10;
	public double CostPerTime = 1;
	public double Minimum_Fare = 5;
	double totalFare;
	private RideRepository rideRepository;

	public void setRepository(RideRepository rideRepository)
	{
		this.rideRepository= new RideRepository();
	}

	public double calculateFare(double distance, double time) {
		totalFare = distance * CostPerKM + time * CostPerTime;
		return Math.max(totalFare, Minimum_Fare);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double fare =0;
		for (Ride ride : rides) {
			fare +=ride.cabRideType.calculateRideCost(ride);
		}
		return new InvoiceSummary(rides.length, fare);
	}

	public void addRides(String userId, Ride[] rides) {
		 rideRepository.addRides(userId,rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

}
