package dung.connect;

import java.util.List;

import dung.dto.Input;
import dung.dto.Order;
import dung.dto.Output;
import dung.dto.User;

public interface DaoClient {
	public List<Order> allOrder();
	public void checkStatus(int order_id);
	public void addInput(Input input);
	public List<Input> lsInputUser(User user);
	public void addOutput(Output output);
}
