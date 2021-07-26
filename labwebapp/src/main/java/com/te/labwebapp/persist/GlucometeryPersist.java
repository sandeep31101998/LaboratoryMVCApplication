package com.te.labwebapp.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.labwebapp.beans.Glucometry;

public class GlucometeryPersist {

	public static void main(String[] args) {
		
		Glucometry g = new Glucometry();
		
		g.setG1(1);
		g.setG2(2);
		g.setG3(3);
		g.setG4(4);
		g.setPid(9);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.persist(g);
		
		System.out.println("Glucometery data added successfully");
		
		transaction.commit();
	}
}
