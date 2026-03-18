package com.mo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mo.entity.LoanProduct;

public interface LoanProductRepo extends JpaRepository<LoanProduct, Long> {

}
