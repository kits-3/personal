package admin;

import java.util.Scanner;

public class Home {
	Scanner scanner = new Scanner(System.in);

	public void view() {

		try {
			boolean check_home = true;
			while (check_home) {
				System.out.println("1.Login");
				System.out.println("2.Sign in");
				System.out.println("3.Forget_pw");
				Login login_class = new Login();
				String login = scanner.next();
				if (login.equals("1")) {
					System.out.println("Gmail: ");
					String Gmail = scanner.next();
					System.out.println("Pass: ");
					Integer pass = scanner.nextInt();
					login_class.login(Gmail, pass);
					check_home = false;
				} else if (login.equals("2")) {
					check_home = false;
					login_class.sign();
				} else if (login.equals("3")) {
					check_home = false;
					login_class.forget_pw();
				} else {
					System.out.println("Please choose 1 - 3");
					check_home = true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}
}
