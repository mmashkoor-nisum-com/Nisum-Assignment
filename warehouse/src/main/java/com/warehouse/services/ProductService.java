package com.warehouse.services;

import java.util.List;
import com.warehouse.models.Product;

public interface ProductService {

	/**
	 * The method is used to fetch all the products.
	 * 
	 * @return list of product
	 */
	public List<Product> getProducts();
	
	/**
	 * This method is used to return the particular product.
	 *  
	 * @param product id
	 * @return product
	 */
	public Product getProductById(long id);

	/**
	 * This method is used to add the product.
	 *  
	 * @param product
	 * @return message
	 */
	public String addProduct(Product product);

	/**
	 * This method is used to update the product.
	 *  
	 * @param product , product id
	 * @return message
	 */
	public String updateProduct(Product product , long id);
	
	/**
	 * This method is used to delete the product.
	 *  
	 * @param product id
	 * @return message
	 */
	public String deleteProduct(long id);

}
