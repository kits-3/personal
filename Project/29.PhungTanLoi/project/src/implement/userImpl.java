package implement;

import java.util.List;

import dto.User;

public interface userImpl {
	public boolean validate(String name, String password);
	public boolean roll(String name);
	public int add(User a);
	public int updateRoll(User s);
	public void delete(int id);
	public List<User> view();
	public void outPut();
	public User getUserByName(String name);
	public int update(User s);
}
