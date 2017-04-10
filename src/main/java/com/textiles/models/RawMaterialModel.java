package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RAW_MATERIALS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "FK_SELLER_ID")
	SellerModel seller;
}
