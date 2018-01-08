package com.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	private String surname;
	private String personalCode;
	private double value;
	private int monthsToPayForLoan;
	private String content;

	public Account(long id, String name, String surname, String personalCode, String content, double value, int monthsToPayForLoan) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.personalCode = personalCode;
		this.content = content;
		this.value = 0;
		this.setMonthsToPayForLoan(0);
	}
	
	//UserAccountInformation accountInformation = new UserAccountInformation(getId(), getName(), getSurname(), getPersonalCode(), getContent(), getValue(), getMonthsToPayForLoan());
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getMonthsToPayForLoan() {
		return monthsToPayForLoan;
	}

	public void setMonthsToPayForLoan(int monthsToPayForLoan) {
		this.monthsToPayForLoan = monthsToPayForLoan;
	}


	
}
