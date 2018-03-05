package com.warehouse.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.warehouse.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{

	public List<Warehouse> findByIsDeleted(int value);
	
	public Warehouse findByIdAndIsDeleted(int id, int value);

}
