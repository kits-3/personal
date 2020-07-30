package admin;

import java.util.Scanner;

import adminDao.BookDao;
import adminDao.BookImpl;
import entity.Book;

public class BookView {
	Scanner scanner = new Scanner(System.in);
	Book book = new Book();
	BookDao bookdao = new BookImpl();
	String book_name;
	public void view() {
		boolean check_bookview = true;
		while (check_bookview) {
			System.out.println("1.Book: ");
			System.out.println("------------------------------------------");
			bookdao.findAll();
			System.out.println("------------------------------------------");
			System.out.println("1-1.Create_Book");
			System.out.println("1-2.Update_Book");
			System.out.println("1-3.Delete_Book");
			System.out.println("1-4.Select the function");
			System.out.println("1-5.End");
			String key = scanner.next();
			switch (key) {
			case "1":
				System.out.println("1-1.Create_Book");
				System.out.println("------------------------------------------");
				System.out.println("Name book: ");
				book_name = scanner.next();
			    book.setBook_name(book_name);
			    System.out.println("Athor:");
				String athor = scanner.next();
			    book.setAthor(athor);
			    System.out.println("Price: ");
				Integer price = scanner.nextInt();
			    book.setPrice(price);
			    System.out.println("Amount ");
				Integer amount = scanner.nextInt();
			    book.setAmount(amount);
			    System.out.println("Category_id ");
				Integer category_id = scanner.nextInt();
			    book.setCategory_id(category_id);
				bookdao.add(book);
				break;
			case "2":
				System.out.println("1-2.Update_Book");
				System.out.println("------------------------------------------");
				check_bookview = false;
				break;
			case "3":
				System.out.println("1-3.Delete_Book");
				System.out.println("------------------------------------------");
				System.out.println("Book_id: ");
				int book_id = scanner.nextInt();
				bookdao.delete(book_id);
				break;
			case "4":
				new Admin().notification();
				check_bookview = false;
				break;
			case "5":
				System.out.println("END");
				check_bookview = false;
				break;
			default:
				System.out.println("Please choose 1 - 5");
				check_bookview = true;
				break;
		}
		
		}
	}
}
