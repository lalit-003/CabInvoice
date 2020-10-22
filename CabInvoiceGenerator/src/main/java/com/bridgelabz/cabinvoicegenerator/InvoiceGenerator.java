package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGenerator {
	
	public double CostPerKM = 10;
	public double  CostPerTime = 1;
	public double Minimum_Fare = 5;

	public double calculateFare(double distance, double time) {
		double totalFare = distance*CostPerKM+time*CostPerTime;
		if(totalFare<Minimum_Fare)
		totalFare=Minimum_Fare;
		return totalFare;
	}

}
