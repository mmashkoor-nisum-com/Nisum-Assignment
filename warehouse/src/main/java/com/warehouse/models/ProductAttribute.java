package com.warehouse.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the product_attributes database table.
 * 
 */
@Entity
@Table(name = "product_attributes")
@NamedQuery(name = "ProductAttribute.findAll", query = "SELECT p FROM ProductAttribute p")
public class ProductAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private List<Inventory> inventories;
	private AttributesDetail attributesDetail;
	private Product product;

	public ProductAttribute() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy = "productAttribute")
	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setProductAttribute(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setProductAttribute(null);

		return inventory;
	}

	// bi-directional many-to-one association to AttributesDetail
	@ManyToOne
	@JoinColumn(name = "attributes_detail_id")
	public AttributesDetail getAttributesDetail() {
		return this.attributesDetail;
	}

	public void setAttributesDetail(AttributesDetail attributesDetail) {
		this.attributesDetail = attributesDetail;
	}

	// bi-directional many-to-one association to Product
	@ManyToOne
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}