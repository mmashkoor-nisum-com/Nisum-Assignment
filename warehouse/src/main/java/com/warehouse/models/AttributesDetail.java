package com.warehouse.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the attributes_detail database table.
 * 
 */
@Entity
@Table(name="attributes_detail")
@NamedQuery(name="AttributesDetail.findAll", query="SELECT a FROM AttributesDetail a")
public class AttributesDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String type;
	private Attribute attribute;
	private List<ProductAttribute> productAttributes;

	public AttributesDetail() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//bi-directional many-to-one association to Attribute
	@ManyToOne
	@JoinColumn(name="attributes_id")
	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	//bi-directional many-to-one association to ProductAttribute
	@OneToMany(mappedBy="attributesDetail")
	public List<ProductAttribute> getProductAttributes() {
		return this.productAttributes;
	}

	public void setProductAttributes(List<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

	public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
		getProductAttributes().add(productAttribute);
		productAttribute.setAttributesDetail(this);

		return productAttribute;
	}

	public ProductAttribute removeProductAttribute(ProductAttribute productAttribute) {
		getProductAttributes().remove(productAttribute);
		productAttribute.setAttributesDetail(null);

		return productAttribute;
	}

}