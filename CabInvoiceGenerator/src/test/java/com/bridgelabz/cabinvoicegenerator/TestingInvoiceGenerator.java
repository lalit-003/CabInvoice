package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class TestingInvoiceGenerator {

	InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	double distance;
	double time;
	double fare;

	// test to calculate fare for cab when provided ride time and distance
	@Test
	public void givenTimeAndDistance_ShouldReturnTotalFare() {
		distance = 2.0;
		time = 5.0;
		fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	// test to to check minimum fare case
	@Test
	public void givenTimeAndDistance_ShouldReturnTotalFareOrMinimumFare() {
		distance = 0.1;
		time = 3.0;
		fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
    
	//test to get total for multiple rides
	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(3, 15), new Ride(2, 5), new Ride(.1, 1), };
		fare = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(75, fare, 0.0);
	}

}
