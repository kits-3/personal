package Connection;

import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import Dao.UserDao;
import Dao.roleDao;
import Entity.roleDto;
import Entity.userDto;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	static userDto userDto = new userDto();
	static roleDto roleDto = new roleDto();
	static roleDao roleDao = new roleDao();
	static UserDao userDao = new UserDao();

	public static void main(String[] args) throws EmailException {
		String choose = null;
		boolean exitHome = false;
		boolean backHome = false;
		while (true) {
			showHome();
			choose = scanner.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose login");
				userDao.showLogin();
				break;
			case "2":
				System.out.println("choose Rigister");
				register();
				break;
			case "3":
				System.out.println("Forgot password");
				sendMail();
				break;
			case "0":
				System.out.println("exited!");
				exitHome = true;
				break;

			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if (exitHome && backHome) {
				break;
			}
		}

	}

	public static void showHome() {
		System.out.println("<====================================>");
		System.out.println("Dictionary System Demo Version 0.001");
		System.out.println(" ----------------------------------");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Forgot password");
		System.out.println("0. Exits");
		System.out.println(" ----------------------------------");
		System.out.print("Please choose: ");

	}

	public static void sendMail() throws EmailException {
		System.out.println("Plese enter your email to we check!");
		Email email = new SimpleEmail();
		userDto dto = userDao.findEmail();
		String sendTo = dto.getEmail();
		String password = dto.getPassWord();
		if (sendTo != null) {
			email.setHostName(MailConfig.HOST_NAME);
			email.setSmtpPort(MailConfig.SSL_PORT);
			email.setAuthenticator(new DefaultAuthenticator(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD));
			email.setSSLOnConnect(true);

			email.setFrom(MailConfig.APP_EMAIL);
			email.addTo(sendTo);
			email.setSubject("Send password from Dictionary");
			email.setMsg("Your password of you is : " + password);
			email.send();
			System.out.println("Send mail success");
			System.out.println("Your password was send to your box email of you ! please check your email !");
		} else {
			System.out.println("username not exist!");
		}

	}

	public static void register() {
		boolean exist = false;
		while (true) {
			System.out.println("-------------Register User------------");
			System.out.println("Please enter your username");
			String userName = scanner.nextLine();
			if (userDao.checkUserExist(userName)) {
				exist = true;
			}
			if (exist) {
				break;
			}

			System.out.println("-------------End Register User------------");
			System.out.println("Please choose another username ");
		}

	}

}
