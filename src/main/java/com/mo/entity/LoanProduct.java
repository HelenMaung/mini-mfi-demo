package com.mo.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mo.util.CalculationType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="loan_product")
public class LoanProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Principal amount is required!")
	@DecimalMin(value = "0.0", inclusive = false, message = "Principal must be greater than 0")
	private BigDecimal principal;
	
	@NotNull(message = "Interest amount is required!")
	@DecimalMin(value = "0.0", inclusive = false, message = "Principal must be greater than 0")
	@DecimalMax(value = "28.0", message = "Rate cannot exceed 28%")
	@Column(name="annual_rate")
	private BigDecimal annualRate;
	
	@Min(value = 1, message = "Loan duration must be at least 1 month")
	private int months;
	
	@Enumerated(EnumType.STRING)
	@Column(name="calculation_type")
	private CalculationType calculationType;
	
    @OneToMany(mappedBy = "loanProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Loan> loans = new ArrayList<>();
	
	
}
