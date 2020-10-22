package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGenerator {

	public double CostPerKM = 10;
	public double CostPerTime = 1;
	public double Minimum_Fare = 5;
	double totalFare;

	public double calculateFare(double distance, double time) {
		totalFare = distance * CostPerKM + time * CostPerTime;
		return Math.max(totalFare, Minimum_Fare);
	}

	public double calculateFare(Ride[] rides) {
		double fare =0;
		for (Ride ride : rides) {
			fare += this.calculateFare(ride.distance, ride.time);
		}
		return fare;
	}

}
