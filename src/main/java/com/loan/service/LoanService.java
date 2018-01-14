package com.loan.service;

import com.loan.model.Account;
import com.loan.model.LoanForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.loan.repository.AccountRepository;

@Component
public class LoanService {
    @Autowired
    AccountRepository accountRepository;


    public void issue(LoanForm loanForm) {
        //sukurti servisa accservice.findorcreate
        Account account = accountRepository.findFirstByName(loanForm.getName());
        if (account == null) {
            account = new Account(loanForm.getName(), loanForm.getLastName(), loanForm.getLoanAmount(), loanForm.getMonths());
        }
        //

        if(isLoanValid(account, loanForm)) {
            Loan loan = new Loan(loanForm.getLoanAmount(), loanForm.getMonths());
            account.getLoans().add(loan);
            accountRepository.save(account);
        }

        accountRepository.save(account);
    }

    private boolean isLoanValid(Account account, LoanForm loan) {
        return false;
    }

    public Account findAccount(String name) {
        return accountRepository.findFirstByName(name);
    }
}
