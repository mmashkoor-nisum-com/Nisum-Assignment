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
import com.warehouse.models.Warehouse;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.services.impl.WarehouseServiceImpl;
import com.warehouse.test.mockfactory.MockFactory;

@RunWith(SpringJUnit4ClassRunner.class)
public class WarehouseServiceTest {
	
	private int id = 1;

	@Mock
	private WarehouseRepository warehouseRepository;
	
	@InjectMocks
	private WarehouseServiceImpl warehouseServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllWarehouse(){
		int expected = 2;
		List<Warehouse> mockWarehouseList = MockFactory.getMockWarehouseList();
		
		when(warehouseRepository.findByIsDeleted(Constant.IS_ACTIVE)).thenReturn(mockWarehouseList);
		mockWarehouseList = warehouseServiceImpl.getWarehouses();
		assertEquals(expected, mockWarehouseList.size());
	}
	
	@Test
	public void testGetWarehouseById(){
		int expected = 1;
		Warehouse mockWarehouse = MockFactory.getMockWarehouse(id);
		
		when(warehouseRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE)).thenReturn(mockWarehouse);
		mockWarehouse = warehouseServiceImpl.getWarehouseById(id);
		assertEquals(expected,mockWarehouse.getId());
	}
	
	@Test
	public void testSaveWarehouse(){
		Warehouse mockWarehouse = MockFactory.getMockWarehouse(id);
		
		when(warehouseRepository.save(mockWarehouse)).thenReturn(mockWarehouse);
		Warehouse warehouse = warehouseServiceImpl.addWarehouse(mockWarehouse);
		assertEquals(mockWarehouse,warehouse);
	}
	
	@Test
	public void testUpdateWarehouse(){
		Warehouse mockWarehouse = MockFactory.getMockWarehouse(id);
		
		when(warehouseRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE)).thenReturn(mockWarehouse);
		when(warehouseRepository.save(mockWarehouse)).thenReturn(mockWarehouse);
		Warehouse warehouse = warehouseServiceImpl.updateWarehouse(mockWarehouse,id);
		assertEquals(mockWarehouse,warehouse);
	}
	
	@Test
	public void testDeleteWarehouse(){
		Warehouse mockWarehouse = MockFactory.getMockWarehouse(id);
		
		when(warehouseRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE)).thenReturn(mockWarehouse);
		when(warehouseRepository.save(mockWarehouse)).thenReturn(mockWarehouse);
		Warehouse warehouse =  warehouseServiceImpl.deleteWarehouse(id);
		assertEquals(mockWarehouse,warehouse);
	}
	
}
