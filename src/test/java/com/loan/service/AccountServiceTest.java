package com.loan.service;

import com.loan.model.Account;
import com.loan.model.Loan;
import com.loan.model.LoanForm;
import com.loan.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static com.loan.TestConstants.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    AccountService accountService;

    @Mock
    private AccountRepository accountRepository;


    @Before
    public void setUp() {
        accountService = new AccountService(accountRepository);
    }

/*    @Test
    public void givenLoanForm_whenTryingToFindIfAccAlreadyExistByPersonalNumber_thenAccShouldNOtBeFound(){
        //given
       LoanForm loanForm = new LoanForm();
       loanForm.setPersonalNumber(PERSONAL_NUMBER);
       when(accountRepository.findOne(PERSONAL_NUMBER)).thenReturn(null);

        //when
       Account account = accountRepository.findOne(PERSONAL_NUMBER);

       //then
        Assert.assertEquals(account, null);
    }*/

    @Test
    public void givenLoanForm_whenTryingToCreateNewAcc_thenAccShouldBeSaved() {
        //given
        Account expectedAccount = new Account(PERSONAL_NUMBER, NAME, LAST_NAME);
        Loan loan = new Loan(LOAN_AMOUNT, SIX_MONTHS, CLIENT_IP);
        expectedAccount.addLoan(loan);
        LoanForm loanForm = new LoanForm();
        loanForm.setPersonalNumber(PERSONAL_NUMBER);
        loanForm.setName(NAME);
        loanForm.setLastName(LAST_NAME);
        loanForm.setLoanAmount(LOAN_AMOUNT);
        loanForm.setMonths(SIX_MONTHS);
        when(accountRepository.save(any(Account.class))).thenReturn(expectedAccount);

        //when
        Account account = accountService.findOrCreate(loanForm);

        //then
        Assert.assertEquals(expectedAccount, account);
    }
}