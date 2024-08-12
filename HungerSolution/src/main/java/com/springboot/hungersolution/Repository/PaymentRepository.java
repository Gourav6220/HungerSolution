package com.springboot.hungersolution.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.hungersolution.Entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	@Query(value = "SELECT * FROM payment JOIN customer ON  payment.cust_id= customer.id ", nativeQuery = true)
	List<Payment> findpaymentdetail();
	
}
