package com.mo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.dao.LoanProductRepo;
import com.mo.entity.LoanProduct;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanProductService {
	
	private final LoanProductRepo productRepo;
	
			
	public LoanProduct createLoanProduct(LoanProduct product) {
		
		return productRepo.save(product);
	}
	
	public List<LoanProduct> retrieveLoanProduct() {
		
		return productRepo.findAll();
	}
}
