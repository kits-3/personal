package customer;

import java.util.List;
import java.util.Scanner;

import customerDao.CategoryDao_cus;
import customerDao.CategoryImpl_cus;
import entity.Book;

public class CategoryView_cus {

	public void view(String gmail, List<Book> list){
		try {
			CategoryDao_cus categirydao_cus = new CategoryImpl_cus();
			Scanner scanner = new Scanner(System.in);
			CategoryDao_cus categorydao = new CategoryImpl_cus();
			boolean CheckCategoryView_cus = true;
			while (CheckCategoryView_cus) {
				System.out.println("1.Choose category book you want buy");
				System.out.println("2.Log out");
				String key = scanner.next();
				switch (key) {
				case "1":
					
					System.out.println("------------------------------------------");
					categorydao.findAll();
					System.out.println("------------------------------------------");
					System.out.println("Input category book you want buy");
					String category_name = scanner.next();
					CheckCategoryView_cus = false;
					new BookView_cus().view(gmail, list, category_name);
					break;
				case "2":
					System.out.println("END");
					CheckCategoryView_cus = false;
					break;
				default:
					CheckCategoryView_cus = true;
					break;
				}
			}
			
		} catch (Exception e) {
			new CategoryView_cus().view(gmail, list);
		}

	}
}
