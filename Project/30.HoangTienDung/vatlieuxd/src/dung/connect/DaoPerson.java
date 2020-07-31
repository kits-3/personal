package dung.connect;

import java.util.List;

import dung.dto.Info;
import dung.dto.Order;
import dung.dto.User;

public interface DaoPerson {
	public void addUser(User user);
	public void newInfo(Info info,User user);
	public void addOrder(Order order);
	public void addMoney(User user,double money);
	public User findUser(String user);
	public Info findInfo(int users_id);
	public List<Order> findOrder(int users_id);
	public void delOrder(int order_id);
	public void changeInfo(User user);
	public void changePass(User user);
}
