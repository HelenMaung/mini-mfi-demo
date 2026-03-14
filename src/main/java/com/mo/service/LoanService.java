package com.mo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mo.dao.LoanProductRepo;
import com.mo.dao.LoanRepo;
import com.mo.dao.MemberRepo;
import com.mo.entity.Loan;
import com.mo.entity.LoanProduct;
import com.mo.entity.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanService {

	private final LoanRepo loanRepo;
	private final MemberRepo memberRepo;
	private final LoanProductRepo productRepo;

	public Loan createLoan(Long memberId, Long productId) {

		Member member = memberRepo.findById(memberId).orElseThrow(null);
		LoanProduct product = productRepo.findById(productId).orElseThrow();

		Loan loan = new Loan();
		loan.setMember(member);
		loan.setLoanProduct(product);

		BigDecimal rate = product.getAnnualRate().divide(BigDecimal.valueOf(100));

		BigDecimal time = BigDecimal.valueOf(product.getMonths()).divide(BigDecimal.valueOf(12));

		BigDecimal interest = product.getPrincipal().multiply(rate).multiply(time);

		BigDecimal totalRepayment = product.getPrincipal().add(interest);

		loan.setTotalInterest(interest);
		loan.setTotalRepayment(totalRepayment);

		return loanRepo.save(loan);
	}
}
