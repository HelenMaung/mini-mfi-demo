package com.mo.entity;

import java.math.BigDecimal;

import com.mo.emuns.CalculationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Column(name="product_name", nullable= false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_product_id", nullable = false)
	private LoanProduct loanProduct;

	@ManyToOne()
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "calculation_type")
	private CalculationType calculationType;
	
	@Column(nullable = false , name = "principal")
	private BigDecimal principal;

	@Column(name="interest_rate")
	private BigDecimal interestRate;
	
	private Integer months;
	
	@Column(name="total_repayment")
	private BigDecimal totalRepayment;
	
	@Column(name="total_interest")
	private BigDecimal totalInterest;
	
	@Column(name="emi_amount")
	private BigDecimal emiAmount;
	
}
