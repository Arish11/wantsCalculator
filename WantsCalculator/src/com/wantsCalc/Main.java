package com.wantsCalc;

import java.text.ParseException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws ParseException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		Scanner sc = new Scanner(System.in);
		boolean addMoreFlag = true;
		List<Wants> wantList = new ArrayList<Wants>();
		System.out.println("Let's add some wants!\n");
		
		while(addMoreFlag) {
			Wants obj = new Wants();
			System.out.println("please add the name of what you want");
			obj.setDesireName(sc.next());
			System.out.println("Great! When do you plan to buy "+obj.getDesireName()+" please enter date in dd/mm/yy");
			obj.setDateNeeded(LocalDate.parse(sc.next(), format));
			System.out.println("How much will you need to buy "+obj.getDesireName()+" on "+obj.getDateNeeded()+" ?");
			obj.setRequiredSum(sc.nextInt());
			wantList.add(obj);
			System.out.println("Do you wish to add more wants?\nY - yes \t N - no");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("Y")) {
				addMoreFlag = true;
			}else {
				addMoreFlag = false;
			}
		}		
		summationFunc(wantList);
		sc.close();
	}
	
	public static void summationFunc(List<Wants> wantList) {
		int totalEveryMonth = 0;
		System.out.println("My wants are "+wantList);
		for(Wants want : wantList) {
			System.out.println("To buy "+want.getDesireName()+" I need "+monthlyContribution(want));
			totalEveryMonth += monthlyContribution(want);
		}
		System.out.println("To full fill all my wants I will need "+totalEveryMonth);
	}
	
	public static int monthlyContribution(Wants product ) {
		int daysRemaining;
		int monthsToSave;
		LocalDate today = LocalDate.now();
		LocalDate desiredDate = product.getDateNeeded();
		daysRemaining = calcRemainingDays(today, desiredDate);
		
		if(daysRemaining < 0) {
			return 0;
			//System.out.println("This does not look right, you cannot save in the past!");
		}else if(daysRemaining%30 > 15) {
			
			monthsToSave = (int) Math.ceil(daysRemaining/30);
			return Math.round(product.getRequiredSum()/monthsToSave);
			//System.out.println("To buy "+product.getDesireName()+" in "+monthsToSave+" months you will need to save "+Math.round(product.getRequiredSum()/monthsToSave)+" from now");
		}else{
			
			monthsToSave = (int) Math.floor(daysRemaining/30);
			return Math.round(product.getRequiredSum()/monthsToSave);
			//System.out.println("To buy "+product.getDesireName()+" in "+monthsToSave+" mpnths you will need to save "+Math.round(product.getRequiredSum()/monthsToSave)+" from now");
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
