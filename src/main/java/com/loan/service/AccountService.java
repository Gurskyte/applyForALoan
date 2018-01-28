package com.loan.service;

import com.loan.model.Account;
import com.loan.model.LoanForm;
import com.loan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findOrCreate(LoanForm loanForm) {
        Account account = accountRepository.findFirstByName(loanForm.getName());
        if (account == null) {
            account = accountRepository.save(new Account(loanForm.getName(), loanForm.getLastName()));
        }
        return account;
    }
    public void saveAccount(Account account){
        accountRepository.save(account);
    }

}