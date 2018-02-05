package com.loan.repository;

import com.loan.model.Account;
import com.loan.model.Loan;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.loan.TestConstants.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void givenAccWith1DayOldLoan_whenCountingIssuedLoansByIp_thenOneLoanShouldBeCount(){
       //given
        Account account = new   Account(PERSONAL_NUMBER, NAME, LAST_NAME);
        Loan loan = new Loan(LOAN_AMOUNT, SIX_MONTHS, CLIENT_IP);
        account.addLoan(loan);
        accountRepository.saveAndFlush(account);

        //when
        int actualLoanPerDayFromOneIpCount = loanRepository.countLoansByIpAfterDate(CLIENT_IP, LOCAL_DATE_TIME_MINUS_DAY);

        //then
        Assert.assertEquals(1, actualLoanPerDayFromOneIpCount);
    }

    @Test
    public void givenAccWith2DaysOldLoan_whenCountingIssuedLoansByIp_thenZeroLoansShouldBeCount(){
        //given
        Account account = new   Account(PERSONAL_NUMBER, NAME, LAST_NAME);
        Loan loan = new Loan(LOAN_AMOUNT, SIX_MONTHS, CLIENT_IP);
        loan.setIssueDate(LOCAL_DATE_TIME_MINUS_2DAYS);
        account.addLoan(loan);
        accountRepository.saveAndFlush(account);

        //when
        int actualLoanPerDayFromOneIpCount = loanRepository.countLoansByIpAfterDate(CLIENT_IP, LOCAL_DATE_TIME_MINUS_DAY);

        //then
        Assert.assertEquals(0, actualLoanPerDayFromOneIpCount);
    }

    @Test
    public void givenAccWith1DayOldLoan_whenCountingIssuedLoansByWrongIp_thenZeroLoansShouldBeCount(){
        //given
        Account account = new   Account(PERSONAL_NUMBER, NAME, LAST_NAME);
        Loan loan = new Loan(LOAN_AMOUNT, SIX_MONTHS, CLIENT_IP);
        account.addLoan(loan);
        accountRepository.saveAndFlush(account);

        //when
        int actualLoanPerDayFromOneIpCount = loanRepository.countLoansByIpAfterDate(CLIENT_IP_2, LOCAL_DATE_TIME_MINUS_DAY);

        //then
        Assert.assertEquals(0, actualLoanPerDayFromOneIpCount);
    }
}
