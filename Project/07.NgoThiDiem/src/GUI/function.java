package GUI;

import java.util.Scanner;

import DTO.Patient_DTO;

public class function {
	public void yourChoose() {
		int a;
		Scanner scan = new Scanner(System.in);
		Patient_DTO patient_info_dto = new Patient_DTO();
		Online_GUI g = new Online_GUI();
		System.out.print("\t\n Your choose : ");
		do {
//			showMenu();
			a = scan.nextInt();
			switch (a) {
			case 1:
				g.showRomInformation(patient_info_dto);
				break;
			case 2:
				shearchByName();
				break;
			case 3:
				shearchById_card();
				break;
			case 4:
				setHeathStatus();
				break;
			case 5:				
				break;
			case 6:
				break;
			case 7:
				showMenu();
				System.out.println("exit");
				break;
			default:
				System.out.println("input failed!");
				break;

			}

		} while (a != 7);
		
	}

	static void showMenu() {
		Patient_DTO patient_info_dto = new Patient_DTO();
		Online_GUI g = new Online_GUI();
		function f = new function();
		System.out.println("\n\n**FUNCTION*");
		System.out.println("1.make a list of all patient information");
		System.out.println("2.Search patient information by name");
		System.out.println("3.Search patient information by identity card");
		System.out.println("4.health status setting");
		System.out.println("5.shows the list of patients being monitored");
		System.out.println("6.Show list of patients discharged");
		System.out.println("7.exit");
		System.out.println("choose");			
		f.yourChoose();			
	}
		
	// 2. search name
	private static void shearchByName() {
		Scanner cannerr = new Scanner(System.in);
		System.out.println("Enter name to Shearch:");
		String name = cannerr.nextLine();		
	}

	// search id_card 3
	private static void shearchById_card() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id_card to search: ");
		String id_card = scanner.nextLine();
	}

	// 4.health status setting
	private static void setHeathStatus() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter id_card to search: ");
		String id_card = scan.nextLine();	
	}	
}
