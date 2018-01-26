package com.loan.service;

import com.loan.model.Account;
import com.loan.model.Loan;
import com.loan.model.LoanForm;
import com.loan.model.WebUtils;
import com.loan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanService {
    //private Loan loan;
    private AccountRepository accountRepository;
    private AccountService accountService;
    private WebUtils webUtils;

    @Autowired
    public LoanService(AccountRepository accountRepository, AccountService accountService, WebUtils webUtils) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.webUtils = webUtils;
    }


    public void issue(LoanForm loanForm) {
        Account account = accountService.findOrCreate(loanForm);
        if (isValid(account, loanForm)) {
            account.addLoan(new Loan(loanForm.getLoanAmount(), loanForm.getMonths(), webUtils.getClientIp()));
            accountService.saveAccount(account);
        }
    }

    private boolean isValid(Account account, LoanForm loan) {
       // while ((isAccountValid(account) && isLoanValid(loan)) == true) {
            return true;
       // }
       // return false;
    }

    private boolean isLoanValid(LoanForm loan) {
        //pagalvot kaip validuot
        while (loan.getLoanAmount().scale() == 0) {
            return true;
        }
        return false;
    }

    private boolean isAccountValid(Account account) {
        while(account.getName().matches("[a-zA-Z ]") &&
        account.getLastName().matches("[a-zA-Z][ '-.]") == true){
            return true;
        }
        return false;
    }

    public Account findAccount(String name) {
        return accountRepository.findFirstByName(name);
    }
}
