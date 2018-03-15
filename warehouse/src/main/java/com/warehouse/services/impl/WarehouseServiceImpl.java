package com.warehouse.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.constant.Constant;
import com.warehouse.models.Warehouse;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.services.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	public List<Warehouse> getWarehouses(){
		return warehouseRepository.findByIsDeleted(Constant.IS_ACTIVE);
	}

	public Warehouse getWarehouseById(int id) {
		return warehouseRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
	}

	public Warehouse addWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}

	public Warehouse updateWarehouse(Warehouse warehouse, int id) {
		Warehouse warehouseRecord = warehouseRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
		if(warehouseRecord != null) {
			warehouse.setId(id);
			return warehouseRepository.save(warehouse);
		}
		return warehouseRecord;
	}

	public Warehouse deleteWarehouse(int id) {
		Warehouse warehouse = warehouseRepository.findByIdAndIsDeleted(id, Constant.IS_ACTIVE);
		if(warehouse != null) {
			warehouse.setIsDeleted(Constant.IS_DELETE);
			return warehouseRepository.save(warehouse);
		}
		return warehouse;
	}
}
