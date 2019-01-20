package com.hospitalmanagementusingfile.service;

import java.io.IOException;
import java.util.ArrayList;

import com.hospitalmanagementusingfile.dao.DoctorDao;
import com.hospitalmanagementusingfile.model.Doctor;


public class DoctorSevice {
DoctorDao doctorDao = new DoctorDao();
	
	public void addDoctor(Doctor doctor) throws IOException {
		doctorDao.add(doctor);
	}
	
	public ArrayList<Doctor> readDoctor() throws IOException {
		return doctorDao.read();
	}
	
	public boolean doctorSearch(int id) throws IOException {
		return doctorDao.search(id);
	}
	
	public void updateDoctor(Doctor doctor) throws IOException {
		doctorDao.update(doctor);
		
	}
	
	public void deleteDoctor(int id) throws IOException {
		doctorDao.delete(id);
	}

}
