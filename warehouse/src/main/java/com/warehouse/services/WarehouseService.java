package com.warehouse.services;

import java.util.List;
import com.warehouse.models.Warehouse;

public interface WarehouseService {

	/**
	 * The method is used to fetch all the warehouse.
	 * 
	 * @return list of warehouse
	 */
	public List<Warehouse> getWarehouses();
	
	/**
	 * This method is used to return the particular warehouse.
	 *  
	 * @param warehouse id
	 * @return warehouse
	 */
	public Warehouse getWarehouseById(int id);
	
	/**
	 * This method is used to add the warehouse.
	 *  
	 * @param warehouse
	 * @return message
	 */
	public String addWarehouse(Warehouse warehouse);

	/**
	 * This method is used to update the warehouse.
	 *  
	 * @param warehouse , warehouse id
	 * @return message
	 */
	public String updateWarehouse(Warehouse warehouse , int id);
	
	/**
	 * This method is used to delete the warehouse.
	 *  
	 * @param warehouse , warehouse id
	 * @return message
	 */
	public String deleteWarehouse(int id);

}
