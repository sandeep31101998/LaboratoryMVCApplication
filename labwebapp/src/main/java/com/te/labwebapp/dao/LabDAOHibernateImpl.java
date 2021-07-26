package com.te.labwebapp.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.labwebapp.beans.AdminLab;
import com.te.labwebapp.beans.Glucometry;
import com.te.labwebapp.beans.PatientLab;
import com.te.labwebapp.beans.Thyroid;

@Repository
public class LabDAOHibernateImpl implements LabDAO {
	
	@Override
	public List<PatientLab> getAllSamples() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from PatientLab");
		ArrayList<PatientLab> patient = new ArrayList<PatientLab>();
		
		
		try {
			patient = (ArrayList<PatientLab>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			patient = null;
		}

		return patient;
	}
	
	
	

	@Override
	public AdminLab adminLabAuthenticate(String admin_email, String admin_password) {

		AdminLab admin = null;
		

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			EntityManager em = emf.createEntityManager();

			String s = "from AdminLab where admin_email=:email and admin_password=:password";
			Query query = em.createQuery(s);
			query.setParameter("email", admin_email);
			query.setParameter("password", admin_password);

			 admin = (AdminLab) query.getSingleResult();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public boolean registerPatient(String patient_name, String patient_email, String patient_password, int sample_id) {
		
		boolean isInserted = false;
		
		PatientLab patient = new PatientLab();
		
		patient.setPatient_email(patient_email);
		patient.setPatient_password(patient_password);
		patient.setPatient_name(patient_name);
		patient.setSample_id(sample_id);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   
		 patient.setSampleDate(dtf.format(now));
		 
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			try {
				transaction.begin();
				manager.persist(patient);
				transaction.commit();
				isInserted = true;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		
			return isInserted;	
	}

	@Override
	public boolean addThyroidReport(int t1, int t2, int t3, int pid) {

		//System.out.println(t1+" "+t2+" "+t3+" "+pid);
		
		boolean isInserted = false;
				
		Thyroid t = new Thyroid();
		
		t.setT1(t1);
		t.setT2(t2);
		t.setT3(t3);
		t.setPid(pid);
		
		System.out.println(t);
		
		 
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			try {
				transaction.begin();
				manager.persist(t);
				transaction.commit();
				isInserted = true;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		
			return isInserted;	
	}

	@Override
	public Thyroid getThyroidResult(int pid) {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		Thyroid t = new Thyroid();
		
		try {
			
			emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			entityManager = emf.createEntityManager();
			
			String s = "from Thyroid where pid=:pid";
			Query query = entityManager.createQuery(s);
			query.setParameter("pid", pid);
			
			 t = (Thyroid) query.getSingleResult();
			System.out.println(t+" in dao");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return t;
		
	}

	@Override
	public boolean addGlucometeryReport(int g1, int g2, int g3,int g4, int pid) {
		boolean isInserted = false;
		
		Glucometry g = new Glucometry();
		
		g.setG1(g1);
		g.setG2(g2);
		g.setG3(g3);
		g.setG4(g4);
		g.setPid(pid);
		
		System.out.println(g);
		
		 
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			try {
				transaction.begin();
				manager.persist(g);
				transaction.commit();
				isInserted = true;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		
			return isInserted;	
	}

	@Override
	public Glucometry getGlucometeryResult(int pid) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		Glucometry g = new Glucometry();
		
		try {
			
			emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			entityManager = emf.createEntityManager();
			
			String s = "from Glucometry where pid=:pid";
			Query query = entityManager.createQuery(s);
			query.setParameter("pid", pid);
			
			 g = (Glucometry) query.getSingleResult();
			System.out.println(g+" in dao");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return g;
	}

	@Override
	public PatientLab patientLabAuthenticate(String patient_email, String patient_password) {
PatientLab patient = null;
		

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			EntityManager em = emf.createEntityManager();

			String s = "from PatientLab where patient_email=:email and patient_password=:password";
			Query query = em.createQuery(s);
			query.setParameter("email", patient_email);
			query.setParameter("password", patient_password);

			 patient = (PatientLab) query.getSingleResult();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return patient;
	}

	@Override
	public List<PatientLab> getAllSamplesPatient(int p_id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from PatientLab where patient_id=:id");
		query.setParameter("id", p_id);
		ArrayList<PatientLab> patient = new ArrayList<PatientLab>();
		
		
		try {
			patient = (ArrayList<PatientLab>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			patient = null;
		}

		return patient;
	}



}
