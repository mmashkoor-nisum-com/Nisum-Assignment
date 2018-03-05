package com.warehouse.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private int avaliableQuantity;
	private int inStock;
	private int inTransit;
	private int minimumOrderQuantity;
	private int quantityPerBox;
	private int reorderPoint;
	private ProductAttribute productAttribute;
	private Warehouse warehouse;

	public Inventory() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="avaliable_quantity")
	public int getAvaliableQuantity() {
		return this.avaliableQuantity;
	}

	public void setAvaliableQuantity(int avaliableQuantity) {
		this.avaliableQuantity = avaliableQuantity;
	}

	@Column(name="in_stock")
	public int getInStock() {
		return this.inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	@Column(name="in_transit")
	public int getInTransit() {
		return this.inTransit;
	}

	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}

	@Column(name="minimum_order_quantity")
	public int getMinimumOrderQuantity() {
		return this.minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(int minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	@Column(name="quantity_per_box")
	public int getQuantityPerBox() {
		return this.quantityPerBox;
	}

	public void setQuantityPerBox(int quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}

	@Column(name="reorder_point")
	public int getReorderPoint() {
		return this.reorderPoint;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	//bi-directional many-to-one association to ProductAttribute
	@ManyToOne
	@JoinColumn(name="product_attributes_id")
	public ProductAttribute getProductAttribute() {
		return this.productAttribute;
	}

	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
	}

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}