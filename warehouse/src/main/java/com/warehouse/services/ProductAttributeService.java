package com.warehouse.services;

import java.util.List;
import com.warehouse.models.ProductAttribute;

public interface ProductAttributeService {
	
	/**
	 * The method return the all the sizes of particular product present in any warehouse.
	 * 
	 * @param product id
	 * @return list of Product Attribute
	 */
	public List<ProductAttribute> getAllProductSizeByProductId(long id);
}
