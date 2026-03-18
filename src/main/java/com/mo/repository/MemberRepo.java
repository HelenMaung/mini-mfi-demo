package com.mo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mo.entity.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
	
	boolean existsByPhone(String phone);
	boolean existsByNrc(String nrc);

}
