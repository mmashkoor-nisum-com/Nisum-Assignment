package com.warehouse.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warehouse.models.ProductAttribute;
import com.warehouse.repository.ProductAttributesRepository;
import com.warehouse.services.ProductAttributeService;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Autowired
	private ProductAttributesRepository productAttributesRepository;

	public List<ProductAttribute> getAllProductSizeByProductId(long id) {
		return productAttributesRepository.findByProduct_Id(id);
	}

}
