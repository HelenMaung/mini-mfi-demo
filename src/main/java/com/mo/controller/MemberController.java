package com.mo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.entity.Member;
import com.mo.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
	
	private final MemberService memberService;
	
	@PostMapping
	public Member createMember(@Valid @RequestBody Member member) {
		
		return memberService.createMember(member);
	}
	
	@GetMapping("/{id}")
	public Member retrieveMember(@PathVariable Long id) {
		return memberService.findById(id);
	}
	
	@GetMapping("/list")
	public List<Member> retrieveMembers() {
		return memberService.findAll();
	}
	
	@PutMapping("/{id}")
	public Member updateData(@RequestBody Member member, @PathVariable Long id) {
		return memberService.updateMemberData(member,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMember(@PathVariable Long id) {
		
		memberService.deleteMember(id);
		
	}
	
	

}
