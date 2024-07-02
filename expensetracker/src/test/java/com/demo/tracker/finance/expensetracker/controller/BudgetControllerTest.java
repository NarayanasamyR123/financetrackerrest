package com.demo.tracker.finance.expensetracker.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.demo.tracker.finance.expensetracker.dao.BudgetDAO;
import com.demo.tracker.finance.expensetracker.entity.Budget;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class BudgetControllerTest {

	@InjectMocks
	private BudgetController budgetController;

	@Mock
	private BudgetDAO budgetDAO;

	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	private ObjectWriter objectWriter = objectMapper.writer();

	@BeforeEach
	void setUp() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(budgetController).build();
	}

	@Test
	void getBudgetTest() throws Exception {

		List<Budget> list = new ArrayList<Budget>();

		Mockito.when(budgetDAO.findAll()).thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/budgets")).andExpect(status().isOk());

	}

	@Test
	public void createBudgetTest() throws Exception {

		Budget budget = new Budget("mobile", 55000.00, "2024-12-24");

		String content = objectWriter.writeValueAsString(budget);

		Mockito.when(budgetDAO.save(budget)).thenReturn(budget);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/budgets").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isOk());

	}

}
