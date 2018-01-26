package com.loan.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


@Entity
//@Table(name = "loans", catalog = "test")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private Long id;
    @Column(name = "account_lastName")
    private BigDecimal loanAmount;
    @Column(name = "months")
    private int months;
    @Column(name = "ip")
    private String ip;

   // Timestamp timeNow = new Timestamp(new Date().getTime());

    public Loan() {
    }

    public Loan(BigDecimal loanAmount, int months, String ip) {
        this.loanAmount = loanAmount;
        this.months = months;
        this.ip = ip;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

   /* public Timestamp getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(Timestamp timeNow) {
        this.timeNow = timeNow;
    }*/
}
