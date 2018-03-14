package com.warehouse.utils;

import java.util.ArrayList;
import java.util.List;
import com.warehouse.dto.WarehouseDTO;
import com.warehouse.models.Warehouse;

public class WarehouseUtils {
	
	private WarehouseUtils() {
	}

	public static List<WarehouseDTO> convertWarehouseToWarehouseDTOs(List<Warehouse> warehouses) {
		List<WarehouseDTO> warehouseListDTOs = new ArrayList<>(0);
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
