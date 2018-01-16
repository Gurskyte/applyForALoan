package com.loan.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
//@Table(name = "loans", catalog = "test")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private Long id;
    @Column(name = "account_lastName")
    private BigDecimal loanAmount;
    private int months;

    public Loan() {
    }

    public Loan(BigDecimal loanAmount, int months) {
        this.loanAmount = loanAmount;
        this.months = months;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
