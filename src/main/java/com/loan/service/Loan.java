package com.loan.service;

import com.loan.model.Account;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts", catalog = "test")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private Long id;
    private BigDecimal loanAmount;
    private int months;



    private Long account_id;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "account_id")
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
    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
}
