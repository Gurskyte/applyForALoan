package com.loan.service;

import com.loan.model.*;
import com.loan.repository.AccountRepository;
import com.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanService{
    private AccountRepository accountRepository;
    private AccountService accountService;
    private WebUtils webUtils;
    private LoanRepository loanRepository;


    @Autowired
    LoanService(AccountRepository accountRepository, AccountService accountService, WebUtils webUtils, LoanRepository loanRepository) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.webUtils = webUtils;
        this.loanRepository = loanRepository;
    }


    public void issue(LoanForm loanForm) {
        if (isValid()) {
            Account account = accountService.findOrCreate(loanForm);
            account.addLoan(new Loan(loanForm.getLoanAmount(), loanForm.getMonths(), webUtils.getClientIp()));
            accountService.saveAccount(account);
        }
    }

    private boolean isValid(){
        LocalDateTime nowMinusDay = LocalDateTime.now().minusSeconds(5);
        String clientIp = webUtils.getClientIp();
        int loanCount = loanRepository.countByIpBeforeDate(clientIp, nowMinusDay);
        if(loanCount < 3) {
            return true;
        }
        throw new LoanNotValidException("Loan was took more than 3 times per 24 hours");
    }

    public Account findAccount(String name) {
        return accountRepository.findFirstByName(name);
    }

    public List<Loan> findAllLoans() {
        return loanRepository.findAll();
    }
}
