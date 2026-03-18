package com.mo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.entity.LoanProduct;
import com.mo.service.LoanProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class LoanProductController {
	
	private final LoanProductService loanProduct;
	
	@PostMapping
	public LoanProduct createProduct(@RequestBody LoanProduct product) {
		
		return loanProduct.createLoanProduct(product);
	}
	
	@GetMapping
	public List<LoanProduct> retrieveLoanProducts(){
		
		return loanProduct.retrieveLoanProduct();
	}
	
	
}
