package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.dto.ProductAttributesDTO;
import com.warehouse.models.ProductAttribute;
import com.warehouse.services.ProductAttributeService;
import com.warehouse.utils.ProductAttributeUtils;

@RestController
@RequestMapping("/attributes")
public class ProductAttributeController {

	@Autowired
	private ProductAttributeService productAttributeService;
	
	/**
	 * The method return the all the sizes of particular product present in any warehouse.
	 * 
	 * @param product id
	 * @return list of Product Attribute
	 */
	@GetMapping("/size/{productId}")
	public List<ProductAttributesDTO> getAllProductSizeByProductId(@PathVariable long productId){
		List<ProductAttribute> productAttributeList =  productAttributeService.getAllProductSizeByProductId(productId);
		return ProductAttributeUtils.convertProductAttributesToProductAttributesDTO(productAttributeList);
	}
}
