package com.wantsCalc;

import java.text.ParseException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;


public class Main {
	public static void main(String[] args) throws ParseException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate date = LocalDate.parse("11/06/24", format);
		Wants nikeAF = new Wants("nikeAF", 8000, date);
		monthlyContribution(nikeAF);
	}
	
	public static void monthlyContribution(Wants product ) {
		int daysRemaining;
		int monthsToSave;
		LocalDate today = LocalDate.now();
		LocalDate desiredDate = product.getDateNeeded();
		daysRemaining = calcRemainingDays(today, desiredDate);
		
		if(daysRemaining < 0) {
			System.out.println("This does not look right, you cannot save in the past!");
		}else if(daysRemaining%30 > 15) {
			
			monthsToSave = (int) Math.ceil(daysRemaining/30);
			System.out.println("To buy "+product.getDesireName()+" on "+product.getDateNeeded()+" you will need to save "
					+Math.round(product.getRequiredSum()/monthsToSave)+" from now");
		}else{
			
			monthsToSave = (int) Math.floor(daysRemaining/30);
			System.out.println("To buy "+product.getDesireName()+" on "+product.getDateNeeded()+" you will need to save "
					+Math.round(product.getRequiredSum()/monthsToSave)+" from now");
		}
	}
	public static int calcRemainingDays(LocalDate today, LocalDate deadLine) {
		int daysRemaining;
		if(today.getYear() < deadLine.getYear()) {
			int thisYearRemaining = 365 - today.getDayOfYear();
			daysRemaining = thisYearRemaining + deadLine.getDayOfYear();
			return daysRemaining;
		}else if(today.getYear() == deadLine.getYear() && today.getMonthValue()<deadLine.getMonthValue()) {
			daysRemaining = deadLine.getDayOfYear() - today.getDayOfYear();
			return daysRemaining;
		}else {
			return -1;
		}
	}
}
