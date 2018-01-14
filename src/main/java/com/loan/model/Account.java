package com.loan.model;

import com.loan.service.Loan;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts", catalog = "test")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;
    private String name;
    @Column(name = "account_name")
    private String lastName;
    @Column(name = "account_lastName")
    private BigDecimal loanAmount;
    private int months;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private List<Loan> loans;








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


    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

}

