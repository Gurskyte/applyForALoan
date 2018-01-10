package com.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private BigDecimal loanAmount;
    private int months;
    //private Time timeWhenAskedForALoan;
    private boolean giveLoanOrNot;

    //Risk.isRiskyTime();



    public Account() {
        super();
    }

    public Account(String name, String lastName, BigDecimal loanAmount, int months) {
        this.name = name;
        this.lastName = lastName;
        this.loanAmount = loanAmount;
        this.months = months;
       // this.timeWhenAskedForALoan = new Time();
    }
/*
    public Date getTimeWhenAskedForALoan() {
        return timeWhenAskedForALoan;
    }

    public void setTimeWhenAskedForALoan(Time timeWhenAskedForALoan) {
        this.timeWhenAskedForALoan = timeWhenAskedForALoan;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

/*
    public long getId() {
        return id;
    }

    public void setId() {
       this.id = id;
    }*/

    public BigDecimal getloanAmount() {
        return loanAmount;
    }

    public void setloanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }
    public boolean isGiveLoanOrNot() {
        return giveLoanOrNot;
    }

    public void setGiveLoanOrNot(boolean giveLoanOrNot) {
        this.giveLoanOrNot = giveLoanOrNot;
    }

}
