package com.warehouse.services;

import java.util.List;
import com.warehouse.models.Inventory;

public interface InventoryService {
	
	/**
	 * The method fetches all the inventories
	 * 
	 * @return list of inventory
	 */
	public List<Inventory> getInventories();

	/**
	 * The method fetches the inventories of particular warehouse
	 * 
	 * @param warehouse id
	 * @return list of inventory
	 */
	public List<Inventory> getInventoryByWarehouseId(int id);

	/**
	 * The method fetches the inventory of particular product present in any warehouse
	 * 
	 * @param product id
	 * @return list of inventory
	 */
	public List<Inventory> getInventoryByProductId(long id);

	/**
	 * The method fetches the inventory of particular product present in particular warehouse
	 * 
	 * @param product id, warehouse id
	 * @return list of inventory
	 */
	public List<Inventory> getInventoryByWarehouseIdAndProductId(int id, long pId);
	
	/**
	 * The method set the quantity of particular product having particular size present in any warehouse.
	 * 
	 * @param product attribute id ,quantity
	 * @return message
	 */	
	public List<Inventory> setItemQuantityByProductAttributeId(int pId , int quanity);
	
	/**
	 * The method set the quantity of particular product having particular size present in particular warehouse.
	 * 
	 * @param product attribute id, warehouse id, quantity
	 * @return message
	 */
	public Inventory setItemQuantityByWarehouseIdAndProductAttributeId(int id, int pId , int quanity);
	
	/**
	 * The method set the quantity of for all product present in given warehouse.
	 * 
	 * @param warehouse id, quantity
	 * @return message
	 */
	public List<Inventory> setItemQuantityByWarehouseId(int warehouseId, int quantity);
	

	/**
	 * The method set the quantity for all inventories.
	 * 
	 * @param warehouse id, quantity
	 * @return message
	 */
	public List<Inventory> setItemQuantityToAllProducts(int quantity);
}
