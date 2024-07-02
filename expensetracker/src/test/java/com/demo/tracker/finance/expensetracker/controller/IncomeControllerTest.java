package com.demo.tracker.finance.expensetracker.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.tracker.finance.expensetracker.dao.IncomeDAO;
import com.demo.tracker.finance.expensetracker.entity.Income;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class IncomeControllerTest {

	@Mock
	private IncomeDAO incomeDAO;

	@InjectMocks
	private IncomeController incomeController;

	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	private ObjectWriter objectWriter = objectMapper.writer();

	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(incomeController).build();
	}

	@Test
	public void createIncomeTest() throws Exception {

		Income income = new Income("job", 50000.00, LocalDate.now().toString());

		String content = objectWriter.writeValueAsString(income);

		Mockito.when(incomeDAO.save(income)).thenReturn(income);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/incomes").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isOk());

	}

}
