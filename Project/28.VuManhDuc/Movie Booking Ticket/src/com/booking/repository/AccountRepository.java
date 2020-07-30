package com.booking.repository;


import java.util.List;

import com.booking.entity.AccountEntity;

public interface AccountRepository {
	AccountEntity checkAccount(String username, String password);
	void insertAccount();
	List<AccountEntity> findAll();
}
