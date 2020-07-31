package admin;

import java.util.Scanner;

import adminDao.CategoryDao;
import adminDao.CategoryImpl;
import entity.Category_book;

public class CategoryView {
	Scanner scanner = new Scanner(System.in);
	CategoryDao categorydao = new CategoryImpl();
	Category_book ct = new Category_book();
	String name;

	public void view() {
		boolean check_categoryView = true;
		while (check_categoryView) {
			System.out.println("1.Category_book: ");
			System.out.println("------------------------------------------");
			categorydao.findAll();
			System.out.println("------------------------------------------");
			System.out.println("1-1.Create_Category");
			System.out.println("1-2.Update_Category");
			System.out.println("1-3.Delete_Category");
			System.out.println("1-4.Select the function");
			System.out.println("1-5.End");
			String key = scanner.next();
			scanner.nextLine();
			switch (key) {
			case "1":
				try {
					System.out.println("1-1.Create_Category");
					System.out.println("------------------------------------------");
					System.out.println("Name category: ");
					name = scanner.nextLine();
					ct.setCatogory_name(name);
					categorydao.add(ct);
					break;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error");
				}
			case "2":
				try {
					System.out.println("1-2.Update_Category");
					System.out.println("------------------------------------------");
					System.out.println("Id category: ");
					int id = scanner.nextInt();
					ct.setCategory_id(id);
					System.out.println("Name category: ");
					name = scanner.next();
					ct.setCatogory_name(name);
					System.out.println("Status: ");
					int status = scanner.nextInt();
					ct.setStatus(status);
					categorydao.update(ct);
					break;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error");
				}
			case "3":
				try {
					System.out.println("1-3.Delete_Category");
					System.out.println("------------------------------------------");
					System.out.println("Category_name: ");
					name = scanner.next();
					categorydao.delete(name);
					categorydao.delete_book();
					break;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error");
				}
			case "4":
				new Admin().notification();
				check_categoryView = false;
				break;
			case "5":
				System.out.println("END");
				check_categoryView = false;
				break;
			default:
				break;

			}
		}
	}
}
