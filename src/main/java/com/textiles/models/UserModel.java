package com.textiles.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class UserModel {

	@Id
	@GeneratedValue
	@Column(name = "PK_USER_ID")
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

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<RawMaterialModel> listedRawMaterials;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<RawMaterialModel> boughtRawMaterials;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<YarnModel> listedYarns;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<YarnModel> boughtYarns;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<FabricModel> listedFabrics;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<FabricModel> boughtFabrics;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<GarmentModel> listedGarments;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	Set<GarmentModel> boughtGarments;

}
