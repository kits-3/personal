package adminDao;

import entity.User;

public interface LoginDao {
	User login(String User_id, Integer pass);
	void add(User user);
	User forget_pw(String gmail);

}
