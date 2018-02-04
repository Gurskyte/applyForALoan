package com.loan.service;

import com.loan.model.Account;
import com.loan.model.Loan;
import com.loan.model.ResourceNotFoundException;
import com.loan.model.WebUtils;
import com.loan.repository.AccountRepository;
import com.loan.repository.LoanRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.loan.TestConstants.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {
    LoanService loanService;

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountService accountService;
    @Mock
    private WebUtils webUtils;
    @Mock
    private LoanRepository loanRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() {
        loanService = new LoanService(accountRepository, accountService, webUtils, loanRepository);
    }

    @Test
    public void givenAccWithLoan_whenTryingToFindAccLoansByPersonalNumber_thenLoanShouldBeFound() {
        //given
        Account expectedAccount = new Account(PERSONAL_NUMBER, NAME, LAST_NAME);
        Loan expectedLoan = new Loan(LOAN_AMOUNT, SIX_MONTHS, CLIENT_IP);
        expectedAccount.addLoan(expectedLoan);
        when(accountRepository.findOne(PERSONAL_NUMBER)).thenReturn(expectedAccount);

        //when
        List<Loan> actualLoans = loanService.findAllAccountLoans(PERSONAL_NUMBER);

        //then
        Assert.assertEquals(expectedLoan, actualLoans.get(0));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void givenNullAcc_whenTryingToFindAccLoansByPersonalNumber_thenExceptionIsThrown() {
        //given
        when(accountRepository.findOne(PERSONAL_NUMBER)).thenReturn(null);

        //when
        List<Loan> actualLoans = loanService.findAllAccountLoans(PERSONAL_NUMBER);

        //then
    }

    @Test
    public void givenNullAcc_whenTryingToFindAccLoansByPersonalNumber_thenExceptionIsThrown2() {
        //given
        when(accountRepository.findOne(PERSONAL_NUMBER)).thenReturn(null);

        //then
        thrown.expect(ResourceNotFoundException.class);
        thrown.expectMessage("There's no account with provided personal number.");

        //when
        List<Loan> actualLoans = loanService.findAllAccountLoans(PERSONAL_NUMBER);

    }
}