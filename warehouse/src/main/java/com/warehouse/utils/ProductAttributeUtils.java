package com.warehouse.utils;

import java.util.ArrayList;
import java.util.List;

import com.warehouse.dto.ProductAttributesDTO;
import com.warehouse.models.ProductAttribute;

public class ProductAttributeUtils {

	public static List<ProductAttributesDTO> convertProductAttributesToProductAttributesDTO(List<ProductAttribute> productAttributes){
		List<ProductAttributesDTO> productListDTOs = new ArrayList<ProductAttributesDTO>(0);
		for(ProductAttribute product : productAttributes) {
			ProductAttributesDTO productAttributeDTO = new ProductAttributesDTO();
			productAttributeDTO.setProductName(product.getProduct().getProductName());
			productAttributeDTO.setProductSize(product.getAttributesDetail().getType());
			productListDTOs.add(productAttributeDTO);
		}
		return productListDTOs;
	}
	
}
