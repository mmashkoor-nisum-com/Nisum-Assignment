package com.warehouse.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the attributes database table.
 * 
 */
@Entity
@Table(name="attributes")
@NamedQuery(name="Attribute.findAll", query="SELECT a FROM Attribute a")
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<AttributesDetail> attributesDetails;

	public Attribute() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//bi-directional many-to-one association to AttributesDetail
	@OneToMany(mappedBy="attribute")
	public List<AttributesDetail> getAttributesDetails() {
		return this.attributesDetails;
	}

	public void setAttributesDetails(List<AttributesDetail> attributesDetails) {
		this.attributesDetails = attributesDetails;
	}

	public AttributesDetail addAttributesDetail(AttributesDetail attributesDetail) {
		getAttributesDetails().add(attributesDetail);
		attributesDetail.setAttribute(this);

		return attributesDetail;
	}

	public AttributesDetail removeAttributesDetail(AttributesDetail attributesDetail) {
		getAttributesDetails().remove(attributesDetail);
		attributesDetail.setAttribute(null);

		return attributesDetail;
	}

}