package com.warehouse.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import com.warehouse.dto.InventoryDTO;
import com.warehouse.models.Inventory;

public class InventoryUtils {

	private InventoryUtils() {
	}

	public static InventoryDTO convertToInventoryDTO (Inventory inventory) {
		ModelMapper mapper = new ModelMapper();
		InventoryDTO inventoryDTO = mapper.map(inventory, InventoryDTO.class);
		inventoryDTO.setProductSize(inventory.getProductAttribute().getAttributesDetail().getType());
		return inventoryDTO;
	}

	public static List<InventoryDTO> convertInventoryListToInventoryListDTOs(List<Inventory> inventories){
		return inventories.stream().map(inventory -> convertToInventoryDTO(inventory)).collect(Collectors.toList());
	}

	public static Inventory setQuantityItem (Inventory inventory , int quantity){
		int itemQuantity = inventory.getAvaliableQuantity();
		itemQuantity = itemQuantity + quantity;
		inventory.setAvaliableQuantity(itemQuantity);
		return inventory;
	}

	public static List<Inventory> setQuantityItem (List<Inventory> inventories , int quantity){
		return inventories.stream().map(inventory -> setQuantityItem(inventory, quantity )).collect(Collectors.toList());
	}

}
