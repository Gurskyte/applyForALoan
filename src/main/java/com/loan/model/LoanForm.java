package com.loan.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class LoanForm {
    @Id
    private Long personalNumber;

    @NotBlank
    @Size(min = 3, max = 15)
    private String name;
    @NotBlank
    private String lastName;
    @Digits(integer = 6, fraction = 0)
    private BigDecimal loanAmount;
    private int months;

    public LoanForm() {
    }

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }
}
