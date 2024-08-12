package com.springboot.hungersolution.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.hungersolution.Entities.Category;
import com.springboot.hungersolution.Entities.Products;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Query(value="select * from category where status='1' ",nativeQuery = true)
    List<Category>	findallactivecategory();
	
}
