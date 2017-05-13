package com.textiles.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "TRANSACTIONS")
@Data
public class TransactionModel {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	Long id;
	
	@Column(name = "USERNAME")
	String username;
	
	@Column(name = "TRANSACTION")
	String transaction;
	
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
}
