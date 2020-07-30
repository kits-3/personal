package customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.soap.Detail;

import customerDao.BillDao_cus;
import customerDao.BillImpl;
import customerDao.SaveBill;
import customerDao.SaveBillImpl;
import customerDao.UserImpl_cus;
import entity.Bill;
import entity.BillDetail;
import entity.Book;

public class BillView_cus {

	public void upBill(String gmail, List<Book> list) {
		try {
			SaveBill savebill = new SaveBillImpl();
			BillDao_cus billDao = new BillImpl();
			BillDetail billDetail = new BillDetail();
			int number = 0;
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.Pay the bill");
			System.out.println("2.Buy new product");
			List<BillDetail> liBillDetails = new ArrayList<BillDetail>();
			List<Integer> list1 = new ArrayList<Integer>();
			if (list.size() == 1) {
				billDetail.setBook_id(list.get(0).getBook_id());
				billDetail.setNumber(1);
				liBillDetails.add(billDetail);
			} else {
				for (int i = 0; i < list.size(); i++) {
					for (int j = 1; j < list.size(); j++) {
						if (list.get(i).getBook_id() == list.get(j).getBook_id()) {
							number = number +1;
						}
					}
					billDetail.setBook_id(list.get(i).getBook_id());
					billDetail.setNumber(number);
					liBillDetails.add(billDetail);
				}
			}
			String key = scanner.next();
			if (key.equals("1")) {
				int old_money = savebill.findMoney(gmail);
				int money = 0;
				for (int i = 0; i < list.size(); i++) {
					money += list.get(i).getPrice();
				}
				if (old_money >= money) {
					try {
						Bill bill = new Bill();
						bill.setGmail(gmail);
						bill.setTotal(money);
						billDao.add(bill, list, liBillDetails, old_money);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Error");
					}
				} else {
					System.out.println("You not enought money. You want insert new money ?");
					String key1 = scanner.next();
					switch (key1) {
					case "y":
						System.out.println("Input your money: ");
						int new_money = scanner.nextInt();
						new UserImpl_cus().update_money_small(gmail, list, old_money, new_money);
						break;
					case "n":
						break;
					default:
						break;
					}
				}

			} else if (key.equals("2")) {
				new CategoryView_cus().view(gmail, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
	}
}
