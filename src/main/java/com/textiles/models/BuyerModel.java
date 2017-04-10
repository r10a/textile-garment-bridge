package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BUYERS")
@Data
public class BuyerModel {
	
	@Id
	@GeneratedValue
	@Column(name = "PK_BUYER_ID")
	Long id;

	@Column(name = "FIRST_NAME")
	String firstName;

	@Column(name = "MIDDLE_NAME")
	String middleName;

	@Column(name = "LAST_NAME")
	String lastName;

	@Column(name = "EMAIL")
	String email;

	@Column(name = "PASSWORD")
	String password;

	@Column(name = "COMPANY")
	String company;

	@Column(name = "MOBILE")
	String mobile;

	@Column(name = "PHONE")
	String phone;

	@Column(name = "ADDRESS")
	String address;

}
