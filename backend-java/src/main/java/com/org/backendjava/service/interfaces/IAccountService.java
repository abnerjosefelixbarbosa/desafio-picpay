package com.org.backendjava.service.interfaces;

import com.org.backendjava.model.dto.CreateAccountDTO;
import com.org.backendjava.model.dto.CreateAccountView;
import com.org.backendjava.model.entity.Account;
import com.org.backendjava.model.entity.User;

public interface IAccountService {
	Account saveAccount(Account account);
	Account findByUser(User user);
	CreateAccountView createAccount(CreateAccountDTO dto);
}
