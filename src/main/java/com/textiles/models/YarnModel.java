package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "YARNS")
@Data
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
	
	@Column(name = "IMAGE")
	String imageUrl;
	
	@Column(name = "PRICE")
	Double price;
}
