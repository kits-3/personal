package kits.personal.service.impl;

import java.sql.Date;
import java.util.List;

import kits.personal.dto.BookDto;
import kits.personal.entity.User;
import kits.personal.service.LibrarianService;

public class LibrarianServiceImpl extends UserServiceImpl implements LibrarianService {
	
	@Override
	public void showAllAvailable() {
		super.showAllAvailable();
	}
	
	@Override
	public boolean borrow(int userId) {
		// TODO Auto-generated method stub
		return super.borrow(userId);
	}
	
	@Override
	public Date getCurrentDate() {
		// TODO Auto-generated method stub
		return super.getCurrentDate();
	}
	
	@Override
	public boolean returnBook() {
		// TODO Auto-generated method stub
		return super.returnBook();
	}
	
	@Override
	public void search() {
		// TODO Auto-generated method stub
		super.search();
	}
	
	@Override
	public List<BookDto> showBorrowBook(int userId) {
		// TODO Auto-generated method stub
		return super.showBorrowBook(userId);
	}
	
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return super.updateUser(user);
	}

	@Override
	public void showBookList() {
		
	}

	@Override
	public boolean createUser() {
		return false;
	}

	@Override
	public boolean createBook() {
		return false;
	}

	@Override
	public boolean updateBook() {
		return false;
	}

	@Override
	public boolean deleteUser() {
		return false;
	}

	@Override
	public boolean deleteBook() {
		return false;
	}

	@Override
	public void showAllUser() {
		
	}

	@Override
	public List<BookDto> showAllBorrowBook() {
		
		return null;
	}
	
	
	
}
