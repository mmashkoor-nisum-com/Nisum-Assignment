package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.warehouse.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByIsDeleted(int value);
	
	public Product findByIdAndIsDeleted(long id, int value);
	
	public List<Product> findByIsDeletedAndProductAttributes_Product_Id(int value, long id);
	
}
