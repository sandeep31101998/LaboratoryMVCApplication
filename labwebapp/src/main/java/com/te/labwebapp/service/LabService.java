package com.te.labwebapp.service;

import java.util.List;

import com.te.labwebapp.beans.AdminLab;
import com.te.labwebapp.beans.Glucometry;
import com.te.labwebapp.beans.PatientLab;
import com.te.labwebapp.beans.Thyroid;

public interface LabService {
	
	public AdminLab adminLabAuthenticate(String admin_email,String admin_password);
	
	public PatientLab patientLabAuthenticate(String patient_email,String patient_password);
	
	public boolean registerPatient(String patient_name,String patient_email,String patient_password,int sample_id);
	
	public List<PatientLab> getAllSamples();
	
	public List<PatientLab> getAllSamplesPatient(int p_id);
	
	public boolean addThyroidReport(int t1,int t2,int t3,int pid);
	
	public Thyroid getThyroidResult(int pid);
	
	public boolean addGlucometeryReport(int g1,int g2,int g3,int g4,int pid);
	
	public Glucometry getGlucometeryResult(int pid);
}
