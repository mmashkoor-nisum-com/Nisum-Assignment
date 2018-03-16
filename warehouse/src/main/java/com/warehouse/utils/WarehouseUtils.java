package com.warehouse.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import com.warehouse.dto.WarehouseDTO;
import com.warehouse.models.Warehouse;

public class WarehouseUtils {

	private WarehouseUtils() {
	}

	public static List<WarehouseDTO> convertWarehouseToWarehouseDTOs(List<Warehouse> warehouses) {
		return warehouses.stream().map(warehouse -> convertWarehouseToWarehouseDTOs(warehouse)).collect(Collectors.toList());
	}

	public static WarehouseDTO convertWarehouseToWarehouseDTOs(Warehouse warehouse) {
		ModelMapper mapper = new ModelMapper();
		WarehouseDTO warehouseDTO = mapper.map(warehouse, WarehouseDTO.class);
		warehouseDTO.setCountryName(warehouse.getCountry().getCountry());
		return warehouseDTO;
	}

}
