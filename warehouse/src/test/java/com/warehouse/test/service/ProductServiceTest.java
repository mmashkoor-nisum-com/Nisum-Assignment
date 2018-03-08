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
import com.warehouse.repository.ProductRepository;
import com.warehouse.services.impl.ProductServiceImpl;
import com.warehouse.test.mockfactory.MockFactory;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

	static long productId = 1;
	
	@Mock
	private ProductRepository productRepository;
	
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
		long actual = mockProduct.getId();
        assertEquals(expected, actual);
	}
	
	@Test
	public void testDeleteProduct(){
		Product mockProduct = MockFactory.getMockProduct(productId);
		
		when(productRepository.findByIdAndIsDeleted(productId, Constant.IS_ACTIVE)).thenReturn(mockProduct);
		when(productRepository.save(mockProduct)).thenReturn(mockProduct);
		String result = productServiceImpl.deleteProduct(productId);
		assertEquals(Constant.PRODUCT_DELETED,result);
	}
	
}
