package com.mo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name="members")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "Phone is requird!")
	@Pattern(regexp = "^[0-9]{11}$", message = "Invalid Phone number format")
	@Column(unique = true)
	private String phone;
	
	@NotBlank(message = "NRC is required")
	@Pattern(regexp = "^[0-9]{1,2}/[A-Za-z]+\\([A-Za-z]+\\)[0-9]{6}$", message = "Invalid NRC format")
	@Column(unique = true)
	private String nrc;
	
	@NotBlank(message="Address is required!")
	private String address;
	
	@Column(name="join_date")
	private LocalDateTime joinDate;
	
	private Boolean status;
	
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Loan> loans = new ArrayList<>();

}
