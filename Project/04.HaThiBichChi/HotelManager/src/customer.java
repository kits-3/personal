/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class customer extends User {

	public customer() {
	}

	public customer(int id, String name, String password, String email, String fullname, String role) {
		super(id, name, password, email, fullname, role);
	}

	public static Connection connection = null;
	public static PreparedStatement ptmt = null;
	public ResultSet resultSet = null;

	private static Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	String input3, inDate, outDate;

	public void book() {
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			Scanner keyboard = new Scanner(System.in);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String regex = "\\d?\\d\\D+\\d?\\d\\D+\\d\\d\\d\\d";

			System.out.println("\n========================");
			System.out.println("Booking menu");

			boolean error1;
			do {
				error1 = true;
				System.out.print("Input check-in date: ");
				inDate = keyboard.nextLine();

				if (inDate.matches(regex)) {
					String[] parts = inDate.split("(\\D+)");
					inDate = parts[2] + "-" + parts[1] + "-" + parts[0];
				} else {
					System.out.println("Wrong date format. Please retry.");
					error1 = false;
				}

			} while (!error1);

			boolean error2;
			do {

				error2 = true;
				System.out.print("Input check-out date: ");
				outDate = keyboard.nextLine();

				if (outDate.matches(regex)) {
					String[] parts = outDate.split("(\\D+)");
					outDate = parts[2] + "-" + parts[1] + "-" + parts[0];

				} else {
					System.out.println("Wrong date format. Please retry.");
					error2 = false;
				}
			} while (!error2);
			String type = "";
			System.out.println("Choose a type of room:");
			System.out.println("1/ King-sized");
			System.out.println("2/ Queen-sized");
			System.out.println("3/ Suite");
			System.out.println("4/ Any");
			System.out.print("Your choice: ");
			int inType = keyboard.nextInt();
			switch (inType) {
			case 1:
				type = "king";
				break;
			case 2:
				type = "queen";
				break;
			case 3:
				type = "suite";
				break;
			default:
				type = "*";
				break;
			}

			System.out.println("\n========================");
			System.out.println("Available rooms from " + inDate + " to " + outDate);
			System.out.println("N---Number---Price---Type---Status");

			book book = new book();
			int t = 0;
			for (room room1 : book.showAvailableRoom(inDate, outDate, type)) {
				;
				t += 1;
				System.out.println(
						t + "---" + room1.getNumber() + "-------" + room1.getPrice() + "----" + room1.getType());
			}
			int inInt = 0;
			String input = "";
			boolean error;
			do {
				error = false;
				System.out.print("Choose the number of the room you want to book: ");
				input = keyboard.nextLine();

				if (input.matches("\\d+")) {
					inInt = Integer.valueOf(input) - 1;
					if (inInt < 0 || inInt >= t) {
						error = true;
						System.out.println("Please enter a number on the list.");
					}
				} else {
					error = true;
					System.out.println("Please enter a number.");
				}
			} while (error);

			room room2 = book.showAvailableRoom(inDate, outDate, type).get(inInt);
			String sql = "insert into book(idUser, idRoom, dateIn, dateOut) values(" + this.getId() + ", "
					+ room2.getId() + ", '" + inDate + "', '" + outDate + "');";
			try {
				statement.executeUpdate(sql);
				System.out.println("Booking successful");
				System.out.println("Personal Information");
				System.out.println("Full name: " + User.user.getFullname() + "\nEmail: " + User.user.getEmail());
				System.out.println("Input phone number: ");
				input3 = keyboard.nextLine();
				System.out.println("Please check booking information again");
				System.out.println("CHIDOE HOTEL");
				System.out.println("========================");
				System.out.println("Your full name: " + getFullname() + "\nEmail: " + getEmail() + "\nPhone number: "
						+ input3 + "\nCheck-in date: " + inDate + "\nCheck-out date: " + outDate + "\nNumber room: "
						+ room2.getNumber());
				System.out.println("Want to booking? Y/N");
				String input4 = keyboard.nextLine();
				if (input4.equals("Y")) {
					System.out.println(
							"Online ticket/Bill will be sent through your mail and booking information will be sent to your number\nPlease transfer money soon to give more promotion.Thks");

				} else {
					System.out.print("Quit");
				}
				receiptDetail(room2.getNumber());

			} catch (Exception e) {
				System.out.println("Update failure");
			}

			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void receiptDetail(String nummber) {
		try {

			StringBuffer buffer = new StringBuffer();
			room room2 = new room();
			String receiptUrl = "D:/clonesource/curriculum/day 2 - flowchart, variable , if ,switch/example/easy/Maria/reciept.txt";
			FileOutputStream fo = new FileOutputStream(receiptUrl);
			buffer.append("=========================Receipt=========================\n");
			buffer.append(String.format("%-10s %-10s \n", "Full name:", User.user.getFullname()));
			buffer.append(String.format("%-10s %-10s \n", "Email:", User.user.getEmail()));
			buffer.append(String.format("%-10s %-10s \n", "Phone number:", input3));
			buffer.append(String.format("%-10s %-10s \n", "Check-in Date:", inDate));
			buffer.append(String.format("%-10s %-10s \n", "Check-out Date:", outDate));
			buffer.append(String.format("%-10s %-10s \n", "Room number:", room2.getNumber()));
			byte[] bytes = buffer.toString().getBytes();
			fo.write(bytes);

			fo.flush();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}