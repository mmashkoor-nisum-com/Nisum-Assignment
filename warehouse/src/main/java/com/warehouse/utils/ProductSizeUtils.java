package com.warehouse.utils;

import java.util.ArrayList;
import java.util.List;
import com.warehouse.dto.ProductSizeDTO;
import com.warehouse.models.Product;

public class ProductSizeUtils {

	private ProductSizeUtils(){
	}
	
	public static List<ProductSizeDTO> convertProductToProductSizeDTO(List<Product> products){
		int index = 0;
		List<ProductSizeDTO> productListDTOs = new ArrayList<>(0);
		for(Product product : products) {
			ProductSizeDTO productSizeDTO = new ProductSizeDTO();
			productSizeDTO.setProductName(product.getProductName());
			productSizeDTO.setProductSize(product.getProductAttributes().get(index).getAttributesDetail().getType());
			productListDTOs.add(productSizeDTO);
			index ++;
		}
		return productListDTOs;
	}
	
}
