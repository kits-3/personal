package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import BUS.Offline_BUS;
import BUS.Online_BUS;
import DAL.Offline_DAL;
import DAL.Online_DAL;
import DTO.Account_DTO;
import DTO.Customer_DTO;
import DTO.Room_book_DTO;
import DTO.Room_info_DTO;

public class Offline_GUI {
	public int restID;

	public void showInformation(Room_info_DTO room_info_dto, Customer_DTO c_dto, Account_DTO ac_dto) {
		Online_DAL online_dal = new Online_DAL();
		Online_BUS bus = new Online_BUS();
		CreateTable tb = new CreateTable();
		Offline_BUS offbus = new Offline_BUS();
		Offline_DAL dal = new Offline_DAL();

		chooseCondition ch = new chooseCondition();
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);

		ResultSet result = online_dal.roomInformation(room_info_dto);
		bus.getRoomIformation(room_info_dto);

		System.out.print("\tRoom information table");
		tb.createRowForm();

		System.err.print("\n\n" + tb.createSpaceSmall() + "ID");
		System.err.print(tb.createSpaceSmall() + "Number room");
		System.err.print(tb.createSpaceSmall() + "Style of room");
		System.err.print(tb.createSpaceQuite() + "Price");
		System.err.print(tb.createSpaceQuite() + "Characteristics");
		System.err.println(tb.createSpaceQuite() + "Status");
		try {
			while (result.next()) {
				System.out.print(tb.createSpaceSmall() + room_info_dto.roomId[result.getRow()]);
				System.out.print(tb.createSpaceSmall() + room_info_dto.numberRoom[result.getRow()]);
				System.out.print(
						tb.createSpaceSmall() + tb.createSpaceSmall() + room_info_dto.typeOfRoom[result.getRow()]);
				System.out.print(
						tb.createSpaceQuite() + tb.createSpaceSmall() + room_info_dto._price[result.getRow()] + "$");
				System.out.print(tb.createSpaceQuite() + room_info_dto.characteristics[result.getRow()]);
				System.out.println(tb.createSpaceSmall() + room_info_dto.status[result.getRow()]);

			}
			System.out.println("\nAction: 1. Check out room \t 2. Exist");
			if (ch.choose()) {
				// checkout room
				int a;
				do {
					System.out.print("Number room checkout: ");
					a = scanner.nextInt();
					room_info_dto.setNumber_room(a);
				} while (offbus.checkNumberRoom(a));
				dal.updateStatus(a);
			} else {
				// exist
				areaAdmin1();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void areaAdmin1() {
		Scanner s1 = new Scanner(System.in);
		chooseCondition ch = new chooseCondition();
		Account_DTO ac_dto = new Account_DTO();
		Online_GUI gui = new Online_GUI();
		Room_info_DTO room_info_dto = new Room_info_DTO();
		Customer_DTO c_dto = new Customer_DTO();
		System.out.println("\n\n\t1. Book room \t2. Check out room \t3. Report \t4. Exist");// report
		int a;
		System.out.print("\tYour choose: ");
		a = s1.nextInt();
		if (a == 1) {
//			gui.showRomInformation(room_info_dto,c_dto,ac_dto);
			showRomInformationAdmin1(room_info_dto, c_dto, ac_dto);
		} else if (a == 2) {
			// checkout room
			showInformation(room_info_dto, c_dto, ac_dto);
		} else if (a == 3) {
			// report
			enterFileName();
		} else if (a == 4) {
			Online_GUI online = new Online_GUI();
			System.err.println("\t**You logged out!!");
			online.online_GUI(ac_dto);
		}
	}

	// show room info admin 1
	public void showRomInformationAdmin1(Room_info_DTO room_info_dto, Customer_DTO c_dto, Account_DTO ac_dto) {
		Online_DAL online_dal = new Online_DAL();
		Online_BUS bus = new Online_BUS();
		CreateTable tb = new CreateTable();
		Online_GUI g = new Online_GUI();

		chooseCondition ch = new chooseCondition();
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);

		ResultSet result = online_dal.roomInformation(room_info_dto);
		bus.getRoomIformation(room_info_dto);

//		System.out.print("\n");
//		tb.createRowForm();
		System.out.print("\tRoom information table");
		tb.createRowForm();

		System.err.print("\n\n" + tb.createSpaceSmall() + "ID");
		System.err.print(tb.createSpaceSmall() + "Number room");
		System.err.print(tb.createSpaceSmall() + "Style of room");
		System.err.print(tb.createSpaceQuite() + "Price");
		System.err.print(tb.createSpaceQuite() + "Characteristics");
		System.err.println(tb.createSpaceQuite() + "Status");
		try {
			while (result.next()) {
				System.out.print(tb.createSpaceSmall() + room_info_dto.roomId[result.getRow()]);
				System.out.print(tb.createSpaceSmall() + room_info_dto.numberRoom[result.getRow()]);
				System.out.print(
						tb.createSpaceSmall() + tb.createSpaceSmall() + room_info_dto.typeOfRoom[result.getRow()]);
				System.out.print(
						tb.createSpaceQuite() + tb.createSpaceSmall() + room_info_dto._price[result.getRow()] + "$");
				System.out.print(tb.createSpaceQuite() + room_info_dto.characteristics[result.getRow()]);
				System.out.println(tb.createSpaceSmall() + room_info_dto.status[result.getRow()]);

			}
			System.out.println("\nAction: 1. Book room \t 2. Exist");
			int a;
			if (ch.choose()) {
				// book room
				do {
					System.out.print("\tNumber room you want book:");
					a = scanner.nextInt();
					room_info_dto.setRoomN(a);
					float price = bus.searchPrice(a);
					room_info_dto.setPrice(price);
				} while (bus.checkBookRoomNumberUser(room_info_dto, a));
				if (bus.checkBookRoomEmptyUser(room_info_dto, a)) {
					System.err.print("\n\n\t**Room full, please choose again!\n\n");
					showRomInformationAdmin1(room_info_dto, c_dto, ac_dto);
				} else {
					// personal information
					System.out.println("\tYou booked number room: " + a);
					System.out.println("new id: " + restID);
					System.out.println("\n\tPlease fill your personal information: ");
					g.formPersonInfo(c_dto);
					online_dal.insertPersonalInfo(c_dto, ac_dto, restID);
					// table detail book room
					System.out.println("\tPlease fill table below:");
					Room_book_DTO b_dto = new Room_book_DTO();
					g.formRoomBook(b_dto, room_info_dto, c_dto);
				}
			} else {
				// log out
				Offline_GUI off = new Offline_GUI();
				off.areaAdmin1();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterFileName() {
		Scanner s2 = new Scanner(System.in);
		Online_DAL dal = new Online_DAL();
		String fileName;
		System.out.print("\tEnter file name: ");
		fileName = s2.nextLine();
		dal.reportFileExcel(fileName);
	}

	public void offline_GUI() {
		Account_DTO ac_dto = new Account_DTO();
		Online_GUI gui = new Online_GUI();

		Room_info_DTO room_info_dto = new Room_info_DTO();
		Customer_DTO c_dto = new Customer_DTO();
		gui.login_Account(ac_dto);
		gui.loginChecked(ac_dto);
		areaAdmin1();
	}
}
