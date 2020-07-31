package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.UserDao;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private String contactno;
	private String roll_name;

	public User() {
		super();
	}

	public User(int id, String name, String password, String email, String contactno, String roll_name) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactno = contactno;
		this.roll_name = roll_name;
	}

	public String getRoll_name() {
		return roll_name;
	}

	public void setRoll_name(String roll_name) {
		this.roll_name = roll_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", contactno="
				+ contactno + ", roll_name=" + roll_name + "]";
	}

	public void display() {
		System.out.println(toString());
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input Name: ");
		while (true) {
			name = scanner.next();
			boolean isFind = UserDao.checkLoop(name);
			if (isFind != true) {
				break;
			} else {
				System.err.println("Input Other Name. Name is used!!!");
			}
		}

		System.out.println("Input Password: ");
		password = scanner.next();
		System.out.println("Input Email: ");
		email = scanner.next();
		while (!email.contains("@") || email.contains(" ")) {
			System.err.println("Input email again!!!!");
			email = scanner.next();
		}
		System.out.println("Input Contactno: ");
		contactno = scanner.next();
	}

	public void input1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input Id to Update: ");
		id = scanner.nextInt();
		System.out.println("Input Rollname: ");
		roll_name = scanner.next();
	}
	public void input2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input Name: ");
		name = scanner.next();
		System.out.println("Input Password: ");
		password = scanner.next();
		System.out.println("Input Email: ");
		email = scanner.next();
		while (!email.contains("@") || email.contains(" ")) {
			System.err.println("Input email again!!!!");
			email = scanner.next();
		}
		System.out.println("Input Contactno: ");
		contactno = scanner.next();
	}
}
