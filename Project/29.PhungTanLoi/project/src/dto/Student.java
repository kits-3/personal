package dto;

import java.util.Scanner;

public class Student {
	private int rollno;
	private String name;
	private String email;
	private String course;
	private int fee;
	private int paid;
	private int due;
	private String address;
	private String contactno;

	public Student() {
		super();
	}

	public Student(int rollno, String name, String email, String course, int fee, int paid, int due, String address,
			String city, String country, String contactno) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", email=" + email + ", address=" + address
				+ ",contactno=" + contactno + ", course=" + course + ", fee=" + fee + ", paid=" + paid + ", due=" + due
				+ "]";
	}

	public void display() {
		System.out.println(this);
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input Name: ");
		name = scanner.next();
		System.out.println("Input Email: ");
		email = scanner.next();
		while(!email.contains("@")||email.contains(" ")) {
			System.err.println("Input email again!!!!");
			email=scanner.next();
		}
		System.out.println("Input Contactno: ");
		contactno = scanner.next();
		System.out.println("Input Address: ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		address = scanner.nextLine();
		System.out.println("Input Course: ");
		course = scanner.next();
		System.out.println("Input Fee: ");
		fee = scanner.nextInt();
		System.out.println("Input Paid: ");
		paid = scanner.nextInt();
		due = fee - paid;
	}
	public void input1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input id to update: ");
		rollno = scanner.nextInt();
		System.out.println("Input Name: ");
		name = scanner.next();
		System.out.println("Input Email: ");
		email = scanner.next();
		while(!email.contains("@")||email.contains(" ")) {
			System.err.println("Input email again!!!!");
			email=scanner.next();
		}
		System.out.println("Input Contactno: ");
		contactno = scanner.next();
		System.out.println("Input Address: ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		address = scanner.nextLine();
	}
}
