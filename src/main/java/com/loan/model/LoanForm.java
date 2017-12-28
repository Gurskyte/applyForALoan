package com.loan.model;

import java.math.BigDecimal;

public class LoanForm {
	private String name;
	private String lastName;
	private BigDecimal loneAmount;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getLoneAmount() {
		return loneAmount;
	}
	public void setLoneAmount(BigDecimal loneAmount) {
		this.loneAmount = loneAmount;
	}
	
	
}
