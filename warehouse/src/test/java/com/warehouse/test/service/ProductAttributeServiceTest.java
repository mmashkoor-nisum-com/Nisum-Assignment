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

import com.warehouse.models.ProductAttribute;
import com.warehouse.repository.ProductAttributesRepository;
import com.warehouse.services.impl.ProductAttributeServiceImpl;
import com.warehouse.test.mockfactory.MockFactory;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductAttributeServiceTest {

	static long productId = 1;
	static int expectedValue = 2;
	
	@Mock
	private ProductAttributesRepository productAttributesRepository;
	
	@InjectMocks
	private ProductAttributeServiceImpl ProductAttributesServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllProductSizeByProductId() {
		List<ProductAttribute> mockProductAttributeList = MockFactory.getMockProductAttributeList();
		
		when(productAttributesRepository.findByProduct_Id(productId)).thenReturn(mockProductAttributeList);
		mockProductAttributeList = ProductAttributesServiceImpl.getAllProductSizeByProductId(productId);
		assertEquals(expectedValue, mockProductAttributeList.size());
	}

}
