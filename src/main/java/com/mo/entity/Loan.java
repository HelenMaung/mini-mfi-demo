package com.mo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_product_id", nullable = false)
	private LoanProduct loanProduct;

	@ManyToOne()
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	private BigDecimal totalInterest;
	
	private BigDecimal totalRepayment;
	
	private BigDecimal Principal;
}
