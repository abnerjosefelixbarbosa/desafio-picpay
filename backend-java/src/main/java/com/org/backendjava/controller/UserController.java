package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.interfaces.IUserService;
import com.org.backendjava.model.dto.ListUserView;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/list-user")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<ListUserView>> listUser(Pageable pageable) {
	 	Page<ListUserView> views = userService.listUser(pageable);
		return ResponseEntity.status(200).body(views);
	}
}
