package com.etohfa.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etohfa.entity.Category;
import com.etohfa.entity.Product;
import com.etohfa.entity.User;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	List<Product> findByStatusIn(List<String> status);

	List<Product> findBySellerAndStatusIn(User seller, List<String> status);

	List<Product> findBySellerAndCategoryAndAndStatusIn(User seller, Category category, List<String> status);

	List<Product> findByCategoryAndStatusIn(Category category, List<String> status);

	Long countByStatusIn(List<String> status);

	Long countByStatusInAndSeller(List<String> status, User seller);

	List<Product> findByNameContainingIgnoreCaseAndStatusIn(String productName, List<String> status);

	List<Product> findByNameContainingIgnoreCaseAndSellerAndStatusIn(String productName, User seller, List<String> status);
	
}
