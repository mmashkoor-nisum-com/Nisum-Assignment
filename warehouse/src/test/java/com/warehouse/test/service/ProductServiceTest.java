package com.warehouse.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.warehouse.constant.Constant;
import com.warehouse.models.Product;
import com.warehouse.models.ProductAttribute;
import com.warehouse.repository.ProductAttributesRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.services.impl.ProductServiceImpl;
import com.warehouse.test.mockfactory.MockFactory;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

	private long productId = 1;
	private int productAttributeId = 1;

	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private ProductAttributesRepository productAttributeRepository;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllProduct(){
		int expected = 2;
		List<Product> mockProductList = MockFactory.getMockProductList();

		when(productRepository.findByIsDeleted(Constant.IS_ACTIVE)).thenReturn(mockProductList);
		mockProductList = productServiceImpl.getProducts();
		assertEquals(expected, mockProductList.size());
	}

	@Test
	public void testGetProductByProductId(){
		long expected = 1;
		Product mockProduct = MockFactory.getMockProduct(productId);

		when(productRepository.findByIdAndIsDeleted(productId, Constant.IS_ACTIVE)).thenReturn(mockProduct);
		mockProduct = productServiceImpl.getProductById(productId);
		assertEquals(expected, mockProduct.getId().longValue());
	}
	
	@Test
	public void testSaveProduct(){
		Product mockProduct = MockFactory.getMockProduct(productId);
		ProductAttribute mockProductAttribute = MockFactory.getMockProductAttribute(productAttributeId);
		
		when(productRepository.save(mockProduct)).thenReturn(mockProduct);
		when(productAttributeRepository.save(mockProductAttribute)).thenReturn(mockProductAttribute);
		String result = productServiceImpl.addProduct(mockProduct);
		assertEquals(Constant.PRODUCT_ADDED,result);
	}
	
	@Test
	public void testUpdateProduct(){
		Product mockProduct = MockFactory.getMockProduct(productId);
		ProductAttribute mockProductAttribute = MockFactory.getMockProductAttribute(productAttributeId);
		
		when(productRepository.findByIdAndIsDeleted(productId, Constant.IS_ACTIVE)).thenReturn(mockProduct);
		when(productRepository.save(mockProduct)).thenReturn(mockProduct);
		when(productAttributeRepository.save(mockProductAttribute)).thenReturn(mockProductAttribute);
		String result = productServiceImpl.updateProduct(mockProduct, productId);
		assertEquals(Constant.PRODUCT_UPDATED,result);
	}

	@Test
	public void testDeleteProduct(){
		Product mockProduct = MockFactory.getMockProduct(productId);

		when(productRepository.findByIdAndIsDeleted(productId, Constant.IS_ACTIVE)).thenReturn(mockProduct);
		when(productRepository.save(mockProduct)).thenReturn(mockProduct);
		String result = productServiceImpl.deleteProduct(productId);
		assertEquals(Constant.PRODUCT_DELETED,result);
	}
	
	@Test
	public void testGetAllProductSizeByProductId() {
		int expected = 2;
		List<Product> mockProductList = MockFactory.getMockProductList();
		
		when(productRepository.findByIsDeletedAndProductAttributes_Product_Id(Constant.IS_ACTIVE, productId)).thenReturn(mockProductList);
		mockProductList =productServiceImpl.getAllProductSizeByProductId(productId);
		assertEquals(expected, mockProductList.size());
	}

}
