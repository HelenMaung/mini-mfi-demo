package com.mo.dto;

import lombok.Data;

@Data
public class MemberRequestDto {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String nrc;
	private String address;
	private Boolean status;
}
