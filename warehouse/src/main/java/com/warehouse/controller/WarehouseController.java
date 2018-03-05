package com.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.dto.WarehouseDTO;
import com.warehouse.models.Warehouse;
import com.warehouse.services.WarehouseService;
import com.warehouse.utils.WarehouseUtils;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;

	/**
	 * The method is used to fetch all the warehouse.
	 * 
	 * @return list of WarehouseDTO
	 */
	@GetMapping("/")
	public List<WarehouseDTO> getWarehouses(){
		List<Warehouse> warehouseList = warehouseService.getWarehouses(); 
		return WarehouseUtils.convertWarehouseToWarehouseDTOs(warehouseList);
	}

	/**
	 * This method is used to return the particular warehouse.
	 *  
	 * @param warehouse id
	 * @return WarehouseDTO
	 */
	@GetMapping("/{warehouseId}")
	public WarehouseDTO getWarehouseById(@PathVariable int warehouseId) {
		Warehouse warehouse = warehouseService.getWarehouseById(warehouseId); 
		return WarehouseUtils.convertWarehouseToWarehouseDTOs(warehouse);
	}

	/**
	 * This method is used to add the warehouse.
	 *  
	 * @return message
	 */
	@PostMapping("/")
	public String addWarehouse(@RequestBody Warehouse warehouse) {
		return warehouseService.addWarehouse(warehouse);
	}

	/**
	 * This method is used to update the warehouse.
	 *  
	 * @param  warehouse id
	 * @return message
	 */
	@PutMapping("/{id}")
	public String updateWarehouse(@RequestBody Warehouse warehouse , @PathVariable int id) {
		return warehouseService.updateWarehouse(warehouse , id);
	}

	/**
	 * This method is used to delete the warehouse.
	 *  
	 * @param warehouse id
	 * @return message
	 */
	@DeleteMapping("/{warehouseId}")
	public String deleteWarehouse(@PathVariable int warehouseId) {
		return warehouseService.deleteWarehouse(warehouseId);
	}
}
