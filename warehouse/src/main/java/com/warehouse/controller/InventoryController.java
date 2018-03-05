package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.dto.InventoryDTO;
import com.warehouse.models.Inventory;
import com.warehouse.services.InventoryService;
import com.warehouse.utils.InventoryUtils;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	/**
	 * This method is used to return all the inventory
	 * 
	 * @return list of InventoryDTO
	 */
	@GetMapping("/")
	public List<InventoryDTO> getInventory(){
		List<Inventory> inventories = inventoryService.getInventories();
		return InventoryUtils.convertInventoryListToInventoryListDTOs(inventories);		
	}

	/**
	 * This method is used to return all the inventory of particular warehouse.
	 *  
	 * @param warehouse id
	 * @return list of InventoryDTO
	 */
	@GetMapping("/warehouse/{warehouseId}")
	public List<InventoryDTO> getInventoryByWarehouseId(@PathVariable int warehouseId){
		List<Inventory> inventories = inventoryService.getInventoryByWarehouseId(warehouseId);
		return InventoryUtils.convertInventoryListToInventoryListDTOs(inventories);	
	}

	/**
	 * This method is used to return all the inventory of particular product present in any warehouse.
	 *  
	 * @param product id
	 * @return list of InventoryDTO
	 */
	@GetMapping("/product/{productId}")
	public List<InventoryDTO> getInventoryByProductId(@PathVariable int productId){
		List<Inventory> inventories = inventoryService.getInventoryByProductId(productId);
		return InventoryUtils.convertInventoryListToInventoryListDTOs(inventories);	
	}

	/**
	 * This method is used to return all the inventory of particular product present in particular warehouse
	 *  
	 * @param warehouse id, product id
	 * @return list of InventoryDTO
	 */
	@GetMapping("/warehouse/{warehouseId}/product/{productId}")
	public List<InventoryDTO> getInventoryByWarehouseIdAndProductId(@PathVariable int warehouseId , @PathVariable long productId){
		List<Inventory> inventories = inventoryService.getInventoryByWarehouseIdAndProductId(warehouseId,productId);
		return InventoryUtils.convertInventoryListToInventoryListDTOs(inventories);	
	}

	/**
	 * This method is used to set the quantity of particular product having particular size present in any warehouse.
	 *  
	 * @param product attribute id ,quantity
	 * @return the message
	 */
	@PostMapping("/product/{productAttributeId}/quantity/{quantity}")
	public String addItemQuantityByProductAttributeId(@PathVariable int productAttributeId , @PathVariable int quantity){
		return inventoryService.setItemQuantityByProductAttributeId(productAttributeId , quantity);
	}

	/**
	 * This method is used to set the quantity of particular product having particular size present in particular warehouse.
	 *  
	 * @param warehouseId, product attribute id ,quantity
	 * @return the message
	 */
	@PostMapping("/{warehouseId}/product/{productAttributeId}/quantity/{quantity}")
	public String addItemQuantityByWarehouseIdAndProductAttributeId(@PathVariable int warehouseId, @PathVariable int productAttributeId , @PathVariable int quantity){
		return inventoryService.setItemQuantityByWarehouseIdAndProductAttributeId(warehouseId, productAttributeId , quantity);
	}

	/**
	 * This method is used to set the quantity of for all product present in given warehouse.
	 *  
	 * @param warehouseId ,quantity
	 * @return the message
	 */
	@PostMapping("/{warehouseId}/quantity/{quantity}")
	public String addItemQuantityByWarehouseId(@PathVariable int warehouseId, @PathVariable int quantity){
		return inventoryService.setItemQuantityByWarehouseId(warehouseId , quantity);
	}

	/**
	 * This method is used to set the quantity for all inventories
	 *  
	 * @param quantity
	 * @return the message
	 */
	@PostMapping("/quantity/{quantity}")
	public String addItemQuantityToAllProduct(@PathVariable int quantity){
		return inventoryService.setItemQuantityToAllProducts(quantity);
	}
}
