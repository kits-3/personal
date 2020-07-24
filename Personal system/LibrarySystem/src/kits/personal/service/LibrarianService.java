package kits.personal.service;

import java.sql.Date;
import java.util.List;

import kits.personal.dto.BookDto;
import kits.personal.entity.User;

public interface LibrarianService {
	void showAllAvailable();
	boolean borrow(int id);
	void search();
	List<BookDto> showBorrowBook(int userId);
	Date getCurrentDate();
	boolean returnBook();
	boolean updateUser(User user);
	void showBookList();
	boolean createUser();
	boolean createBook();
	boolean updateBook();
	boolean deleteUser();
	boolean deleteBook();
	void showAllUser();
	List<BookDto> showAllBorrowBook();
	
}
