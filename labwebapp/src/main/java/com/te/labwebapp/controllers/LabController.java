package com.te.labwebapp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.labwebapp.beans.AdminLab;
import com.te.labwebapp.beans.Glucometry;
import com.te.labwebapp.beans.PatientLab;
import com.te.labwebapp.beans.Thyroid;
import com.te.labwebapp.service.LabService;

@Controller
public class LabController {
	
	public int p_id;

	@Autowired
	private LabService service;

	@GetMapping("/login")
	public String getEmpForm() {
		return "AdminLogin";
	}// getEmpForm

	
	//-----------------------------------------------------------------------------------------------------
	@GetMapping("/adminlablogin")
	public String getAdminLabLogin() {
		return "AdminLabLogin";
	}// getAdminLabLoginForm

	@GetMapping("/patientlablogin")
	public String getPatientLabLogin() {
		return "PatientLogin";
	}// getAdminLabLoginForm
	
	
	
	
	@GetMapping("/registerPatient")
	public String getPatientRegisterPage() {
		return "PatientRegistration";
	}
	
	@PostMapping("/registerPatient")
	public String registerpatient(String patient_name,String patient_email,String patient_password,int sample_id,ModelMap map)
	{
			
		boolean b=service.registerPatient(patient_name, patient_email, patient_password, sample_id);
		
		if(b) {
			map.addAttribute("msg", "Patient Registered successfully");
			return "PatientRegistration";
		}else {
			map.addAttribute("errMsg", "Patient Registered Failure");
			return "PatientRegistration";
		}
	}
	
	
	
	@PostMapping("/addThyroidForm")
	public String addthyroid(int t1,int t2,int t3,int pid,ModelMap map) {
		
		boolean b = service.addThyroidReport(t1, t2, t3, pid);
		if(b) {
			map.addAttribute("msg", "Thyroid report successfully added");
			return "Thyroid";
		}else {
			map.addAttribute("errMsg", "Thyroid report failure");
			return "Thyroid";
		}
	}
	
	@PostMapping("/addGlucometeryForm")
	public String addGlucometery(int g1,int g2,int g3,int g4,int pid,ModelMap map) {
				
		boolean b = service.addGlucometeryReport(g1, g2, g3,g4, pid);
		if(b) {
			map.addAttribute("msg", "Glucometery report successfully added");
			return "Glucometery";
		}else {
			map.addAttribute("errMsg", "Glucometery report failure");
			return "Glucometery";
		}

	}
	
	
	
	@PostMapping("/adminlablogin")
	public String adminlabauthenticate(String admin_email, String admin_password, HttpServletRequest request,
			ModelMap map) {
		AdminLab admin = service.adminLabAuthenticate(admin_email, admin_password);
		
		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", admin);
			return "PatientRegistration";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "AdminLabLogin";
		}
	}// AdminlabLoginauthenticate
	
	@PostMapping("/patientlablogin")
	public String patientlabauthenticate(String patient_email, String patient_password, HttpServletRequest request,
			ModelMap map) {
		PatientLab patient = service.patientLabAuthenticate(patient_email, patient_password);
		
		if (patient != null) {
			this.p_id=patient.getPatient_id();
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", patient);
			return "PatientHome";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "PatientLogin";
		}
	}// AdminlabLoginauthenticate
	
	
	
	

	

	
	
	
	@GetMapping("/searchThyroid")
	public String getThyroidResult(int pid,ModelMap map) {
		System.out.println(pid);
		
		Thyroid t=service.getThyroidResult(pid);
		System.out.println(t+" in controller");
		
		if(t!=null) {
			map.addAttribute("id", t);
			return "ViewThyroid";
		}else {
			map.addAttribute("errMsg", "Throid Report not Found");
			return "ViewThyroid";
		}
	}
	
	@GetMapping("/searchThyroidPatient")
	public String getThyroidResultPatient(ModelMap map) {

		Thyroid t=service.getThyroidResult(p_id);
		System.out.println(t+" in controller");
		
		if(t!=null) {
			map.addAttribute("id", t);
			return "ViewThyroidPatient";
		}else {
			map.addAttribute("errMsg", "Throid Report not Found");
			return "ViewThyroidPatient";
		}
	}
	
	@GetMapping("/searchGlucometeryPatient")
	public String getGlucometeryResult(ModelMap map) {
				
		Glucometry g=service.getGlucometeryResult(p_id);
		System.out.println(g+" in controller");
		
		if(g!=null) {
			map.addAttribute("id", g);
			return "ViewGlucometeryPatient";
		}else {
			map.addAttribute("errMsg", "Glucometery Report not Found");
			return "ViewGlucometeryPatient";
		}
	}
	
	@GetMapping("/searchGlucometery")
	public String getGlucometeryResult(int pid,ModelMap map) {
		System.out.println(pid);
		
		Glucometry g=service.getGlucometeryResult(pid);
		System.out.println(g+" in controller");
		
		if(g!=null) {
			map.addAttribute("id", g);
			return "ViewGlucometery";
		}else {
			map.addAttribute("errMsg", "Glucometery Report not Found");
			return "ViewGlucometery";
		}
	}
	
	
	@GetMapping("/getAllSamples")
	public String getAllSamples(PatientLab patient,Model map) {
		
		List<PatientLab> p = service.getAllSamples();
		if (p != null) {
			
			map.addAttribute("infos", p);

			return "getAllSamples";
		} else {
			map.addAttribute("errMsg", "No Samples Found");
			return "getAllSamples";
		}
		
	}
	
	@GetMapping("/getAllSamplesPatient")
	public String getAllSamplesPatient(PatientLab patient,Model map) {
		
		List<PatientLab> p = service.getAllSamplesPatient(p_id);
		
		if (p != null) {
			
			map.addAttribute("infos", p);

			return "PatientHome";
		} else {
			map.addAttribute("errMsg", "No Samples Found");
			return "PatientHome";
		}
		
	}
	
	@GetMapping("/addThyroid")
	public String getThroidForm() {
		return "Thyroid";
	}
	
	@GetMapping("/viewThyroid")
	public String viewThroid() {
		
		return "ViewThyroid";
	}
	
	@GetMapping("/addGlucometery")
	public String getGlucometeryForm() {
		return "Glucometery";
	}
	
	@GetMapping("/viewGlucometery")
	public String viewGlucometery() {
		return "ViewGlucometery";
	}

	
	

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Admin logout successfull");
		return "AdminLogin";
	}// logout
	
	@GetMapping("/Adminlablogout")
	public String Adminlablogout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Admin logout successfull");
		return "AdminLabLogin";
	}// logout
	
	@GetMapping("/Patientlablogout")
	public String patientlablogout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Patient logout successfull");
		return "PatientLogin";
	}// logout
	

	

	
	
	
}
