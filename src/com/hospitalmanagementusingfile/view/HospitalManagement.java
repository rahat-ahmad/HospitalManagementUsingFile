package com.hospitalmanagementusingfile.view;

import java.io.IOException;
import java.util.Scanner;


public class HospitalManagement {
	
	
	
	static {
		
		System.out.println("********Welcome to our hospital system management********");
		System.out.println("");
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String number;
		DoctorView doctorView = new DoctorView();
		
		Scanner sc = new Scanner(System.in);
	
		
		while(true) {
			System.out.println("Select the option which service you want to get");
			System.out.println("");
			
			System.out.println("Press 1 to add a doctor on the system");
			System.out.println("Press 2 to see all the doctor of the system");
			System.out.println("Press 3 to update a doctor info of the system");
			System.out.println("Press 4 to delete a doctor info of the system");
			
			
			number = sc.nextLine();
			
			switch(number){  
		    //Case statements  
		    case "1": doctorView.doctorAdd();  
		    break;  
		    case "2": doctorView.allDoctorView();
		    break;
		    case "3": doctorView.doctorUpdate();  
		    break; 
		    case "4": doctorView.doctorDelete();  
		    break;
		    //Default case statement  
		    default: System.out.println("Wrong entered");
		    }
			sc.close();
			
			
			
		}
		
		
		

	}

}
