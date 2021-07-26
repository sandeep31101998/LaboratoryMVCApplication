package com.te.labwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.labwebapp.beans.AdminLab;
import com.te.labwebapp.beans.Glucometry;
import com.te.labwebapp.beans.PatientLab;
import com.te.labwebapp.beans.Thyroid;
import com.te.labwebapp.dao.LabDAO;

@Service
public class LabServiceImpl implements LabService {

	@Autowired
	LabDAO dao;

	@Override
	public AdminLab adminLabAuthenticate(String admin_email, String admin_password) {
		
		return dao.adminLabAuthenticate(admin_email, admin_password);
	}

	@Override
	public boolean registerPatient(String patient_name, String patient_email, String patient_password, int sample_id) {
		return dao.registerPatient(patient_name, patient_email, patient_password, sample_id);
	}

	@Override
	public List<PatientLab> getAllSamples() {
		return dao.getAllSamples();
	}

	@Override
	public boolean addThyroidReport(int t1, int t2, int t3, int pid) {
		
		return dao.addThyroidReport(t1, t2, t3, pid);
	}

	@Override
	public Thyroid getThyroidResult(int pid) {
		return dao.getThyroidResult(pid);
	}

	@Override
	public boolean addGlucometeryReport(int g1, int g2, int g3,int g4, int pid) {
		return dao.addGlucometeryReport(g1, g2, g3,g4, pid);
	}

	@Override
	public Glucometry getGlucometeryResult(int pid) {
		return dao.getGlucometeryResult(pid);
	}

	@Override
	public PatientLab patientLabAuthenticate(String patient_email, String patient_password) {
		return dao.patientLabAuthenticate(patient_email, patient_password);
	}

	@Override
	public List<PatientLab> getAllSamplesPatient(int p_id) {
		return dao.getAllSamplesPatient(p_id);
	}

	

}
