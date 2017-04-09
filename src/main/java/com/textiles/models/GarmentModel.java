package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GARMENTS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
	
	@ManyToOne
	@JoinColumn(name = "FK_SELLER_ID")
	SellerModel seller;

}
