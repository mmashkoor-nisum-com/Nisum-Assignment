package com.warehouse.test.mockfactory;

import java.util.ArrayList;
import java.util.List;

import com.warehouse.dto.InventoryDTO;
import com.warehouse.dto.ProductAttributesDTO;
import com.warehouse.dto.ProductDTO;
import com.warehouse.dto.WarehouseDTO;
import com.warehouse.models.AttributesDetail;
import com.warehouse.models.Inventory;
import com.warehouse.models.Product;
import com.warehouse.models.ProductAttribute;
import com.warehouse.models.Warehouse;

public class MockFactory {

	static Warehouse mockWarehouse;
	static Product mockProduct;
	static Inventory mockInventory;
	static ProductAttribute mockProductAttribute;
	static WarehouseDTO mockWarehouseDTO;
	static ProductDTO mockProductDTO;
	static ProductAttributesDTO mockProductAttributeDTO;
	static InventoryDTO mockInventoryDTO;
	static AttributesDetail mockAttributeDetail;

	public static Warehouse getMockWarehouse(int id) {

		mockWarehouse = new Warehouse();
		mockWarehouse.setId(id);
		mockWarehouse.setCountry(null);
		mockWarehouse.setWarehouseName("Warehouse");
		mockWarehouse.setWarehouseAddress("Chicago");
		mockWarehouse.setIsDeleted(0);

		return mockWarehouse;
	}

	public static Product getMockProduct(long id) {

		mockProduct = new Product();
		mockProduct.setId(id);
		mockProduct.setProductName("Nike");
		mockProduct.setIsDeleted(0);
		mockProduct.setProductType(null);
		mockProduct.setProductAttributes(null);
		mockProduct.setBrand(null);

		return mockProduct;
	}

	public static Inventory getMockInventory(long id) {

		mockInventory = new Inventory();
		mockInventory.setId(id);
		mockInventory.setWarehouse(getMockWarehouse(1));
		mockInventory.setProductAttribute(getMockProductAttribute(1));
		mockInventory.setAvaliableQuantity(10);
		mockInventory.setInStock(10);
		mockInventory.setInTransit(20);
		mockInventory.setMinimumOrderQuantity(10);
		mockInventory.setQuantityPerBox(10);
		mockInventory.setReorderPoint(10);
		
		return mockInventory;
	}

	public static ProductAttribute getMockProductAttribute(int id) {

		mockProductAttribute = new ProductAttribute();
		mockProductAttribute.setId(id);
		mockProductAttribute.setProduct(getMockProduct(1L));
		mockProductAttribute.setAttributesDetail(getAttributeDetail());
		
		return mockProductAttribute;
	}

	public static AttributesDetail getAttributeDetail() {

		mockAttributeDetail = new AttributesDetail();
		mockAttributeDetail.setId(1);
		mockAttributeDetail.setType("Medium");

		return mockAttributeDetail;

	}

	public static List<Inventory> getMockInventoryList(){

		List<Inventory> mockInventoryList = new ArrayList<Inventory>(0);
		mockInventoryList.add(getMockInventory(4L));
		mockInventoryList.add(getMockInventory(9L));		

		return mockInventoryList;

	}

	public static List<Warehouse> getMockWarehouseList(){

		List<Warehouse> mockWarehouseList = new ArrayList<Warehouse>(0);
		mockWarehouseList.add(MockFactory.getMockWarehouse(1));
		mockWarehouseList.add(MockFactory.getMockWarehouse(2));

		return mockWarehouseList;

	}

	public static List<Product> getMockProductList(){

		List<Product> mockProductList = new ArrayList<Product>(0);
		mockProductList.add(MockFactory.getMockProduct(1L));
		mockProductList.add(MockFactory.getMockProduct(2L));

		return mockProductList;

	}
	
	public static List<ProductAttribute> getMockProductAttributeList(){

		List<ProductAttribute> mockProductAttributeList = new ArrayList<ProductAttribute>(0);
		mockProductAttributeList.add(MockFactory.getMockProductAttribute(2));
		mockProductAttributeList.add(MockFactory.getMockProductAttribute(3));

		return mockProductAttributeList;

	}
	
}