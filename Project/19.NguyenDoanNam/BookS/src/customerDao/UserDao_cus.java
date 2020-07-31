package customerDao;

import java.util.List;

import entity.Book;
import entity.User;



public interface UserDao_cus {
	User findById(String gmail);
	
	void update(User user);

	void update_money_bill(String Gmail, Integer total, Integer money_user);

	void update_money_small(String Gmail, List<Book> list, Integer money_user, Integer new_money);

	
}
