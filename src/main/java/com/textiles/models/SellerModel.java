package com.textiles.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SELLERS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerModel {

	@Id
	@GeneratedValue
	@Column(name = "PK_SELLER_ID")
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

	@Column(name = "TYPE")
	String type;

	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<RawMaterialModel> rawMaterials;

	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<YarnModel> yarns;

	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<FabricModel> fabrics;

	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<GarmentModel> garments;

}
