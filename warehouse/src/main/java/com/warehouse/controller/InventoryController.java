package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.constant.Constant;
import com.warehouse.dto.InventoryDTO;
import com.warehouse.models.Inventory;
import com.warehouse.services.InventoryService;
import com.warehouse.utils.CustomMessage;
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
	public ResponseEntity<?> getInventory(){
		List<Inventory> inventoryList = inventoryService.getInventories();
		if (inventoryList.isEmpty()) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		List<InventoryDTO> inventoryListDTO = InventoryUtils.convertInventoryListToInventoryListDTOs(inventoryList);	
		return new ResponseEntity<>(inventoryListDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to return all the inventory of particular warehouse.
	 *  
	 * @param warehouse id
	 * @return list of InventoryDTO
	 */
	@GetMapping("/warehouse/{warehouseId}")
	public ResponseEntity<?> getInventoryByWarehouseId(@PathVariable int warehouseId){
		List<Inventory> inventoryList = inventoryService.getInventoryByWarehouseId(warehouseId);
		if (inventoryList.isEmpty()) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		List<InventoryDTO> inventoryListDTO = InventoryUtils.convertInventoryListToInventoryListDTOs(inventoryList);
		return new ResponseEntity<>(inventoryListDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to return all the inventory of particular product present in any warehouse.
	 *  
	 * @param product id
	 * @return list of InventoryDTO
	 */
	@GetMapping("/product/{productId}")
	public ResponseEntity<?> getInventoryByProductId(@PathVariable int productId){
		List<Inventory> inventoryList = inventoryService.getInventoryByProductId(productId);
		if (inventoryList.isEmpty()) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		List<InventoryDTO> inventoryListDTO = InventoryUtils.convertInventoryListToInventoryListDTOs(inventoryList);
		return new ResponseEntity<>(inventoryListDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to return all the inventory of particular product present in particular warehouse
	 *  
	 * @param warehouse id, product id
	 * @return list of InventoryDTO
	 */
	@GetMapping("/warehouse/{warehouseId}/product/{productId}")
	public ResponseEntity<?> getInventoryByWarehouseIdAndProductId(@PathVariable int warehouseId , @PathVariable long productId){
		List<Inventory> inventoryList = inventoryService.getInventoryByWarehouseIdAndProductId(warehouseId,productId);
		if (inventoryList.isEmpty()) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		List<InventoryDTO> inventoryListDTO = InventoryUtils.convertInventoryListToInventoryListDTOs(inventoryList);
		return new ResponseEntity<>(inventoryListDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to set the quantity of particular product having particular size present in any warehouse.
	 *  
	 * @param product attribute id ,quantity
	 * @return the message
	 */
	@PostMapping("/product/{productAttributeId}/quantity/{quantity}")
	public ResponseEntity<CustomMessage> addItemQuantityByProductAttributeId(@PathVariable int productAttributeId , @PathVariable int quantity){
		String status = inventoryService.setItemQuantityByProductAttributeId(productAttributeId , quantity);
		if (status == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(status), HttpStatus.OK);
	}

	
	/**
	 * This method is used to set the quantity of particular product having particular size present in particular warehouse.
	 *  
	 * @param warehouseId, product attribute id ,quantity
	 * @return the message
	 */
	@PostMapping("/{warehouseId}/product/{productAttributeId}/quantity/{quantity}")
	public ResponseEntity<CustomMessage> addItemQuantityByWarehouseIdAndProductAttributeId(@PathVariable int warehouseId, @PathVariable int productAttributeId , @PathVariable int quantity){
		String status = inventoryService.setItemQuantityByWarehouseIdAndProductAttributeId(warehouseId, productAttributeId , quantity);
		if (status == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(status), HttpStatus.OK);
	}

	/**
	 * This method is used to set the quantity of for all product present in given warehouse.
	 *  
	 * @param warehouseId ,quantity
	 * @return the message
	 */
	@PostMapping("/{warehouseId}/quantity/{quantity}")
	public ResponseEntity<CustomMessage> addItemQuantityByWarehouseId(@PathVariable int warehouseId, @PathVariable int quantity){
		String status =  inventoryService.setItemQuantityByWarehouseId(warehouseId , quantity);
		if (status == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(status), HttpStatus.OK);
	}

	/**
	 * This method is used to set the quantity for all inventories
	 *  
	 * @param quantity
	 * @return the message
	 */
	@PostMapping("/quantity/{quantity}")
	public ResponseEntity<CustomMessage> addItemQuantityToAllProduct(@PathVariable int quantity){
		String status = inventoryService.setItemQuantityToAllProducts(quantity);
		if (status == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(status), HttpStatus.OK);
	}
}
