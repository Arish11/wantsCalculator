package com.wantsCalc;

import java.text.ParseException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;


public class Main {
	public static void main(String[] args) throws ParseException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate date = LocalDate.parse("11/06/23", format);
		Wants nikeAF = new Wants("nikeAF", 8000, date);
		monthlyContribution(nikeAF);
	}
	
	public static void monthlyContribution(Wants product ) {
		LocalDate today = LocalDate.now();
		int currMonth = today.getMonth().getValue();
		System.out.println(currMonth);
		int desiredMonth = product.getDateNeeded().getMonthValue();
		System.out.println(desiredMonth);
		int timeLeft = desiredMonth - currMonth;
		int requiredSum = product.getRequiredSum(); 
		System.out.println("To buy "+product.getDesireName()+" on "+product.getDateNeeded()+" you will need to save "
				+Math.round(requiredSum/timeLeft)+" from now");
	}
}
