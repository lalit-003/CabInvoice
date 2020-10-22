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
    
	//test to check multiple rides invoice summary
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(3, 15), new Ride(2, 5), new Ride(.1, 1), };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(3,75.0);
		Assert.assertEquals(expectedSummary,summary);
	}

}
