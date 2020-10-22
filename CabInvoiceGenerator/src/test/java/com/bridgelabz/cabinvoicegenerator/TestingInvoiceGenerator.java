package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class TestingInvoiceGenerator {

	@Test
	public void givenTimeAndDistance_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		double time = 5.0;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare,0.0);
	}
	
	@Test
	public void givenTimeAndDistance_ShouldReturnTotalFareOrMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		double time = 3.0;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare,0.0);
	}

}