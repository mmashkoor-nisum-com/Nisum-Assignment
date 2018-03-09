package com.warehouse.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.warehouse.constant.Constant;
import com.warehouse.models.Inventory;
import com.warehouse.repository.InventoryRepository;
import com.warehouse.services.impl.InventoryServiceImpl;
import com.warehouse.test.mockfactory.MockFactory;

@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryServiceTest {

	private int warehouseId = 1;
	private long productId = 1;
	private int productAttributeId = 1;
	private int expectedValue = 2;
	private int quantity = 10;
	
	@Mock
	private InventoryRepository inventoryRepository;

	@InjectMocks
	private InventoryServiceImpl inventoryServiceImpl;

	@Test
	public void testGetAllInventory() {
		List<Inventory> mockInventoryList = MockFactory.getMockInventoryList();

		when(inventoryRepository.findByWarehouse_isDeletedAndProductAttribute_Product_isDeleted(Constant.IS_ACTIVE, Constant.IS_ACTIVE)).thenReturn(mockInventoryList);
		mockInventoryList = inventoryServiceImpl.getInventories();
		assertEquals(expectedValue, mockInventoryList.size());
	}

	@Test
	public void testGetInventoryByWarehouseId() {
		List<Inventory> mockInventoryList = MockFactory.getMockInventoryList();

		when(inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeleted(warehouseId , Constant.IS_ACTIVE)).thenReturn(mockInventoryList);
		mockInventoryList = inventoryServiceImpl.getInventoryByWarehouseId(warehouseId);
		assertEquals(expectedValue, mockInventoryList.size());
	}

	@Test
	public void testGetInventoryByProductId() {
		List<Inventory> mockInventoryList = MockFactory.getMockInventoryList();

		when(inventoryRepository.findByProductAttribute_Product_IdAndProductAttribute_Product_IsDeleted(productId,Constant.IS_ACTIVE)).thenReturn(mockInventoryList);
		mockInventoryList = inventoryServiceImpl.getInventoryByProductId(productId);
		assertEquals(expectedValue, mockInventoryList.size());
	}

	@Test
	public void testGetInventoryByWarehouseIdAndProductId() {
		List<Inventory> mockInventoryList = MockFactory.getMockInventoryList();

		when(inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeletedAndProductAttribute_Product_IdAndProductAttribute_Product_IsDeleted(warehouseId, Constant.IS_ACTIVE, productId, Constant.IS_ACTIVE)).thenReturn(mockInventoryList);
		mockInventoryList = inventoryServiceImpl.getInventoryByWarehouseIdAndProductId(warehouseId,productId);
		assertEquals(expectedValue, mockInventoryList.size());
	}

	@Test
	public void testSetItemQuantityByProductAttributeId() {
		List<Inventory> mockInventoryList = MockFactory.getMockInventoryList();

		when(inventoryRepository.findByProductAttribute_IdAndProductAttribute_Product_IsDeleted(productAttributeId,Constant.IS_ACTIVE)).thenReturn(mockInventoryList);
		String result = inventoryServiceImpl.setItemQuantityByProductAttributeId(productAttributeId, quantity); 
		assertEquals(Constant.ADD_ITEM_QUANTITY,result);
	}

	@Test
	public void testSetItemQuantityByWarehouseIdAndProductAttributeId() {
		Inventory mockInventory = MockFactory.getMockInventory(productId);

		when(inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeletedAndProductAttribute_IdAndProductAttribute_Product_IsDeleted(warehouseId,Constant.IS_ACTIVE,productAttributeId,Constant.IS_ACTIVE)).thenReturn(mockInventory);
		String result = inventoryServiceImpl.setItemQuantityByWarehouseIdAndProductAttributeId(warehouseId , productAttributeId, quantity);
		assertEquals(Constant.ADD_ITEM_QUANTITY,result);
	}

	@Test
	public void testSetItemQuantityByWarehouseId() {
		List<Inventory> mockInventoryList = MockFactory.getMockInventoryList();

		when(inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeleted(warehouseId , Constant.IS_ACTIVE)).thenReturn(mockInventoryList);
		String result = inventoryServiceImpl.setItemQuantityByWarehouseId(warehouseId, quantity); 
		assertEquals(Constant.ADD_ITEM_QUANTITY,result);
	}
	
	@Test
	public void testSetItemQuantityToAllProducts() {
		List<Inventory> mockInventoryList = MockFactory.getMockInventoryList();

		when(inventoryRepository.findByWarehouse_isDeletedAndProductAttribute_Product_isDeleted( Constant.IS_ACTIVE, Constant.IS_ACTIVE)).thenReturn(mockInventoryList);
		String result = inventoryServiceImpl.setItemQuantityToAllProducts(quantity); 
		assertEquals(Constant.ADD_ITEM_QUANTITY,result);
	}

}
