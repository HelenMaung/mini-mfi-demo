package com.mo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mo.entity.Loan;
import com.mo.entity.LoanProduct;
import com.mo.entity.Member;
import com.mo.repository.LoanProductRepo;
import com.mo.repository.LoanRepo;
import com.mo.repository.MemberRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanService {
	
	private final LoanRepo loanRepo;
	private final MemberRepo memberRepo;
	private final LoanProductRepo productRepo;

	public Loan createLoan(Long memberId, Long productId, BigDecimal principal) {

		Member member = memberRepo.findById(memberId).orElseThrow(null);
		LoanProduct product = productRepo.findById(productId).orElseThrow();

		Loan loan = new Loan();
		loan.setMember(member);
		loan.setLoanProduct(product);
		loan.setPrincipal(principal);

		BigDecimal rate = product.getAnnualRate().divide(BigDecimal.valueOf(100));

		BigDecimal time = BigDecimal.valueOf(product.getMonths()).divide(BigDecimal.valueOf(12));

		BigDecimal interest = principal.multiply(rate).multiply(time);

		BigDecimal totalRepayment = principal.add(interest);

		loan.setTotalInterest(interest);
		loan.setTotalRepayment(totalRepayment);

		return loanRepo.save(loan);
	}

}
