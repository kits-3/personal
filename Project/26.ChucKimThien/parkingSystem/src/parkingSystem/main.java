package parkingSystem;

import java.util.Scanner;

import parkingSystem.entity.user;
import parkingSystem.repository.loginRepository;
import parkingSystem.repository.loginRepositoryImpl;
import parkingSystem.repository.siginRepositoryImpl;
import parkingSystem.repository.signinRepository;

public class main {

	public static void main(String[] args) {
			loginRepository loginUser = new loginRepositoryImpl();
			signinRepository signinUser = new siginRepositoryImpl();
			
			System.out.println("1.Login || 2.Sign in");
			Scanner scan = new Scanner(System.in);
			String choose = scan.next();
			
			switch(choose)
			{
			case "1":
				loginUser.login();
				
				break;
			case "2":
				signinUser.signin();
				loginUser.login();
				break;
			default:
				break;
			}			
	}

}

	