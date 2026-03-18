package com.mo.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mo.entity.Loan;
import com.mo.service.LoanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {
	
	private final LoanService loanService;
	
	@PostMapping
	public Loan createLoan(
	        @RequestParam Long memberId,
	        @RequestParam Long productId,
	        @RequestParam BigDecimal principal) {

	    return loanService.createLoan(memberId, productId, principal);
	}

}
