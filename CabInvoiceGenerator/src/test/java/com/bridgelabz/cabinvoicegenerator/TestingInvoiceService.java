package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestingInvoiceService {

	InvoiceService invoiceService = new InvoiceService();
	double distance;
	double time;
	double fare;
	String userId1;
	String userId2;
	private RideRepository rideRepository;

	@Before
	public void initialization()
	{
		invoiceService.setRepository(rideRepository);
		 userId1 = "user1";
		Ride[] rides1 = { new Ride(CabRideType.PREMIUM_RIDE,3, 15), new Ride(CabRideType.NORMAL_RIDE,2, 5), new Ride(CabRideType.PREMIUM_RIDE,.1, 1), };
		 userId2 = "user2";
		Ride[] rides2 = { new Ride(CabRideType.NORMAL_RIDE,2, 10), new Ride(CabRideType.NORMAL_RIDE,1, 5), new Ride(CabRideType.NORMAL_RIDE,.1, 1), };

		invoiceService.addRides(userId1, rides1);
		invoiceService.addRides(userId2, rides2);
	}
	
	// test to calculate fare for cab when provided ride time and distance
	@Test
	public void givenTimeAndDistance_ShouldReturnTotalFare() {
		distance = 2.0;
		time = 5.0;
		fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	// test to to check minimum fare case
	@Test
	public void givenTimeAndDistance_ShouldReturnTotalFareOrMinimumFare() {
		distance = 0.1;
		time = 3.0;
		fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	// test to check multiple rides invoice summary
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(CabRideType.NORMAL_RIDE,3, 15), new Ride(CabRideType.NORMAL_RIDE,2, 5), new Ride(CabRideType.NORMAL_RIDE,.1, 1), };
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(3, 75.0);
		Assert.assertEquals(expectedSummary, summary);
	}

		// test to get invoice summary from user name
	@Test
	public void givenUserId_ShouldReturnInvoiceSummaryForTypeRide() {
		
		InvoiceSummary summary1 = invoiceService.getInvoiceSummary(userId1);
		InvoiceSummary expectedSummary1 = new InvoiceSummary(3, 120.0);
		InvoiceSummary summary2 = invoiceService.getInvoiceSummary(userId2);
		InvoiceSummary expectedSummary2 = new InvoiceSummary(3, 50.0);

		Assert.assertEquals(expectedSummary1, summary1);
		Assert.assertEquals(expectedSummary2, summary2);
	}

	
	

}
