package com.loan.controller;

import com.loan.model.Account;
import com.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.loan.model.LoanForm;

@RestController
@RequestMapping(value="/")
public class AccountController {
	@Autowired
	private LoanService loanService;

	@RequestMapping(value = "loan", method = RequestMethod.POST)
	public ResponseEntity<Void> accountInformation(@RequestBody LoanForm loanForm) {
		loanService.issue(loanForm);
		return ResponseEntity.accepted().build();
	}

	@GetMapping(value="account")
	public ResponseEntity<Account> getAccount(@RequestParam String name) {
		Account account = loanService.findAccount(name);
		return ResponseEntity.ok().body(account);
	}
}