package com.loan.controller;

import com.loan.model.Account;
import com.loan.model.Loan;
import com.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.loan.model.LoanForm;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class AccountController {
	@Autowired
	private LoanService loanService;

	@RequestMapping(value = "loan", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
	public String accountInformation(@RequestBody LoanForm loanForm) {
		loanService.issue(loanForm);
		return "Success";
	}

	@GetMapping(value="account")
    @ResponseStatus(HttpStatus.OK)
	public Account getAccount(@RequestParam String name) {
		return loanService.findAccount(name);
	}

	@GetMapping(value = "loans")
    public ResponseEntity<List<Loan>> getLoans() {
	    return ResponseEntity.ok(loanService.findAllLoans());
    }

}