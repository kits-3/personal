package GUI;

import java.util.Scanner;

import BUS.Online_BUS;
import DAL.Online_DAL;
import DTO.Account_DTO;
import DTO.Patient_DTO;


import java.sql.ResultSet;
import java.sql.SQLException;
public class Online_GUI extends CreateTable {
	public void register_Account(Account_DTO dto) {

		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Online_DAL dal = new Online_DAL();
		Online_BUS bus = new Online_BUS();

		String email, username, password;

		System.out.print("\n" + createSpace() + "Fill out the form \n");
		System.out.print(createSpace());
		createRowForm();

		System.out.print("\n" + createSpace() + "*Email: ");
		email = scanner1.nextLine();
		System.out.print("\n" + createSpace() + "*Username: ");
		username = scanner2.nextLine();
		System.out.print("\n" + createSpace() + "*Password: ");
		password = scanner.nextLine();

		System.out.print(createSpace());
		createRowForm();

		if (bus.checkData(email, username, password)) {
			if (bus.checkLength(username, password)) {
				bus.getDataRegisterForm(dto, email, username, password);
				dal.insertData(dto);
			}
			else {
				System.err.println("\n" + createSpace() + "**Please username and password length > 6**");
				register_Account(dto);
			}
		} else {
			System.err.println("\n" + createSpace() + "**Please fill full the fields**");
			register_Account(dto);
		}
	}

	public void login_Account(Account_DTO dto) {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		String email, username, password;
		ChooseCondition ch = new ChooseCondition();
		Online_BUS bus = new Online_BUS();

		System.out.println("Want login, right?\n\t1. Yes \t2. No");

		if (ch.choose()) {
			System.out.print("\n" + createSpace() + "Log in form \n");
			System.out.print(createSpace());
			createRowForm();

			System.out.print("\n" + createSpace() + "*Username: ");
			username = scanner.nextLine();

			System.out.print("\n" + createSpace() + "*Password: ");
			password = scanner1.nextLine();

			bus.getDataLoginForm(dto, username, password);
			System.out.print(createSpace());
			createRowForm();
		}
	}
	// login failed method
	public void loginChecked(Account_DTO dto) {
		Online_DAL online_dal = new Online_DAL();
		CreateTable tb = new CreateTable();
		Online_GUI gui = new Online_GUI();

		if (online_dal.checkPermisstion(dto) == 0) {
			// login success
			function f = new function();
			Patient_DTO patient_info_dto = new Patient_DTO();
			System.err.println("\n" + tb.createSpace() + "Login success in user");
			f.showMenu();
			
		}
		if (online_dal.checkPermisstion(dto) == 1) {
			System.err.println("\n" + tb.createSpace() + "Login success in admin1");
			function f = new function();
			f.showMenu();
		}
		 else {
			// login success
			while (online_dal.checkPermisstion(dto) == -1) {
				System.err.println("\n" + tb.createSpace() + "Login failed!!!!!");
				login_Account(dto);
				loginChecked(dto);
			}
		}
	}
	public void online_GUI(Account_DTO dto) {
		ChooseCondition ch = new ChooseCondition();
		Online_DAL online_dal = new Online_DAL();

		System.out.println("Do you have an account?\n\t1. Register \t2. Login");
		if (ch.choose()) {
			register_Account(dto);
			online_dal.insertData(dto);
		} else {
			// Login
			login_Account(dto);
			loginChecked(dto);
		}
	}

	
	public static void main(String[] args) {
		Online_BUS bus = new Online_BUS();				
	}
	public void showRomInformation(Patient_DTO patient_info_dto) {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		Scanner scanner4 = new Scanner(System.in);
		Scanner scanner5 = new Scanner(System.in);
		Scanner scanner6 = new Scanner(System.in);
		Scanner scanner7 = new Scanner(System.in);
		Scanner scanner8 = new Scanner(System.in);
		Scanner scanner9 = new Scanner(System.in);
		Scanner scanner10 = new Scanner(System.in);
		
		
     	Online_DAL dal = new Online_DAL();	     	
		String  code_patient, name, gender,   address,  registrationDate, dischargeDate,  status;
		int id_card,age;
		long phone;

		System.out.print("\n" + createSpace() + "Fill out the form \n");
		System.out.print(createSpace());
		createRowForm();

		System.out.print("\n" + createSpace() + "*id_card: ");
		id_card = scanner1.nextInt();
		patient_info_dto.setId_card(id_card);
		
		System.out.print("\n" + createSpace() + "*code_patient: ");
		code_patient = scanner2.nextLine();
		patient_info_dto.setCode_patient(code_patient);
		
		System.out.print("\n" + createSpace() + "*name: ");
		name = scanner3.nextLine();
		patient_info_dto.setName(name);
		
		System.out.print("\n" + createSpace() + "*age: ");
		age = scanner4.nextInt();
		patient_info_dto.setAge(age);
		
		System.out.print("\n" + createSpace() + "*gender: ");
		gender= scanner5.nextLine();
		patient_info_dto.setGender(gender);
		
		System.out.print("\n" + createSpace() + "*phone: ");
		phone= scanner6.nextLong();
		patient_info_dto.setPhone(phone);
		
		System.out.print("\n" + createSpace() + "*address: ");
		address= scanner7.nextLine();
		patient_info_dto.setAddress(address);
		
		System.out.print("\n" + createSpace() + "*registrationDate: ");
		registrationDate= scanner8.nextLine();
		patient_info_dto.setRegistrationDate(registrationDate);
		
		System.out.print("\n" + createSpace() + "*dischargeDate: ");
		dischargeDate= scanner9.nextLine();
		patient_info_dto.setDischargeDate(dischargeDate);
		
		System.out.print("\n" + createSpace() + "* status: ");
		 status= scanner10.nextLine();
		 patient_info_dto.setStatus(status);
		 dal.insertDataPatientInfo(patient_info_dto);
		 
		System.out.print(createSpace());
		createRowForm();
		function f = new function();
		 f.yourChoose();
	}
	

}
