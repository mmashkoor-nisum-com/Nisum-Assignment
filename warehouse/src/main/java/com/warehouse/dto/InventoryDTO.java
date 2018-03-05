package com.warehouse.dto;

public class InventoryDTO {
	
	private String warehouseName;
	private String productName;
	private String productSize;
	private int inStock;
	private int avaliableQuantity;
	private int inTransit;
	private int minimumOrderQuantity;
	private int quantityPerBox;
	private int reorderPoint;
	
	public InventoryDTO(){
	}
	
	public int getInStock() {
		return inStock;
	}
	
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	public int getAvaliableQuantity() {
		return avaliableQuantity;
	}
	
	public void setAvaliableQuantity(int avaliableQuantity) {
		this.avaliableQuantity = avaliableQuantity;
	}
	
	public int getInTransit() {
		return inTransit;
	}
	
	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}
	
	public int getMinimumOrderQuantity() {
		return minimumOrderQuantity;
	}
	
	public void setMinimumOrderQuantity(int minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}
	
	public int getQuantityPerBox() {
		return quantityPerBox;
	}
	
	public void setQuantityPerBox(int quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}
	
	public int getReorderPoint() {
		return reorderPoint;
	}
	
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	
	public String getWarehouseName() {
		return warehouseName;
	}
	
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductSize() {
		return productSize;
	}
	
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	
}
