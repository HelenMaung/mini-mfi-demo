package com.mo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.dao.MemberRepo;
import com.mo.entity.Member;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepo memberRepo;

	public Member findById(Long id) {

		return memberRepo.findById(id)
				.orElseThrow(EntityNotFoundException::new);
	}

	public Member createMember(Member member) {

		validateUniqueness(member, null);

		member.setJoinDate(LocalDateTime.now());
		return memberRepo.save(member);
	}

	public List<Member> findAll() {

		return memberRepo.findAll();
	}

	public Member updateMemberData(Member updateMember, Long id) {

		Member existingMember = findById(id);
//		  
//		 if(!existingMember.getPhone().equals(updateMember.getPhone()) 
//				 && memberRepo.existsByPhone(updateMember.getPhone())){
//		        throw new IllegalArgumentException("Phone already exists: " + updateMember.getPhone());
//		 }
//		 
//		 if (!existingMember.getNrc().equals(updateMember.getNrc())
//		            && memberRepo.existsByNrc(updateMember.getNrc())) {
//		        throw new IllegalArgumentException("NRC already exists: " + updateMember.getNrc());
//		    }

		validateUniqueness(updateMember, existingMember);

		existingMember.setFirstName(updateMember.getFirstName());
		existingMember.setLastName(updateMember.getLastName());
		existingMember.setPhone(updateMember.getPhone());
		existingMember.setNrc(updateMember.getNrc());
		existingMember.setAddress(updateMember.getAddress());
		existingMember.setStatus(updateMember.getStatus());

		return memberRepo.save(existingMember);
	}

	public void deleteMember(Long id) {

		Member existingMember = findById(id);
		memberRepo.delete(existingMember);
	}

	private void validateUniqueness(Member newMember, Member existingMember) {

		if (existingMember == null || !existingMember.getPhone().equals(newMember.getPhone())) {
			if (memberRepo.existsByPhone(newMember.getPhone())) {
				throw new IllegalArgumentException("Phone already exists" + newMember.getPhone());

			}
		}

		if (existingMember == null || !existingMember.getNrc().equals(newMember.getNrc())) {
			if (memberRepo.existsByNrc(newMember.getNrc())) {
				throw new IllegalArgumentException("NRC already exists: " + newMember.getNrc());
			}
		}

	}
}
