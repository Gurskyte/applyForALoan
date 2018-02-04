package com.loan.repository;

import com.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findFirstByName(String name);
    Account findFirstByNameAndLastName(String name, String lastName);
}

