package com.warehouse.utils;

import java.util.ArrayList;
import java.util.List;
import com.warehouse.dto.WarehouseDTO;
import com.warehouse.models.Warehouse;

public class WarehouseUtils {

	public static List<WarehouseDTO> convertWarehouseToWarehouseDTOs(List<Warehouse> warehouses) {
		List<WarehouseDTO> warehouseListDTOs = new ArrayList<WarehouseDTO>(0);
		for (Warehouse warehouse : warehouses) {
			WarehouseDTO warehouseDTO = new WarehouseDTO();
			warehouseDTO.setId(warehouse.getId());
			warehouseDTO.setWarehouseName(warehouse.getWarehouseName());
			warehouseDTO.setWarehouseAddress(warehouse.getWarehouseAddress());
			warehouseDTO.setCountryName(warehouse.getCountry().getCountry());
			warehouseListDTOs.add(warehouseDTO);
		}
		return warehouseListDTOs;
	}

	public static WarehouseDTO convertWarehouseToWarehouseDTOs(Warehouse warehouse) {
		WarehouseDTO warehouseDTO = new WarehouseDTO();
		warehouseDTO.setId(warehouse.getId());
		warehouseDTO.setWarehouseName(warehouse.getWarehouseName());
		warehouseDTO.setWarehouseAddress(warehouse.getWarehouseAddress());
		warehouseDTO.setCountryName(warehouse.getCountry().getCountry());
		return warehouseDTO;
	}
	
}
