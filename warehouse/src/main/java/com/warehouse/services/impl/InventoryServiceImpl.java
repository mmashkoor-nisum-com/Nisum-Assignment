package com.warehouse.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warehouse.constant.Constant;
import com.warehouse.models.Inventory;
import com.warehouse.repository.InventoryRepository;
import com.warehouse.services.InventoryService;
import com.warehouse.utils.InventoryUtils;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository inventoryRepository;

	public List<Inventory> getInventories() {
		return inventoryRepository.findByWarehouse_isDeletedAndProductAttribute_Product_isDeleted(Constant.IS_ACTIVE, Constant.IS_ACTIVE);
	}

	public List<Inventory> getInventoryByWarehouseId(int id) {
		return inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeleted(id , Constant.IS_ACTIVE);
	}

	public List<Inventory> getInventoryByProductId(long id) {
		return inventoryRepository.findByProductAttribute_Product_IdAndProductAttribute_Product_IsDeleted(id,Constant.IS_ACTIVE);
	}

	public List<Inventory> getInventoryByWarehouseIdAndProductId(int warehouseId , long productId) {
		return inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeletedAndProductAttribute_Product_IdAndProductAttribute_Product_IsDeleted(warehouseId, Constant.IS_ACTIVE, productId, Constant.IS_ACTIVE);
	}

	public String setItemQuantityByProductAttributeId(int id , int quantity){
		List<Inventory> inventories = inventoryRepository.findByProductAttribute_IdAndProductAttribute_Product_IsDeleted(id,Constant.IS_ACTIVE);
		if (inventories != null) {
			inventories = InventoryUtils.setQuantityItem(inventories, quantity);
			inventoryRepository.save(inventories);
			return Constant.ADD_ITEM_QUANTITY;
		}
		return Constant.NO_RECORD;
	}

	public String setItemQuantityByWarehouseIdAndProductAttributeId(int id , int pid, int quantity){
		Inventory inventory = inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeletedAndProductAttribute_IdAndProductAttribute_Product_IsDeleted(id,Constant.IS_ACTIVE,pid,Constant.IS_ACTIVE);
		if (inventory != null) {
			inventory = InventoryUtils.setQuantityItem(inventory, quantity);
			inventoryRepository.save(inventory);
			return Constant.ADD_ITEM_QUANTITY;
		}
		return Constant.NO_RECORD;
	}

	public String setItemQuantityByWarehouseId(int warehouseId, int quantity) {
		List<Inventory> inventories = inventoryRepository.findByWarehouse_IdAndWarehouse_IsDeleted(warehouseId , Constant.IS_ACTIVE);
		if (inventories != null) {
			inventories = InventoryUtils.setQuantityItem(inventories, quantity);
			inventoryRepository.save(inventories);
			return Constant.ADD_ITEM_QUANTITY;
		}
		return Constant.NO_RECORD;
	}

	public String setItemQuantityToAllProducts(int quantity) {
		List<Inventory> inventories = inventoryRepository.findByWarehouse_isDeletedAndProductAttribute_Product_isDeleted( Constant.IS_ACTIVE, Constant.IS_ACTIVE);
		if (inventories != null) {
			inventories = InventoryUtils.setQuantityItem(inventories, quantity);
			inventoryRepository.save(inventories);
			return Constant.ADD_ITEM_QUANTITY;
		}
		return Constant.NO_RECORD;
	}

}