package kits.personal.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kits.personal.dto.BookDto;
import kits.personal.entity.User;
import kits.personal.service.LibrarianService;
import kits.personal.service.UserService;
import kits.personal.service.impl.LibrarianServiceImpl;
import kits.personal.service.impl.UserServiceImpl;

public class LibraryMain {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		LibrarianService librarianService = new LibrarianServiceImpl();
		User user = null;
		boolean success = false;
		String inputChoose;
		Scanner scanner = new Scanner(System.in);
		int countLoginFail = 0;
		int loginChoose = 0;
		while (true) {
			// Check login and sign up
			while (user == null) {

				try {
					System.out.println(
							"Please login to continue\n1.Sign in\n2.Sign up\n3.Leave\n----------------------------------");
					loginChoose = Integer.parseInt(scanner.nextLine());
					if (loginChoose < 1 || loginChoose > 3)
						throw new InputMismatchException("Please choose 1,2 or 3");
				} catch (NumberFormatException e) {
					System.out.println("Please input a number");
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}

				if (loginChoose == 3)
					break;
				if (loginChoose == 1) {
					user = userService.checkLogin();
					if (user == null)
						countLoginFail++;
				}
				if (loginChoose == 2) {
					userService.signUp();
				}

				if (countLoginFail > 4) {
					System.out.println("Too many fail attepmts\nPlease try again later");

					loginChoose = 3;

					break;
				}
			}

			if (loginChoose == 3) {
				System.out.println("SEE YOU AGAIN!!!!!!!!!!");
				break;
			}

			while (user != null) {
				// Loop If role is user
				while (user != null && user.getRoleId() == 1) {

					// Check reg_date
					if (!userService.checkRegDate(user))
						break;

					// Choose service
					userService.showUserMenu();
					int chooseService = 0;

					try {
						chooseService = Integer.parseInt(scanner.nextLine());
						if (chooseService < 1 || chooseService > 5)
							throw new InputMismatchException("Please choose correct number");
					} catch (NumberFormatException e) {
						System.out.println("Please input a number");
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
					}

					switch (chooseService) {
					case 1:
						// show Available book and borrow
						userService.showAllAvailable();

						inputChoose = userService.isContinue("borrow book");

						if (inputChoose.equalsIgnoreCase("YES")) {
							success = userService.borrow(user.getId());

							while (success == false) {
								System.out.println("Borrow fail! Something was wrong. Try again? YES or NO");

								if (scanner.nextLine().equalsIgnoreCase("NO"))
									break;
								success = userService.borrow(user.getId());
							}
						}

						break;
					case 2:
						// find book by book's info
						List<BookDto> list = userService.search();
						if (list == null)
							break;

						inputChoose = userService.isContinue("borrow book");
						if (inputChoose.equalsIgnoreCase("YES")) {
							success = userService.borrow(user.getId());

							while (success == false) {
								System.out.println("Borrow fail! Something was wrong. Try again? YES or NO");

								if (scanner.nextLine().equalsIgnoreCase("NO"))
									break;
								success = userService.borrow(user.getId());
							}
						}

						break;
					case 3:
						// show borrowed book and return

						userService.returnBook(user.getId());

						break;
					case 4:
						// edit user's info
						userService.updateUser(user);
						user = userService.findById(user.getId());
						break;
					default:

						break;
					}
					if (chooseService == 5) {

						System.out.println("Loging out!!!!!!!!!!");
						user = null;
					}
				}

				// Loop If role is librarian
				while (user != null && user.getRoleId() == 2) {
					librarianService.showMenu();
					int chooseService = 0;

					try {
						chooseService = Integer.parseInt(scanner.nextLine());
						if (chooseService < 1 || chooseService > 9)
							throw new InputMismatchException("Please choose correct number");
					} catch (NumberFormatException e) {
						System.out.println("Please input a number");
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
					}

					switch (chooseService) {
					case 1:
						// show Available book and borrow
						librarianService.showAllAvailable();
						inputChoose = userService.isContinue("borrow book");

						if (inputChoose.equalsIgnoreCase("YES")) {
							success = librarianService.borrow(user.getId());

							while (success == false) {
								System.out.println("Borrow fail! Something was wrong. Try again? YES or NO");

								if (scanner.nextLine().equalsIgnoreCase("NO"))
									break;
								success = librarianService.borrow(user.getId());
							}
						}

						break;
					case 2:
						// find book by book's info
						List<BookDto> list = librarianService.search();
						if (list == null)
							break;
						inputChoose = userService.isContinue("borrow book");
						if (inputChoose.equalsIgnoreCase("YES")) {
							success = librarianService.borrow(user.getId());

							while (success == false) {
								System.out.println("Borrow fail! Something was wrong. Try again? YES or NO");

								if (scanner.nextLine().equalsIgnoreCase("NO"))
									break;
								success = librarianService.borrow(user.getId());
							}
						}

						break;
					case 3:
						// show borrowed book and return

						librarianService.returnBook(user.getId());

						break;
					case 4:
						// edit user's info
						librarianService.updateUser(user);
						user = librarianService.findById(user.getId());
						break;
					case 5:
						// show list book and crud book
						librarianService.crudBook();
						break;
					case 6:
						// show list user and crud user
						librarianService.crudUser();
						break;
					case 7:

						librarianService.showBorrowHistory();
						break;
					case 8:

						librarianService.showBorrowByUser();
						break;
					default:
						break;
					}
					if (chooseService == 9) {
						System.out.println("Loging out!!!!!!!!!!");
						user = null;
					}
				}

			}
		}

		scanner.close();

	}
}
