package com.textiles.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ADMINS")
@Data
public class AdminModel {
	
	@Id
	@Column(name = "USER_NAME")
	String username;
	
	@Column(name = "PASSWORD")
	String password;
}
