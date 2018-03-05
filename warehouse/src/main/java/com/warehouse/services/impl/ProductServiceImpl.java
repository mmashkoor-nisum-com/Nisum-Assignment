package com.warehouse.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.constant.Constant;
import com.warehouse.models.Product;
import com.warehouse.repository.ProductRepository;
import com.warehouse.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findByIsDeleted(Constant.IS_ACTIVE);
	}

	public Product getProductById(long id) {
		return productRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
	}

	public String addProduct(Product product) {
		productRepository.save(product);
		return Constant.PRODUCT_ADDED;
	}

	public String updateProduct(Product product, long id) {
		return null;
	}

	public String deleteProduct(long id) {
		Product product = productRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
		if(product != null) {
			product.setIsDeleted(Constant.IS_DELETE);
			productRepository.save(product);
			return Constant.PRODUCT_DELETED;
		}
		return Constant.NO_RECORD;
	}
}
