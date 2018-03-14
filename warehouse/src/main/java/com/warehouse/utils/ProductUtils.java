package com.warehouse.utils;

import java.util.ArrayList;
import java.util.List;
import com.warehouse.dto.ProductDTO;
import com.warehouse.models.Product;

public class ProductUtils {
	
	private ProductUtils() {
	}

	public static List<ProductDTO> convertProductListToProductListDTOs(List<Product> products) {
		List<ProductDTO> productListDTOs = new ArrayList<>(0);
		for(Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setProductName(product.getProductName());
			productDTO.setBrandName(product.getBrand().getBrandName());
			productDTO.setProductType(product.getProductType().getType());
			productDTO.setSize(product.getProductAttributes().get(0).getAttributesDetail().getType());
			productListDTOs.add(productDTO);
		}
		return productListDTOs;
	}
	
	public static ProductDTO convertProductToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setProductName(product.getProductName());
		productDTO.setBrandName(product.getBrand().getBrandName());
		productDTO.setProductType(product.getProductType().getType());
		productDTO.setSize(product.getProductAttributes().get(0).getAttributesDetail().getType());
		return productDTO;
	}
	
}
