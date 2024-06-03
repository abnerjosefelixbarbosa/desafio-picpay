package com.org.backendjava.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.backendjava.model.dto.CreateWalletDTO;
import com.org.backendjava.model.enums.TypeUser;

@SpringBootTest
@AutoConfigureMockMvc
public class WalletControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldCreateUserAndReturnStatus201() throws Exception {
		CreateWalletDTO dto = new CreateWalletDTO("Fernando Ricardo", "101.660.230-86", "fernan789@gmail.com", "1441",
				TypeUser.COMMOM);

		String obj = objectMapper.writeValueAsString(dto);

		mockMvc.perform(post("/api/wallets/create-wallet").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(print());
	}
}
