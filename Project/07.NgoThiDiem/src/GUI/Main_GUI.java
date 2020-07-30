package GUI;

import java.util.Scanner;

import BUS.Online_BUS;
import DAL.Online_DAL;
import DTO.Account_DTO;
import DTO.Patient_DTO;

public class Main_GUI {

	public static void main(String[] args) {
		Online_DAL dal = new Online_DAL();
		
		Online_GUI online = new Online_GUI();
		Account_DTO dto = new Account_DTO();
		ChooseCondition ch = new ChooseCondition();
		Online_BUS bus = new Online_BUS();
		System.out.println("WELCOME TO PATIENT'S INFORMATION !!");
		System.out.println("\t1. Register \t2. Login");
		if(ch.choose()) {
			online.register_Account(dto);
			online.loginChecked(dto);
		}
		else {
			online.login_Account(dto);
			online.loginChecked(dto);
		}
}
	
}




