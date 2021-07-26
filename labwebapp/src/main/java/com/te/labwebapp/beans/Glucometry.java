package com.te.labwebapp.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"pid"})})
public class Glucometry implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gid;
	
	@Column
	private int g1;
	
	@Column
	private int g2;
	
	@Column
	private int g3;
	
	@Column
	private int g4;
	
	@Column(unique = true)
	private int pid;
}
