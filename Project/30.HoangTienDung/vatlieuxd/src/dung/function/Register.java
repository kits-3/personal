package dung.function;

import java.util.Scanner;

import dung.connect.Dao;
import dung.connect.LogIn;
import dung.dto.Info;
import dung.dto.User;

public class Register {
	Scanner scan = new Scanner(System.in);
	LogIn logIn = new LogIn();
	Dao dao = new Dao();

	public User register() {
		boolean check = true;
		String a;
		do {
			System.out.println("input info user:");
			System.out.print("user:");
			a = scan.next();
			check = logIn.checkDuplicate(a);
			if (check == true) {
				System.out.println("User used!!!");
			}
		} while (check);
		System.out.print("Password:");
		String b = scan.next();
		User regis = new User(a,b);
		return regis;
	}

	public void addInfo(User user) {
		Info info = new Info();
		info.setUsers_id(user.getId());
		System.out.print("input name:");
		scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String name = scan.nextLine();
		System.out.print("input address:");
		scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String address = scan.nextLine();
		System.out.print("input phone:");
		String phone = scan.next();
		info.setName(name);
		info.setAddress(address);
		info.setPhone(phone);
		info.setId(0);
		dao.newInfo(info,user);
	}

}
