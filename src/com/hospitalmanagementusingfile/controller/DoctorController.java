package com.hospitalmanagementusingfile.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.hospitalmanagementusingfile.model.Doctor;
import com.hospitalmanagementusingfile.service.DoctorSevice;


public class DoctorController {
	
	Doctor doctor = new Doctor();
	DoctorSevice doctorService = new DoctorSevice();
	
	
	
	public void add(String name, String speciality) throws IOException {
		doctor.setName(name);
		doctor.setSpecialist(speciality);
		doctorService.addDoctor(doctor);
		
	}
	
	public ArrayList<Doctor> read() throws IOException {
		return doctorService.readDoctor();
	}
	
	public boolean search(int id) throws IOException {
		return doctorService.doctorSearch(id);
		
	}
	
	public void update(Doctor doctor) throws IOException {
		
		doctorService.updateDoctor(doctor);
	}
	
	public void delete(int id) throws IOException {
		doctorService.deleteDoctor(id);
	}
	
	
	

}
