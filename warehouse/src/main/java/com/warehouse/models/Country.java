package com.warehouse.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String country;
	private List<Warehouse> warehouses;

	public Country() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	//bi-directional many-to-one association to Warehouse
	@OneToMany(mappedBy="country")
	public List<Warehouse> getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public Warehouse addWarehous(Warehouse warehous) {
		getWarehouses().add(warehous);
		warehous.setCountry(this);

		return warehous;
	}

	public Warehouse removeWarehous(Warehouse warehous) {
		getWarehouses().remove(warehous);
		warehous.setCountry(null);

		return warehous;
	}

}