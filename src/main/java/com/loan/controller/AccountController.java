package com.loan.controller;

import com.loan.model.Account;
import com.loan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.loan.model.LoanForm;

@RestController
@RequestMapping(value="/")
public class AccountController {


	@Autowired
	private AccountService accountService;


	@RequestMapping(value = "loan", method = RequestMethod.POST)
	public ResponseEntity<Void> accountInformation(@RequestBody LoanForm loanForm) {
		Account account = new Account(loanForm.getName(), loanForm.getLastName(), loanForm.getLoanAmount(), loanForm.getMonths());
		accountService.save(account);
		return ResponseEntity.accepted().build();
	}

	@GetMapping(value="account")
	public ResponseEntity<Account> getAccount(@RequestParam String name) {
		Account account = accountService.findAccount(name);
		return ResponseEntity.ok().body(account);
	}
}