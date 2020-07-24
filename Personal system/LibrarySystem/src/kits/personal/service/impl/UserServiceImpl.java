package kits.personal.service.impl;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import kits.personal.dto.BookDto;
import kits.personal.entity.Book;
import kits.personal.entity.Loan;
import kits.personal.entity.User;
import kits.personal.entity.User;
import kits.personal.repository.BookRepository;
import kits.personal.repository.LoanRepository;
import kits.personal.repository.UserRepository;
import kits.personal.repository.impl.BookRepositoryImpl;
import kits.personal.repository.impl.LoanRepositoryImpl;
import kits.personal.repository.impl.UserRepositoryImpl;
import kits.personal.service.UserService;

public class UserServiceImpl implements UserService {

	UserRepository userDao = new UserRepositoryImpl();
	BookRepository bookDao = new BookRepositoryImpl();
	LoanRepository loanDao = new LoanRepositoryImpl();
	@Override
	public User checkLogin(String username, String password) {

		User user = userDao.checkUsername(username);
		if (user == null) {
			System.out.println("Invalid username or password");
			return null;
		}

		if (user.getPassword().equals(password)) {
			System.out.println("Login success");
			System.out.println("Welcome: " + user.getName());
			return user;
		}
		System.out.println("Invalid username or password");
		return null;
	}

	@Override
	public User executeLogin() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Username: ");

		String username = scanner.nextLine();

		System.out.print("Password: ");

		String password = scanner.nextLine();

		return checkLogin(username, password);
	}

	@Override
	public void signIn() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sign in to continue");
		System.out.print("Username: ");
		String username = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		System.out.print("Identification number: ");
		String idnum = scanner.nextLine();
		System.out.print("Phone: ");
		String phone = scanner.nextLine();
		User user = new User(username,password,phone,idnum);
		userDao.add(user);
	}
	
	@Override
	public void showUserMenu() {
		System.out.println("What service do you want to use? Choose a number");
		System.out.println("1. Show available books");
		System.out.println("2. Find book by name, author or publisher");
		System.out.println("3. Show borrowed book");
		System.out.println("4. Update information");
		System.out.println("5. Leave");
	}
	
	@Override
	public void showAllAvailable() {
		System.out.printf("%-10s%-30s%-30s%s\n","ID","Name","Author","Publisher");
		for(BookDto item : bookDao.findAllAvailable()) {
			System.out.printf("%-10s%-30s%-30s%s\n",item.getId(),item.getName(),item.getAuthor(),item.getPublisher());
		}
	}
	
	@Override
	public boolean borrow(int userId) {
		Scanner scanner = new Scanner(System.in);
		Loan loan = new Loan();
		System.out.println("Choose book id to borrow");
		int bookId = Integer.parseInt(scanner.nextLine());
		loan.setBookId(bookId);
		loan.setUserId(userId);
		loan.setLoanDate(getCurrentDate());
		int result = loanDao.add(loan);
		if(result!=0) {
			bookDao.setAvailability(0,bookId);
			System.out.println("Borrow success\nYou borrow: "+ bookDao.findById(bookId).getName());
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Search: ");
		String keyword = scanner.nextLine();
		System.out.printf("%-10s%-30s%-30s%s\n","ID","Name","Author","Publisher");
		for(BookDto item : bookDao.findByBookInfo(keyword)) {
			System.out.printf("%-10s%-30s%-30s%s\n",item.getId(),item.getName(),item.getAuthor(),item.getPublisher());
		}
	}


	@Override
	public List<BookDto> showBorrowBook(int userId) {
		Scanner scanner = new Scanner(System.in);
		List<BookDto> list = bookDao.findBorrowed(userId);
		if(list.isEmpty()) return list;
		System.out.println("List of borrowed books");
		System.out.printf("%-10s%-30s%-20s%-20s%s\n","ID","Name","Author","Publisher","Loan Date");
		for(BookDto item : list) {
			System.out.printf("%-10s%-30s%-20s%-20s%s\n",item.getId(),item.getName(),item.getAuthor(),item.getPublisher(),item.getLoanDate());
		}
		return list;
	}

	@Override
	public boolean returnBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose book id to return");
		int bookId = Integer.parseInt(scanner.nextLine());
		int result = loanDao.deActivate(bookId);
		
		if(result!=0) {
			bookDao.setAvailability(1,bookId);
			System.out.println("Return success\nYou return: "+ bookDao.findById(bookId).getName());
			return true;
		}
		return false;
	}
	

	@Override
	public Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String loanDate = year +"-"+month+"-"+day;
		
		return Date.valueOf(loanDate);
	}


	
	@Override
	public boolean updateUser(User user) {
		Scanner scanner = new Scanner(System.in);
		if(scanner.nextLine().equalsIgnoreCase("NO")) return false;
		System.out.print("Username: ");
		user.setName(scanner.nextLine());
		System.out.print("Password: ");
		user.setPassword(scanner.nextLine());
		System.out.print("Identification number: ");
		user.setIdNum(scanner.nextLine());
		System.out.print("Phone: ");
		user.setPhone(scanner.nextLine());
		int check = userDao.update(user);
		if(check==0) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
