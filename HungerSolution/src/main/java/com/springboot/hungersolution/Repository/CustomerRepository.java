package com.springboot.hungersolution.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.hungersolution.Entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{


	Customer findByEmailAndPassword(String email, String password);
	Customer findByEmail(String email);

		 
}
