package com.mo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.dto.MemberRequestDto;
import com.mo.dto.MemberRespondDto;
import com.mo.entity.Member;
import com.mo.mappers.MemberMapper;
import com.mo.repository.MemberRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepo memberRepo;

	public MemberRespondDto findById(Long id) {

//		return memberRepo.findById(id)
//				.orElseThrow(EntityNotFoundException::new);
		
		Member member = memberRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		return MemberMapper.toDTO(member);
	}

	public MemberRespondDto createMember(MemberRequestDto memberDto) {
		Member member = MemberMapper.toEntity(memberDto);
//		validateUniqueness(memberDto, null);

	    member.setJoinDate(LocalDateTime.now());

	    Member saved = memberRepo.save(member);

	    return MemberMapper.toDTO(saved);

	
	}

	public List<MemberRespondDto> findAll() {

		return memberRepo.findAll()
				.stream().map(MemberMapper::toDTO).toList();
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

//	private void validateUniquenes(MemberRequestDto newMember, MemberRespondDto existingMember) {
//
//		if (existingMember == null || !existingMember.getPhone().equals(newMember.getPhone())) {
//			if (memberRepo.existsByPhone(newMember.getPhone())) {
//				throw new IllegalArgumentException("Phone already exists" + newMember.getPhone());
//
//			}
//		}
//
//		if (existingMember == null || !existingMember.getNrc().equals(newMember.getNrc())) {
//			if (memberRepo.existsByNrc(newMember.getNrc())) {
//				throw new IllegalArgumentException("NRC already exists: " + newMember.getNrc());
//			}
//		}
//
//	}
}
