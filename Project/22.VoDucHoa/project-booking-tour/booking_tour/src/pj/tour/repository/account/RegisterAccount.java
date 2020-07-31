package pj.tour.repository.account;

import pj.tour.entity.AccountEntity;
import pj.tour.entity.UserEntity;

public interface RegisterAccount {
	void registerAccount(AccountEntity acc);
	void addUserInfo(UserEntity user);
//	void get
}
