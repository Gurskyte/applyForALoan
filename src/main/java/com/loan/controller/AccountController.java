package com.loan.controller;

import com.loan.model.Account;
import com.loan.model.Loan;
import com.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.loan.model.LoanForm;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/")
public class AccountController {
	@Autowired
	private LoanService loanService;

	@RequestMapping(value = "loan", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
	public String accountInformation(@Valid @RequestBody LoanForm loanForm) {
		loanService.issue(loanForm);
		return "Success";
	}

	/*@GetMapping(value="account")
    @ResponseStatus(HttpStatus.OK)
	public Account getAccount(@RequestParam String name) {
		return loanService.findAccount(name);
	}

	@GetMapping(value = "loans")
    public ResponseEntity<List<Loan>> getLoans() {
	    return ResponseEntity.ok(loanService.findAllLoans());
    }*/

    @GetMapping(value = "account/loans")
    public ResponseEntity<List<Loan>> getAccountLoans(@RequestParam Long personalNumber) {
	    return ResponseEntity.ok(loanService.findAllAccountLoans(personalNumber));
    }


}