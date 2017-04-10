package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GARMENTS")
@Data
public class GarmentModel {
	

	@Id
	@GeneratedValue
	@Column(name = "PK_GARMENT_ID")
	Long id;
	
	@Column(name = "NAME")
	String name;
	
	@Column(name = "SPECIFICATION")
	String specification;
	
	@Column(name = "SIZE")
	String size;
	
	@Column(name = "STYLING")
	String styling;
	
	@Column(name = "QUANTITY")
	Long quantity;
	
	@Column(name = "PRICE")
	Double price;

}
