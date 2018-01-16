package com.loan.service;

import com.loan.model.Account;
import com.loan.model.Loan;
import com.loan.model.LoanForm;
import com.loan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private AccountRepository accountRepository;
    private AccountService accountService;

    @Autowired
    public LoanService(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }


    public void issue(LoanForm loanForm) {
        Account account = accountService.findOrCreate(loanForm);
        if (isLoanValid(account, loanForm) == true) {
            account.addLoan(new Loan(loanForm.getLoanAmount(), loanForm.getMonths()));
            //cia nereikia saugoti, perdarytio, kad kreiptusi i accService ir ten saugotu.
            accountRepository.save(account);
        }
    }

    private boolean isLoanValid(Account account, LoanForm loan) {
        return true;
    }

    public Account findAccount(String name) {
        return accountRepository.findFirstByName(name);
    }
}
