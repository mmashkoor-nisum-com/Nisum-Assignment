
package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.dto.ProductSizeDTO;
import com.warehouse.constant.Constant;
import com.warehouse.dto.ProductDTO;
import com.warehouse.models.Product;
import com.warehouse.services.ProductService;
import com.warehouse.utils.CustomMessage;
import com.warehouse.utils.ProductSizeUtils;
import com.warehouse.utils.ProductUtils;

@RestController
@RequestMapping("/product")
public class ProductController {

	private String entityName = "Product";
	
	@Autowired
	private ProductService productService;

	/**
	 * The method is used to fetch all the products.
	 * 
	 * @return list of ProductDTO
	 */
	@GetMapping("/")
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<Product> productList = productService.getProducts();
		if (productList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		List<ProductDTO> productListDTO = ProductUtils.convertProductListToProductListDTOs(productList);
		return new ResponseEntity<>(productListDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to return the particular product.
	 *  
	 * @param product id
	 * @return ProductDTO
	 */
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable long productId){
		Product product = productService.getProductById(productId);
		if(product == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		ProductDTO productDTO = ProductUtils.convertProductToProductDTO(product);
		return new ResponseEntity<>(productDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to add the product.
	 *  
	 * @return message
	 */
	@PostMapping("/")
	public ResponseEntity<CustomMessage> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<>(new CustomMessage(String.format(Constant.CREATE_SUCCESS_MESSAGE, entityName)), HttpStatus.CREATED);
	}

	/**
	 * This method is used to update the product.
	 *  
	 * @param product id
	 * @return message
	 */
	@PutMapping("/{productId}")
	public ResponseEntity<CustomMessage> updateProduct(@RequestBody Product product , @PathVariable long productId) {
		Product productRecord = productService.updateProduct(product, productId);
		if (productRecord == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(String.format(Constant.UPDATE_SUCCESS_MESSAGE, entityName)), HttpStatus.OK);
	}

	/**
	 * This method is used to delete the product.
	 *  
	 * @param product id
	 * @return message
	 */
	@DeleteMapping("/{productId}")
	public ResponseEntity<CustomMessage> deleteWarehouse(@PathVariable long productId) {
		Product productRecord =  productService.deleteProduct(productId);
		if (productRecord == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(String.format(Constant.DELETE_SUCCESS_MESSAGE, entityName)), HttpStatus.OK);
	}

	/**
	 * The method return the all the sizes of particular product present in any warehouse.
	 * 
	 * @param product id
	 * @return list of Product
	 */
	@GetMapping("/size/{productId}")
	public ResponseEntity<?> getAllProductSizeByProductId(@PathVariable long productId){
		List<Product> productList =  productService.getAllProductSizeByProductId(productId);
		if (productList.isEmpty()) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		List<ProductSizeDTO> productSizeListDTO = ProductSizeUtils.convertProductToProductSizeDTO(productList);
		return new ResponseEntity<>(productSizeListDTO, HttpStatus.OK);
	}
}
