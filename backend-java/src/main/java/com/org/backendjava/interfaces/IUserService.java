package com.org.backendjava.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.backendjava.model.dto.ListUserView;
import com.org.backendjava.model.entity.User;

public interface IUserService {
	User saveUser(User user);
	User findById(Long id, String message);
	boolean existsByEmailOrDocmentOrPassword(User user);
	Page<ListUserView> listUser(Pageable pageable);
}