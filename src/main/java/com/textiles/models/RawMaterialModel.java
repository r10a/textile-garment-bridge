package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RAW_MATERIALS")
@Data
public class RawMaterialModel {
	
	@Id
	@GeneratedValue
	@Column(name = "PK_RAW_MAT_ID")
	Long id;
	
	@Column(name = "NAME")
	String name;
	
	@Column(name = "NATURE")
	String nature;
	
	@Column(name = "WEIGHT")
	Double weight;
	
	@Column(name = " QUANTITY")
	Long quantity;
	
	@Column(name = "PRICE")
	Double price;
	
}
