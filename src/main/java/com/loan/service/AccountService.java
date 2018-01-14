package com.loan.service;

import com.loan.model.Account;
import com.loan.model.LoanForm;
import com.loan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

      public Account findOrCreate(LoanForm loanForm) {
        Account account = accountRepository.findFirstByName(loanForm.getName());
        if (account == null) {
            account = new Account(loanForm.getName(), loanForm.getLastName(), loanForm.getLoanAmount(), loanForm.getMonths());
        }
        return account;
    }
}