package com.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.constant.Constant;
import com.warehouse.dto.WarehouseDTO;
import com.warehouse.models.Warehouse;
import com.warehouse.services.WarehouseService;
import com.warehouse.utils.CustomMessage;
import com.warehouse.utils.WarehouseUtils;
import java.util.List;

@Controller
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	
	private String entityName = "Warehouse";

	@Autowired
	private WarehouseService warehouseService;

	/**
	 * The method is used to fetch all the warehouse.
	 * 
	 * @return list of WarehouseDTO
	 */
	@GetMapping("/")
	public ResponseEntity<List<WarehouseDTO>> getWarehouses(){
		List<Warehouse> warehouseList = warehouseService.getWarehouses(); 
		List<WarehouseDTO> warehouseListDTO = WarehouseUtils.convertWarehouseToWarehouseDTOs(warehouseList);
		if(warehouseListDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(warehouseListDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to return the particular warehouse.
	 *  
	 * @param warehouse id
	 * @return WarehouseDTO
	 */
	@GetMapping("/{warehouseId}")
	public ResponseEntity<?> getWarehouseById(@PathVariable int warehouseId) {
		Warehouse warehouse = warehouseService.getWarehouseById(warehouseId); 
		if(warehouse == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		WarehouseDTO warehouseDTO =  WarehouseUtils.convertWarehouseToWarehouseDTOs(warehouse);
		return new ResponseEntity<>(warehouseDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to add the warehouse.
	 *  
	 * @return message
	 */
	@PostMapping("/")
	public ResponseEntity<CustomMessage> addWarehouse(@RequestBody Warehouse warehouse) {
		warehouseService.addWarehouse(warehouse);
		return new ResponseEntity<>(new CustomMessage(String.format(Constant.CREATE_SUCCESS_MESSAGE, entityName)), HttpStatus.CREATED);
	}

	/**
	 * This method is used to update the warehouse.
	 *  
	 * @param  warehouse id
	 * @return message
	 */
	@PutMapping("/{id}")
	public ResponseEntity<CustomMessage> updateWarehouse(@RequestBody Warehouse warehouse , @PathVariable int id) {
		Warehouse warehouseRecord = warehouseService.updateWarehouse(warehouse , id);
		if (warehouseRecord == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(String.format(Constant.UPDATE_SUCCESS_MESSAGE, entityName)), HttpStatus.OK);
	}

	/**
	 * This method is used to delete the warehouse.
	 *  
	 * @param warehouse id
	 * @return message
	 */
	@DeleteMapping("/{warehouseId}")
	public ResponseEntity<CustomMessage> deleteWarehouse(@PathVariable int warehouseId) {
		Warehouse warehouseRecord = warehouseService.deleteWarehouse(warehouseId);
		if (warehouseRecord == null) {
			return new ResponseEntity<>(new CustomMessage(Constant.NO_RECORD), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomMessage(String.format(Constant.DELETE_SUCCESS_MESSAGE, entityName)), HttpStatus.OK);
	}
}
