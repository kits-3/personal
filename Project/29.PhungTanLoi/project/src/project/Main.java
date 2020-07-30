package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import dao.StudentDao;
import dao.UserDao;
import dto.Student;
import dto.User;

public class Main {

	public static void main(String[] args) {
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		UserDao userDao = new UserDao();
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Do You Have Account?");
			System.out.println("1.Yes------2.No");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				System.out.print("User: ");
				String users = scanner.next();
				System.out.print("Password: ");
				String pass = scanner.next();
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------");
				boolean status = userDao.validate(users, pass);
				if (status == true) {
					System.out.println("Login Sucess!!!");
					boolean roll = userDao.roll(users);
					if (roll == true) {
						System.out.println("You Are Admin!!!");
						System.out.println("1.User Management-------2.Student Management");
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------");
						int choose4 = scanner.nextInt();
						switch (choose4) {
						case 1:
							int choose1;
							do {
								showMenuUser();
								choose1 = scanner.nextInt();
								switch (choose1) {
								case 1:
									user.input1();
									userDao.updateRoll(user);
									break;
								case 2:
									System.out.print("Input Id To Delete: ");
									int id = scanner.nextInt();
									userDao.delete(id);
									break;
								case 3:
									userDao.view();
									break;
								case 4:
									System.out.println("Input Name To Search:");
									String idString = scanner.next();
									userDao.getUserByName(idString);
									break;
								case 5:
									userDao.outPut();
									break;
								case 6:
									System.out.println("Exit!!!");
									break;
								default:
									System.err.println("Fail!!!");
									break;
								}
							} while (choose1 != 6);
							break;
						case 2:
							int choose3;
							do {
								showMenuStudent();
								choose3 = scanner.nextInt();
								switch (choose3) {
								case 1:
									student.input();
									studentDao.save(student);
									break;
								case 2:
									student.input1();
									studentDao.update(student);
									break;
								case 3:
									studentDao.view();
									break;
								case 4:
									System.out.print("Input Id To Delete: ");
									int idDel = scanner.nextInt();
									studentDao.delete(idDel);
									break;
								case 5:
									System.out.println("Input Id To Search:");
									int idSearch = scanner.nextInt();
									studentDao.getStudentByRollno(idSearch);
									break;
								case 6:
									System.out.println("Input Name To Search:");
									String idString = scanner.next();
									studentDao.getStudentByName(idString);
									break;
								case 7:
									studentDao.due();
									break;
								case 8:
									user.input2();
									userDao.update(user);
									System.out.println("Update Successful!!!!");
									break;
								case 9:
									studentDao.outPut();
									break;
								case 10:
									System.err.println("Exit!!!");
									break;
								default:
									System.err.println("Fail!!!");
									break;
								}
							} while (choose3 != 10);
							break;
						default:
							System.err.println("Again!!!");
							break;
						}
					} else {
						System.out.println("You Are User!!!");
						System.out.println("---------Student Management---------");
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------");
						int choose3;
						do {
							showMenuStudent();
							choose3 = scanner.nextInt();
							switch (choose3) {
							case 1:
								student.input();
								studentDao.save(student);
								break;
							case 2:
								student.input1();
								studentDao.update(student);
								break;
							case 3:
								studentDao.view();
								break;
							case 4:
								System.out.print("Input Id To Delete: ");
								int idDel = scanner.nextInt();
								studentDao.delete(idDel);
								break;
							case 5:
								System.out.println("Input Id To Search:");
								int idSearch = scanner.nextInt();
								studentDao.getStudentByRollno(idSearch);
								break;
							case 6:
								System.out.println("Input Name To Search:");
								String idString = scanner.next();
								studentDao.getStudentByName(idString);
								break;
							case 7:
								studentDao.due();
								break;
							case 8:
								user.input2();
								userDao.update(user);
								System.out.println("Update Successful!!!!");
								break;
							case 9:
								studentDao.outPut();
								break;
							case 10:
								System.err.println("Exit!!!");
								break;
							default:
								System.err.println("Fail!!!");
								break;
							}
						} while (choose3 != 10);
					}
				} else {
					System.err.println("Id Or Password Wrong!!!");
					System.err.println("Please Input Again!!!");
				}
				break;
			case 2:
				System.out.println("Register, Please!!!"); // REGISTER ACCOUNT
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------");
				user.input();
				userDao.add(user);
				System.out.println("------------------------");
				System.out.println("Register Successfull!!!");
				break;
			default:
				System.err.println("Fail!!!");
				break;
			}

		}
	}

	public static void showMenuUser() {
		System.out.println("1.Update Rollname User------2.Delete User------3.View User");
		System.out.println("4.Search User By Name------5.Print to txt------6.Exit");
		System.out.print("Choose:  ");
	}

	public static void showMenuStudent() {
		System.out.println(
				"1.Add Student------2.Update Student------3.View Student------4.Delete Student------5.Search By Id");
		System.out.println(
				"6.Search By Name------7.View Student Debt------8.Edit Your Account------9.Print to txt------10.Exit");
		System.out.print("Choose:  ");
	}
}
