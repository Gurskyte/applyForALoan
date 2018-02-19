package com.loan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "accounts", catalog = "test")
public class Account {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personal_number")
    private Long personalNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_personal_number", referencedColumnName = "personal_number")
    private List<Loan> loans = new ArrayList<>();

    public Account() {
        super();
    }

    public Account(Long personalNumber, String name, String lastName) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }
}

