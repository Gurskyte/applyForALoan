package com.loan.service;

import com.loan.model.*;
import com.loan.repository.AccountRepository;
import com.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
        if(loanCount < 3 && isLoanTimeValid()) {
            return true;
        }
        throw new LoanNotValidException("Loan was took more than 3 times per 24 hours from one Ip or time is too risky");
    }

    private boolean isLoanTimeValid() {
        LocalTime timeNow = LocalTime.now();
        LocalTime riskyTimeBegins = LocalTime.parse("00:00:00");
        LocalTime riskyTimeENds = LocalTime.parse("06:00:00");
        if (timeNow.isBefore(riskyTimeBegins) || timeNow.isAfter(riskyTimeENds)) {
            return true;
        }
        return false;
    }

    public Account findAccount(String name) {
        return accountRepository.findFirstByName(name);
    }

    public List<Loan> findAllLoans() {
        return loanRepository.findAll();
    }


    public List<Loan> findAllAccountLoans(Long personalNumber) {
        Account account = accountRepository.findOne(personalNumber);
        if(account != null) {
            return account.getLoans();
        }
        throw new ResourceNotFoundException("There's no account with provided personal number.");
    }



}
