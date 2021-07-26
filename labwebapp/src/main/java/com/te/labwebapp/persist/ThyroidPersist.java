package com.te.labwebapp.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.labwebapp.beans.Thyroid;

public class ThyroidPersist {

	public static void main(String[] args) {
		
		Thyroid t = new Thyroid();
		t.setT1(12);
		t.setT2(13);
		t.setT3(14);
		t.setPid(9);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.persist(t);
		
		System.out.println("Thyroid data added successfully");
		
		transaction.commit();
		
	}
}
