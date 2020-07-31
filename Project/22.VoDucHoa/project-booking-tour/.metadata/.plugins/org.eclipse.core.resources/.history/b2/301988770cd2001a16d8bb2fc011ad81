package pj.tour;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import pj.tour.entity.AccountEntity;
import pj.tour.entity.TourEntity;
import pj.tour.entity.UserEntity;
import pj.tour.repository.AdminRepository;
import pj.tour.repository.AdminRepositoryImpl;
import pj.tour.repository.UserRepository;
import pj.tour.repository.UserRepositoryImpl;
import pj.tour.repository.account.AccountRepository;
import pj.tour.repository.account.AccountRepositoryImpl;
import pj.tour.repository.account.LoginAccount;
import pj.tour.repository.booking.BookingRepositoryImpl;
import pj.tour.repository.booking.BookingTour;

public class Main {
	static boolean check = true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserRepository userReponsitory = new UserRepositoryImpl();
		Scanner input = new Scanner(System.in);				
		
		AccountEntity account = new AccountEntity();
		TourEntity tour = new TourEntity();
		List<AccountEntity> listAccount = new ArrayList<AccountEntity>();		
		AccountRepository accountRepository = new AccountRepositoryImpl() ;
		LoginAccount loginaccount = new AccountRepositoryImpl();
		AdminRepository adminRepository = new AdminRepositoryImpl();
		BookingTour bookingtour = new BookingRepositoryImpl();
		
		String chooseAuthority ;
		System.out.println("1.Sign up | 2. Log in");
		chooseAuthority = input.next();		
		switch (chooseAuthority) {
		case "1":
			accountRepository.registerAccount(account);	
			loginaccount.logInAccount(account);
			break;
		case "2":
			String checkRole = loginaccount.logInAccount(account);
			if (checkRole.equals("admin")) {				
				System.out.println("1.addTour -- 2.deleteTour -- 3.updateTour -- 4.deleteUser");
				String chooseOption = input.next();
//				String continute1 = input.next();
					switch (chooseOption) {
					case "1":
						do {
							adminRepository.addTour(tour);
							System.out.println("want to continute! 1.yes --- 2.no");
							String continute1 = input.next();
							if (continute1.equals("1")) {
								check = true;
							}else if(continute1.equals("2")){
								adminRepository.findTour();
								check = false;
							}
						} while (check);					
						break;
					case "2":
						do {
							adminRepository.deleteTour(tour);
							System.out.println("want to continute! 1.yes --- 2.no");
							String continute2 = input.next();
							if (continute2.equals("1")) {
								check = true;
							}else {
								
								check = false;
							}
						} while (check);
						
						break;
					case "3":
						do {
							adminRepository.updateTour(tour);
							System.out.println("want to continute! 1.yes --- 2.no");
							String continute3 = input.next();
							if (continute3.equals("1")) {
								check = true;
							}else {
								
								check = false;
							}
						}while(check);
						break;
					case "4":
						do {
							adminRepository.deleteUser();
							System.out.println("want to continute! 1.yes --- 2.no");
							String continute4 = input.next();
							if (continute4.equals("1")) {
								check = true;
							}else {
								
								check = false;
							}
						}while(check);
						break;
					default:
						break;
					}
				
			}else if (checkRole.equals("user")) {
				System.out.println("1.addInfo -- 2.findTour");
				String chooseOption = input.next();
				switch (chooseOption) {
				case "1":
					
					break;
				case "2":	
						userReponsitory.findTour();			
						bookingtour.bookingTour();
					break;
				default:
					break;
				}
			}
			break;
		default:
			break;
		}
		
//		accountRepository.registerAccount(account);	

	}

}
