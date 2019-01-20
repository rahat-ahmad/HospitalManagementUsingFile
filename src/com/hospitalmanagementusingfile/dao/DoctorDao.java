package com.hospitalmanagementusingfile.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.hospitalmanagementusingfile.model.Doctor;

public class DoctorDao {
	String fileLocation = "H:\\CSV\\Doctor.csv";
	String row = "";

	String line = "";

	//static ArrayList<Doctor> doctorArray = new ArrayList<Doctor>();

	public void add(Doctor doctor) throws IOException {

		int index = 0;
		File file = new File(fileLocation);
		if (file.exists()) {
			//FileReader fr = new FileReader(file);
			// LineNumberReader lnr = new LineNumberReader(fr);

			BufferedReader br = new BufferedReader(new FileReader(fileLocation));

			if (file.length() == 0) {
				index = 0;
			}

			else {
				while ((line = br.readLine()) != null) {
					// index++;
					String[] list = line.split(",");
					index = Integer.valueOf(list[0]);
				}

			}
			br.close();

		}

		FileWriter pw = new FileWriter(fileLocation, true);
		StringBuilder sb = new StringBuilder();
		doctor.setId(index + 1);
		sb.append(doctor.getId());
		sb.append(',');
		sb.append(doctor.getName());
		sb.append(',');
		sb.append(doctor.getSpecialist());
		sb.append('\n');
		pw.write(sb.toString());

		pw.close();
	}

	public ArrayList<Doctor> read() throws IOException {
		ArrayList<Doctor> doctorList = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(fileLocation));
		while ((row = br.readLine()) != null) {

			// use comma as separator
			String[] list = row.split(",");
			Doctor doctor = new Doctor();
			doctor.setId(Integer.valueOf(list[0]));
			doctor.setName(list[1]);
			doctor.setSpecialist(list[2]);
			doctorList.add(doctor);
		}
		br.close();
		return doctorList;

	}

	public boolean search(int id) throws IOException {
		ArrayList<Doctor> doctorList = new ArrayList<>();
		DoctorDao doctorDao = new DoctorDao();
		doctorList = doctorDao.read();
		//Doctor doctor = new Doctor();
		for (Doctor item : doctorList) {

			if (item.getId() == id) {
				return false;
			}
		}
		return true;
	}

	public void update(Doctor doctor) throws IOException {
		ArrayList<Doctor> doctorList = new ArrayList<>();
		DoctorDao doctorDao = new DoctorDao();
		doctorList = doctorDao.read();
		for (Doctor item : doctorList) {
			if (item.getId() == doctor.getId()) {
				item.setName(doctor.getName());
				item.setSpecialist(doctor.getSpecialist());
				break;
			}
		}
		File file = new File(fileLocation);
		file.delete();
		listToFile(doctorList);
	}
	
	public void delete(int id) throws IOException {
		ArrayList<Doctor> doctorList = new ArrayList<>();
		DoctorDao doctorDao = new DoctorDao();
		doctorList = doctorDao.read();
		
		for (Doctor item : doctorList) {
			if (item.getId() == id) {
				doctorList.remove(item);
				break;
			}
		}
		File file = new File(fileLocation);
		file.delete();
		listToFile(doctorList);
		
	}
	
	public void listToFile(ArrayList<Doctor> doctorList) throws IOException {
		
		for(Doctor doctor : doctorList) {
			FileWriter pw = new FileWriter(fileLocation , true);
			StringBuilder sb = new StringBuilder();
			sb.append(doctor.getId());
			sb.append(',');
			sb.append(doctor.getName());
			sb.append(',');
			sb.append(doctor.getSpecialist());
			sb.append('\n');
			pw.write(sb.toString());
			pw.close();
		}
		
		
	}

}
