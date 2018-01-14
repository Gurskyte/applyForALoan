package com.loan.service;

import com.loan.model.Account;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//nzn ar reik
    private BigDecimal loanAmount;
    private int months;
    //@OneToMany
 //   private Account account;

    public Loan(BigDecimal loanAmount, int months) {
        this.loanAmount = loanAmount;
        this.months = months;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }
}
