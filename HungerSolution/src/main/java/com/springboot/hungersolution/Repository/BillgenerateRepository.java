package com.springboot.hungersolution.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.hungersolution.Entities.Bill_generate;

@Repository
public interface BillgenerateRepository extends JpaRepository<Bill_generate, Integer>{

}
