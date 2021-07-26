package com.te.labwebapp.persist;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.labwebapp.beans.PatientLab;

public class PatientPersist {

	public static void main(String[] args) {
		
		PatientLab patient = new PatientLab();
		
		patient.setPatient_email("sandeep@gmail.com");
		patient.setPatient_password("sandeep");
		patient.setPatient_name("sandeep");
		patient.setSample_id(1);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   
		 patient.setSampleDate(dtf.format(now));
		 
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			transaction.begin();
			
			em.persist(patient);
			
			System.out.println("PatientLab data added successfully");
			
			transaction.commit();
		 

	}

}
