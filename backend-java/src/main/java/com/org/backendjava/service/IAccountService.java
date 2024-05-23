package com.org.backendjava.service;

import com.org.backendjava.model.entity.Account;
import com.org.backendjava.model.entity.User;

public interface IAccountService {
	Account saveAccount(Account account);
	Account findByUser(User user);
}
