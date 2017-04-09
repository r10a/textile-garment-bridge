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
@Table(name = "ADMIN")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminModel {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name = "FIRST_NAME")
	String firstName;
	
	@Column(name = "LAST_NAME")
	String lastName;
	
	@Column(name = "EMAIL")
	String email;
	
	@Column(name = "PASSWORD")
	String password;
}
