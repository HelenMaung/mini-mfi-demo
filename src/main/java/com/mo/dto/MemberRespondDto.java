package com.mo.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRespondDto {
	
	private Long id;
	private String fullName;
	private String phone;
	private String nrc;
	private String address;
	private LocalDateTime joinDate;
	private Boolean status;

}
