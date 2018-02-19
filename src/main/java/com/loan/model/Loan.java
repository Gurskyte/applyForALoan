package com.loan.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
//@Table(name = "loans", catalog = "test")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "loan_amount")
    private BigDecimal loanAmount;
    @Column(name = "months")
    private int months;
    @Column(name = "ip")
    private String ip;
    @Column(name = "issue_date")
    LocalDateTime issueDate;

    public Loan() {
    }

    public Loan(BigDecimal loanAmount, int months, String clientIp) {
        this.loanAmount = loanAmount;
        this.months = months;
        this.ip = clientIp;
        this.issueDate = LocalDateTime.now();
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

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }


}
