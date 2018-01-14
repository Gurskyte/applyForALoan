package com.loan.service;

import com.loan.model.Account;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;

/**
 * Created by Ugne on 2018.01.11.
 */
@Entity
public class Loan {
    private BigDecimal loanAmount;
    private int months;
    @OneToMany
    private Account account;

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
