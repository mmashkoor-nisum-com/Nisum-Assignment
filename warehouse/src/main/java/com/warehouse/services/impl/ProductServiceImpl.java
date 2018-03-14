package com.warehouse.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.constant.Constant;
import com.warehouse.models.Product;
import com.warehouse.models.ProductAttribute;
import com.warehouse.repository.ProductAttributesRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductAttributesRepository productAttributesRepository;

	public List<Product> getProducts() {
		return productRepository.findByIsDeleted(Constant.IS_ACTIVE);
	}

	public Product getProductById(long id) {
		return productRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
	}

	public String addProduct(Product product) {
		product = productRepository.save(product);
		ProductAttribute productAttribute = new ProductAttribute();
		productAttribute.setProduct(product);
		productAttribute.setAttributesDetail(product.getProductAttributes().get(0).getAttributesDetail());
		productAttributesRepository.save(productAttribute);
		return Constant.PRODUCT_ADDED;
	}

	public String updateProduct(Product product, long id) {
		Product productRecord = productRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
		if (productRecord != null) {
			product.setId(id);
			productRepository.save(product);
			ProductAttribute productAttribute = new ProductAttribute();
			productAttribute.setId(productRecord.getProductAttributes().get(0).getId());
			productAttribute.setProduct(product);
			productAttribute.setAttributesDetail(product.getProductAttributes().get(0).getAttributesDetail());
			productAttributesRepository.save(productAttribute);
			return Constant.PRODUCT_UPDATED;
		}
		return null;
	}

	public String deleteProduct(long id) {
		Product product = productRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
		if(product != null) {
			product.setIsDeleted(Constant.IS_DELETE);
			productRepository.save(product);
			return Constant.PRODUCT_DELETED;
		}
		return null;
	}

	public List<Product> getAllProductSizeByProductId(long id) {
		return productRepository.findByIsDeletedAndProductAttributes_Product_Id(Constant.IS_ACTIVE, id);
	}

}
