package customerDao;

import java.util.List;

import entity.Bill;
import entity.BillDetail;
import entity.Book;

public interface BillDao_cus {


	//void add(Bill bill, List<Book> list, List<Integer> list1, Integer money_user);

	void add(Bill bill, List<Book> list, List<BillDetail> listBillDetails, Integer money_user);
}
