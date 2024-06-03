package com.org.backendjava.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AuthorizeService {
	public void authorization() {
		boolean response = new Random().nextBoolean();

		if (!response)
			throw new RuntimeException("não autorizado");
	}
}