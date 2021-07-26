package com.te.labwebapp.beans;

import java.sql.Date;
import java.time.LocalDate;

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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"sample_id"})})
public class PatientLab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	
	@Column
	private String patient_name;
	
	@Column
	private String patient_email;
	
	@Column
	private String patient_password;
	
	@Column
	private String sampleDate;
	
	@Column(unique = true)
	private int sample_id;

	
}
