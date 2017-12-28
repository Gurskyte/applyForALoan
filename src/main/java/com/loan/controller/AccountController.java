package com.loan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.LoanForm;

@RestController
@RequestMapping(value="/")
public class AccountController {

	@RequestMapping(value = "loan", method = RequestMethod.POST)
	public ResponseEntity<Void> accountInformation(@RequestBody LoanForm loanForm) {
		return ResponseEntity.status(202).build();
	}
}