package com.te.labwebapp.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.labwebapp.beans.AdminLab;

public class AdminPersist {

	public static void main(String[] args) {
		
		AdminLab admin = new AdminLab();
		
		admin.setAdmin_email("admin@gmail.com");
		
		admin.setAdmin_password("admin");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.persist(admin);
		
		System.out.println("adminLab data added successfully");
		
		transaction.commit();

	}

}
