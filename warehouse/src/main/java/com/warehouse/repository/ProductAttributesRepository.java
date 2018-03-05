package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.warehouse.models.ProductAttribute;

@Repository
public interface ProductAttributesRepository extends JpaRepository<ProductAttribute, Integer>  {

	public List<ProductAttribute> findByProduct_Id(long id);
	
}
