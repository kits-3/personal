package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entity.EmployeeEntity;
import config.ConnectionFactory;

public class AccountRepositoryImpl implements AccountRepository {

	@Override
	public boolean login() {
		Scanner scan = new Scanner(System.in);
		boolean isExist = true;
		System.out.println("*=====Login=====*");
		while (true) {
			System.out.println("Username: ");
			String input = scan.nextLine();
			System.out.println("Password");
			String input1 = scan.nextLine();
			isExist(input, input1);
			break;
		}
		return isExist;
	}

	public boolean isExist(String username, String password) {
		int Role_id = 1;
		try {
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employee_management", "root",
					"123");
			Statement stmt = con.createStatement();
			String SQL = "SELECT * FROM account Where username='" + username + "'" + "and password = '" + password
					+ "'";
			ResultSet rs = stmt.executeQuery(SQL);
			if (rs.next()) {
				int id = rs.getInt(Role_id);
				isAdmin(id);
			} else {
				System.out.println("Login failed - " + " " + "please insert again !!!");
				return login();
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return false;
	}

	public static void showMenu() {
		System.out.println("----ADMIN----");
		System.out.println("1. Show employee list");
		System.out.println("2. Create new employee");
		System.out.println("3. Update Employee's Information");
		System.out.println("4. Delete Employee's Information");
		System.out.println("5. Exit");
		System.out.println("Please select your choice: ");
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public EmployeeEntity selectByID(int id) {
		Connection connection1 = null;
		PreparedStatement stmt1 = null;
		ResultSet rs1 = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employee_management", "root",
					"123");
			Statement stmt = con.createStatement();
			String SQL = " SELECT * FROM employee WHERE Emp_id=?";

			connection1 = getConnection();

			stmt1 = connection1.prepareStatement(SQL);
			stmt1.setInt(1, id);
			rs1 = stmt1.executeQuery(); // Select

			while (rs1.next()) {
				EmployeeEntity cus = new EmployeeEntity();
				cus.setEmp_id(rs1.getInt("Emp_id"));
				cus.setEmp_name(rs1.getString("Emp_name"));
				cus.setEmail(rs1.getString("Email"));
				cus.setPhone(rs1.getString("Phone"));
				cus.setSalary(rs1.getInt("Salary"));
				cus.setAccount_Id(rs1.getInt("Account_Id"));
				return cus;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean isAdmin(int id) {

		if (id == 1) {
			showMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			EmployeeRepository emp = new EmployeeRepositorylmpl();
			try {
				switch (choice) {
				case 1:
					List<EmployeeEntity> emplist = new ArrayList<>();
					emplist = emp.findAll();

					System.out.println("----------------------------------------------------------------------");
					for (EmployeeEntity empentity : emplist) {

						System.out.println(" " + empentity.getEmp_id() + "  | " + empentity.getEmp_name() + "    | "
								+ empentity.getEmail() + " | " + empentity.getPhone() + " | " + empentity.getSalary());
					}
					System.out.println("----------------------------------------------------------------------");
					isAdmin(id);
					break;
				case 2:

					System.out.println("**Add new user**");
					System.out.println("Name");
					String name = scan.next();
					System.out.println("Mail");
					String mail = scan.next();
					System.out.println("Phone");
					String Phone = scan.next();
					System.out.println("Salary");
					int Salary = scan.nextInt();
					System.out.println("Account_Id");
					int Account_Id = scan.nextInt();

					Scanner input3 = new Scanner(System.in);
					EmployeeEntity empentity = new EmployeeEntity(name, mail, Phone, Salary, Account_Id);
					emp.add(empentity);
					isAdmin(id);
					break;
				case 3:
					List<EmployeeEntity> emplist1 = new ArrayList<>();
					emplist = emp.findAll();

					System.out.println("----------------------------------------------------------------------");
					for (EmployeeEntity empentity1 : emplist) {

						System.out.println(" " + empentity1.getEmp_id() + "  | " + empentity1.getEmp_name() + "    | "
								+ empentity1.getEmail() + " | " + empentity1.getPhone() + " | "
								+ empentity1.getSalary());
					}
					System.out.println("----------------------------------------------------------------------");
					System.out.println("please choose user for updating");
					int id1 = scan.nextInt();
					EmployeeEntity employeeEntity = selectByID(id1);
					System.out.println(" " + employeeEntity.getEmp_id() + "  | " + employeeEntity.getEmp_name()
							+ "    | " + employeeEntity.getEmail() + " | " + employeeEntity.getPhone() + " | "
							+ employeeEntity.getSalary());
					System.out.println("Name");
					name = scan.next();
					System.out.println("Mail");
					mail = scan.next();
					System.out.println("Phone");
					Phone = scan.next();
					System.out.println("Salary");
					Salary = scan.nextInt();
					System.out.println("Account_Id");
					Account_Id = scan.nextInt();
					
					break;
				case 4:
					System.out.println(" select 4");
					break;
				case 5:
					System.out.println(" select 5");
					return login();
				default:
					System.out.println("wrong input , please choose 1->5: ");

					isAdmin(id);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		} else {
			while (true) {
				System.out.println("----User----");
				System.out.println("1. View Your Choice");
				System.out.println("2. Exit");
				System.out.println("Please select your choice");
				Scanner scan = new Scanner(System.in);
				String choice1 = scan.nextLine();
				if (choice1.equals("1")) {
					System.out.println(" select 1");
				} else {
					System.out.println("wrong input , please choose 1->5: ");

				}

			}

		}
		return false;

	}

//	@Override
//	public boolean isExist(String username, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeEntity findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
