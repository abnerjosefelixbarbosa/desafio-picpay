package com.org.backendjava.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.math.BigDecimal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.backendjava.interfaces.ITransferenceService;
import com.org.backendjava.model.dto.TransferValueDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class TransferenceControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ITransferenceService transferenceService;

	@Test
	@Disabled
	public void shouldTransferValueAndReturnStatus200() throws Exception {
		TransferValueDTO dto = new TransferValueDTO(BigDecimal.valueOf(100), Long.valueOf(1), Long.valueOf(2));

		String obj = objectMapper.writeValueAsString(dto);

		mockMvc.perform(post("/api/transferences/transfer-value").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	@Test
	@Disabled
	public void shouldListTransferencesByPayerAndReturnStatus200() throws Exception {
        TransferValueDTO dto = new TransferValueDTO(BigDecimal.valueOf(100), Long.valueOf(1), Long.valueOf(2));
        transferenceService.transferValue(dto);
		
		mockMvc.perform(get("/api/transferences/list-transference-by-player?payer=1&&number=0&&size=5"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
	}
}