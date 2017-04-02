package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "YARNS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YarnModel {
	
	@Id
	@GeneratedValue
	@Column(name = "PK_YARN_ID")
	Long id;
	
	@Column(name = "NAME")
	String name;
	
	@Column(name = "PERCENTAGE")
	Double percentage;
	
	@Column(name = "PERCENTAGE_SYN")
	Double syntheticPercentage;
	
	@Column(name = " TICKET")
	Long ticket;
	
	@Column(name = "COLOR")
	String color;
	
	@Column(name = "LENGTH")
	Double length;
	
	@Column(name = "PRICE")
	Double price;
	
	@ManyToOne
	@JoinColumn(name = "FK_SELLER_ID")
	SellerModel seller;
}
