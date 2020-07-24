package kits.personal.service;

import java.sql.Date;
import java.util.List;

import kits.personal.dto.BookDto;
import kits.personal.entity.Book;
import kits.personal.entity.Loan;
import kits.personal.entity.User;

public interface UserService {
	User checkLogin(String username, String password);
	User executeLogin();
	void signIn();
	void showAllAvailable();
	void showUserMenu();
	boolean borrow(int id);
	void search();
	List<BookDto> showBorrowBook(int userId);
	Date getCurrentDate();
	boolean returnBook();
	boolean updateUser(User user);
}
