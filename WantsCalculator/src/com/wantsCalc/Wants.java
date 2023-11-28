package com.wantsCalc;

import java.time.LocalDate;
import java.util.Date;

public class Wants {
	private String desireName;
	private int requiredSum;
	private LocalDate dateNeeded;
	
	public Wants(String desireName, int requiredSum, LocalDate dateNeeded) {
		this.desireName = desireName;
		this.requiredSum = requiredSum;
		this.dateNeeded = dateNeeded;
	}
	
	public Wants() {
		
	}

	public String getDesireName() {
		return desireName;
	}
	public void setDesireName(String desireName) {
		this.desireName = desireName;
	}
	public int getRequiredSum() {
		return requiredSum;
	}
	public void setRequiredSum(int requiredSum) {
		this.requiredSum = requiredSum;
	}
	public LocalDate getDateNeeded() {
		return dateNeeded;
	}
	public void setDateNeeded(LocalDate dateNeeded) {
		this.dateNeeded = dateNeeded;
	}
	
	@Override
	public String toString() {
		return "Wants [desireName=" + desireName + ", requiredSum=" + requiredSum + ", dateNeeded=" + dateNeeded + "]";
	}
}
