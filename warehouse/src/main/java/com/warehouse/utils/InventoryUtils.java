package com.warehouse.utils;

import java.util.ArrayList;
import java.util.List;

import com.warehouse.dto.InventoryDTO;
import com.warehouse.models.Inventory;

public class InventoryUtils {
	
	public static List<InventoryDTO> convertInventoryListToInventoryListDTOs(List<Inventory> inventories){
		List<InventoryDTO> inventoryDTOs = new ArrayList<InventoryDTO>(0);
		for(Inventory inventory : inventories) {
			InventoryDTO inventoryDTO = new InventoryDTO();
			inventoryDTO.setWarehouseName(inventory.getWarehouse().getWarehouseName());
			inventoryDTO.setProductName(inventory.getProductAttribute().getProduct().getProductName());
			inventoryDTO.setProductSize(inventory.getProductAttribute().getAttributesDetail().getType());
			inventoryDTO.setInStock(inventory.getInStock());
			inventoryDTO.setInTransit(inventory.getInTransit());
			inventoryDTO.setMinimumOrderQuantity(inventory.getMinimumOrderQuantity());
			inventoryDTO.setQuantityPerBox(inventory.getQuantityPerBox());
			inventoryDTO.setReorderPoint(inventory.getReorderPoint());
			inventoryDTO.setAvaliableQuantity(inventory.getAvaliableQuantity());
			inventoryDTOs.add(inventoryDTO);
		}
		return inventoryDTOs;
	}
	
	public static List<Inventory> setQuantityItem (List<Inventory> inventories , int quantity){
		 List<Inventory> inventoryList = new ArrayList<Inventory>(0);
		    for (Inventory inventory : inventories) {
		    	int itemQuantity = inventory.getAvaliableQuantity();
		    	itemQuantity = itemQuantity + quantity;
				inventory.setAvaliableQuantity(itemQuantity);
				inventoryList.add(inventory);
		    }
		return inventoryList;    
	}
	
	public static Inventory setQuantityItem (Inventory inventory , int quantity){
		    	int itemQuantity = inventory.getAvaliableQuantity();
		    	itemQuantity = itemQuantity + quantity;
				inventory.setAvaliableQuantity(itemQuantity);
		    return inventory;
	}
	
}
