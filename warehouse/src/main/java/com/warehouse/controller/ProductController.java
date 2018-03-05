
package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.dto.ProductDTO;
import com.warehouse.models.Product;
import com.warehouse.services.ProductService;
import com.warehouse.utils.ProductUtils;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * The method is used to fetch all the products.
	 * 
	 * @return list of ProductDTO
	 */
	@GetMapping("/")
	public List<ProductDTO> getAllProducts(){
		List<Product> productList = productService.getProducts();
		return ProductUtils.convertProductListToProductListDTOs(productList);
	}
	
	/**
	 * This method is used to return the particular product.
	 *  
	 * @param product id
	 * @return ProductDTO
	 */
	@GetMapping("/{productId}")
	public ProductDTO getProductById(@PathVariable long productId){
		Product product = productService.getProductById(productId);
		return ProductUtils.convertProductToProductDTO(product);
	}
	
	/**
	 * This method is used to add the product.
	 *  
	 * @return message
	 */
	@PostMapping("/")
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	/**
	 * This method is used to update the product.
	 *  
	 * @param product id
	 * @return message
	 */
	@PutMapping("/{id}")
	public String updateProduct(@RequestBody Product product , @PathVariable long id) {
		return productService.updateProduct(product, id);
	}

	/**
	 * This method is used to delete the product.
	 *  
	 * @param product id
	 * @return message
	 */
	@DeleteMapping("/{productId}")
	public String deleteWarehouse(@PathVariable long productId) {
		return productService.deleteProduct(productId);
	}
}
