package kits.personal.main;

import java.util.List;
import java.util.Scanner;

import kits.personal.dto.BookDto;
import kits.personal.entity.User;
import kits.personal.repository.BookRepository;
import kits.personal.repository.UserRepository;
import kits.personal.repository.impl.BookRepositoryImpl;
import kits.personal.repository.impl.UserRepositoryImpl;
import kits.personal.service.LibrarianService;
import kits.personal.service.UserService;
import kits.personal.service.impl.LibrarianServiceImpl;
import kits.personal.service.impl.UserServiceImpl;

public class LibraryMain {

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
		User user = null;
		Scanner scanner = new Scanner(System.in);
		while(user==null) {
			System.out.println("Please login to continue\n1.Login\n2.Sign in\n3.Leave");
			int loginChoose = Integer.parseInt(scanner.nextLine());
			if(loginChoose==3) break;
			if(loginChoose==1) {
				user = userService.executeLogin();
			}
			if(loginChoose==2) {
				userService.signIn();
				System.out.println("Please login to continue\n1.Login\n2.Sign in\n3.Leave");
				user = userService.executeLogin();
			}
		}
		
		while(user!=null) {
			int chooseService = 0;
			if(user.getRoleId()==1) {
				userService.showUserMenu();
				chooseService = Integer.parseInt(scanner.nextLine());
				switch (chooseService) {
				case 1:
					userService.showAllAvailable();
					boolean success = userService.borrow(user.getId());
					if(success==true) {
						break;
					} 
					while(success==false) {
						System.out.println("Borrow fail! Something was wrong. Try again? YES or NO");
						if(scanner.nextLine().equalsIgnoreCase("NO")) break;
						success = userService.borrow(user.getId());
					}
					break;
				case 2:
					userService.search();
					success = userService.borrow(user.getId());
					if(success==true) {
						break;
					} 
					while(success==false) {
						System.out.println("Borrow fail! Something was wrong. Try again? YES or NO");
						if(scanner.nextLine().equalsIgnoreCase("NO")) break;
						success = userService.borrow(user.getId());
					}
					break;
				case 3:
					List<BookDto> listBorrow = userService.showBorrowBook(user.getId());
					if(listBorrow.isEmpty()) {
						System.out.println("You don't borrow any book");
						break;
					}
					System.out.println("Do you want to return book? YES or NO");
					if(scanner.nextLine().equals("NO")) break;
					 success =userService.returnBook();
					while(success==false) {
						System.out.println("Return fail! Something was wrong. Try again? YES or NO");
						if(scanner.nextLine().equalsIgnoreCase("NO")) break;
						success = userService.returnBook();
					}
					break;
				case 4:
					System.out.printf("%-20s%-15s%-15s%s\n","Name","Password","IdNumber","PhoneNo");
					System.out.printf("%-20s%-15s%-15s%s\n",user.getName(),user.getPassword(),user.getIdNum(),user.getPhone());
					System.out.println();
					System.out.println("Do you want to update information? YES or NO");
					if(scanner.nextLine().equalsIgnoreCase("NO")) break;
					success = userService.updateUser(user);
					while(success==false) {
						System.out.println("Update fail! Something was wrong. Try again? YES or NO");
						if(scanner.nextLine().equalsIgnoreCase("NO")) break;
						success = userService.updateUser(user);
					}
					System.out.println("Update success");
					System.out.printf("%-20s%-15s%-15s%s\n","Name","Password","IdNumber","PhoneNo");
					System.out.printf("%-20s%-15s%-15s%s\n",user.getName(),user.getPassword(),user.getIdNum(),user.getPhone());
					break;
				default:
					break;
				}
			}
			
			if(user.getRoleId()==2) {
				
				
				
			}
			
			
			
			if(chooseService==5) break;
		}
		
		
		
		
		
		System.out.println("SEE YOU AGAIN!!!!!!!!!!");
		
		scanner.close();
	}

}
