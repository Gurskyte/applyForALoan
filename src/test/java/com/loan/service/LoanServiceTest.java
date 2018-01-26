package com.loan.service;

import com.loan.model.Account;
import com.loan.model.LoanForm;
import com.loan.model.WebUtils;
import com.loan.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

    @Before
    public void setUp() {
        loanService = new LoanService(accountRepository, accountService, webUtils);
    }

    @Test
    public void givenKazkas_whenKazkas_thenKazkas() throws Exception {
        //given
        LoanForm loanForm = new LoanForm();
        when(accountService.findOrCreate(any(LoanForm.class))).thenReturn(new Account());

        //when
        loanService.issue(loanForm);

        //then
        verify(loanService, times(2));
    }
}