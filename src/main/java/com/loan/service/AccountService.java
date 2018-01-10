package com.loan.service;

import com.loan.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.loan.repository.AccountRepository;

@Component
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account findAccount(String name) {
        return accountRepository.findFirstByName(name);
    }
}
