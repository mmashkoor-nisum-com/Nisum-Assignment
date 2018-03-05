package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.warehouse.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	public List<Inventory> findByWarehouse_isDeletedAndProductAttribute_Product_isDeleted(int value, int pvalue);
	
	public List<Inventory> findByWarehouse_IdAndWarehouse_IsDeleted(int id,int value); 
	
	public List<Inventory> findByProductAttribute_Product_IdAndProductAttribute_Product_IsDeleted(long id,int value); 
	
	public List<Inventory> findByWarehouse_IdAndWarehouse_IsDeletedAndProductAttribute_Product_IdAndProductAttribute_Product_IsDeleted(int id,int value,long pId,int pValue);

	public List<Inventory> findByProductAttribute_IdAndProductAttribute_Product_IsDeleted(int id,int value); 
	
	public Inventory findByWarehouse_IdAndWarehouse_IsDeletedAndProductAttribute_IdAndProductAttribute_Product_IsDeleted(int id, int value ,int pid,int pvalue); 
	
}
