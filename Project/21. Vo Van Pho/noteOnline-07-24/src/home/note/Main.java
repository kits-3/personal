package home.note;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.note.entity.clTblNote;
import home.note.entity.clUser;
import home.note.repository.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Dao dao = new Dao();
	static String un;
	static String pw;
	static String ac = "yes";

//login()
	static void login() {
		do {
			System.out.print("Please enter your username: ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String un = scanner.nextLine();
			System.out.println("Check: " + un);
			System.out.print("Please enter your password: ");
			String pw = scanner.next();
			System.out.println("Check: " + pw);
			if (dao.chooseUser(un, pw) == true) {
				checkPreUser(un, pw);
			} else {
				System.out.println("Login failed!");
				System.out.println("Do you want to continue? yes or no ");
				ac = scanner.next();
				if (ac.equals("yes")) {
					ac = "no";
				} else {
					ac = "yes";
				}
			}
		} while (ac.equals("no"));
	}

//createAc
	static void createAc() {
		System.out.println("\t Create Account free! ");
		while (checkUser() == true) {
			System.out.println(" your username was exit ");
		}
		System.out.println("Please enter your password: ");
		String pw = scanner.next();
		dao.addUser(un, pw);
		System.out.println("You have successfully registered your account: " + un);
		System.out.println("Please try logging in: ");
		login();
	}

//checkUser	
	static boolean checkUser() {
		System.out.println("Please enter your username: ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		un = scanner.next();
		List<clUser> userlist = new ArrayList<clUser>();
		userlist = dao.findU();
		for (int i = 0; i < userlist.size(); i++) {
			if (un.equals(userlist.get(i).getUsername())) {
				return true;
			}
		}
		return false;
	}

//checkPreUser
	static void checkPreUser(String un, String pw) {
		String checkPU = dao.checkPremissionUser(un, pw);
		String id = saveID(un);
		String accept = "yes";
		if (checkPU.equals("admin")) {
			System.out.println("\t Tool admin: ");
			while (accept.equals("yes")) {
				toolAdmin();
				System.out.println("Do you want to continue? yes or no ");
				String ac = scanner.next();
				if (ac.equals("yes")) {
					accept = ac;
				} else if (ac.equals("no")) {
					accept = ac;
				}
			}
		} else if (checkPU.equals("user")) {
			while (accept.equals("yes")) {
				System.out.println("\t Optional notes: ");
				toolUser(id);
				System.out.println("Do you want to continue? yes or no ");
				String ac = scanner.next();
				if (ac.equals("yes")) {
					accept = ac;
				} else if (ac.equals("no")) {
					accept = ac;
				}
			}
		}
	}

//dataID
	static String saveID(String user) {
		List<clUser> userlist = new ArrayList<clUser>();
		userlist = dao.findU(user);
		for (int i = 0; i < userlist.size(); i++) {
			if (user.equals(userlist.get(i).getUsername())) {
				String id;
				id = userlist.get(i).getId();
				return id;
			}
		}
		return user;
	}

//toolAdmin
	static void toolAdmin() {
		List<clUser> userlist = new ArrayList<clUser>();
		userlist = dao.findU();
		System.out.println("select 1:view user, 2: add user, 3: delete note, 4: view infomation user with note ");
		int chon = scanner.nextInt();
		if (chon == 1) {
			// view user
			System.out.println("Show user table:");
			for (int i = 0; i < userlist.size(); i++) {
				System.out.print("ID: " + userlist.get(i).getId());
				System.out.println("\tUsername: " + userlist.get(i).getUsername());
				System.out.println("\tPassword: " + userlist.get(i).getPassword());
				System.out.print("\tDate reg: " + userlist.get(i).getDate_reg());
				System.out.println("\t Role: " + userlist.get(i).getRole());
			}
		} else if (chon == 2) {
			// add user
			while (checkUser() == true) {
				System.out.println(" your username was exit ");
			}
			System.out.println("Input password: ");
			String pw = scanner.next();
			dao.addUser(un, pw);
			System.out.println("added user: " + un + " password: " + pw);
		} else if (chon == 3) {
			// delete user
			System.out.println("show user table:");
			for (int i = 0; i < userlist.size(); i++) {
				System.out.print("ID: " + userlist.get(i).getId());
				System.out.println("\tUsername: " + userlist.get(i).getUsername());
			}
			System.out.println("Input id need delete: ");
			String idu = scanner.next();
			dao.deleteUser(idu);
			System.out.println("Deleted the user: " + idu);
		} else if (chon == 4) {
			// view manage note user
			dao.managVieUsNo();
		}
	}

//toolUser	
	static void toolUser(String id) {
		System.out.println("Choose 1: view, 2: add, 3: edit, 4: delete note");
		int chon = scanner.nextInt();
		if (chon == 1) {
			// view
			if (dao.checkCoIdNote(id)) {
				System.out.println("Input new note: ");
				dao.addNote(id);
			} else {
				listNote(id);
				viewNote(id);
			}
		} else if (chon == 2) {
			// add
			dao.addNote(id);
		} else if (chon == 3) {
			// edit
			if (dao.checkCoIdNote(id)) {
				System.out.println("Input new note: ");
				dao.addNote(id);
			} else {
				listNote(id);
				dao.updateNote(id);
			}
		} else if (chon == 4) {
			// delete
			if (dao.checkCoIdNote(id)) {
				System.out.println("Input new note: ");
				dao.addNote(id);
			} else {
				listNote(id);
				dao.deleteNote(id);
			}
		}
	}

//viewNote
	static void viewNote(String uid) {
		System.out.println("Input id need view connect: ");
		String idn = scanner.next();
		dao.viewIdNote(uid, idn);
	}

//listNote 
	static void listNote(String uid) {
		List<clTblNote> notelist = new ArrayList<clTblNote>();
		notelist = dao.findNote(uid);
		for (int i = 0; i < notelist.size(); i++) {
			System.out.print("STT: " + notelist.get(i).getId());
			System.out.print("\n\tContent Name: " + notelist.get(i).getNamec());
			System.out.println("\n\tEntry time: " + notelist.get(i).getDate_upd());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\t Welcome you to notes app!");
		System.out.print("Please choose 1 to login, select 2 to create an account: ");
		String nhap = scanner.next();
		if (nhap.equals("1")) {
			login();
		} else if (nhap.equals("2")) {
			createAc();
		}
	}

}
