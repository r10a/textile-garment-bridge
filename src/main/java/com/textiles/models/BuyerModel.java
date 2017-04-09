package com.textiles.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BUYERS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
