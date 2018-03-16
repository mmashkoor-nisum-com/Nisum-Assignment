package com.warehouse.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import com.warehouse.dto.ProductDTO;
import com.warehouse.models.Product;

public class ProductUtils {

	private ProductUtils() {
	}

	public static ProductDTO convertProductToProductDTO(Product product) {
		ModelMapper modelMapper = new ModelMapper();
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		productDTO.setSize(product.getProductAttributes().get(0).getAttributesDetail().getType());
		return productDTO;
	}

	public static List<ProductDTO> convertProductListToProductListDTOs(List<Product> products) {
		return products.stream().map(product -> convertProductToProductDTO(product)).collect(Collectors.toList());
	}

}
