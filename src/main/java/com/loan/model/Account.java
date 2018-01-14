package com.loan.model;

import com.loan.service.Loan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private BigDecimal loanAmount;
    private int months;

   // private List<Loan> loans;








    //private Time timeWhenAskedForALoan;
    private boolean giveLoanOrNot;

    //Risk.isRiskyTime();



    public Account() {
        super();
    }

    public Account(String name, String lastName, BigDecimal loanAmount, int months) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.loanAmount = loanAmount;
        this.months = months;
        this.giveLoanOrNot = Risk.isRiskyTime();
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
       this.id = id;
    }

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

/*
    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    */
}

