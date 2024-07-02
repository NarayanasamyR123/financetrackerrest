package com.demo.tracker.finance.expensetracker.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.demo.tracker.finance.expensetracker.dao.ExpenseDAO;
import com.demo.tracker.finance.expensetracker.entity.Expense;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class ExpenseControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ExpenseDAO expenseDAO;

	@InjectMocks
	private ExpenseController expenseController;

	private ObjectMapper objectMapper = new ObjectMapper();

	private ObjectWriter objectWriter = objectMapper.writer();

	@BeforeEach
	public void setUp()

	{
		mockMvc = MockMvcBuilders.standaloneSetup(expenseController).build();
	}

	@Test
	public void createExpenseTest() throws Exception {

		Expense expense = new Expense("iphone", 55000.00, "new iphone", LocalDate.now().toString());

		String content = objectWriter.writeValueAsString(expense);

		Mockito.when(expenseDAO.save(expense)).thenReturn(expense);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/expenses").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isOk());

	}

	@Test
	void getallTest() throws Exception {

		List<Expense> list = new ArrayList<Expense>();

		list.add(new Expense("iphone", 55000.00, "new iphone", LocalDate.now().toString()));
		Mockito.when(expenseDAO.findAll()).thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/expenses").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void deleteTest() throws Exception {
		Expense expense = new Expense("Food", 1000.00, "non-veg", LocalDate.now().toString());

		Mockito.when(expenseDAO.findById(expense.getExpenseId())).thenReturn(Optional.of(expense));

		mockMvc.perform(

				MockMvcRequestBuilders.delete("/api/expenses/3").contentType(MediaType.APPLICATION_JSON)

		).andExpect(status().isOk());

	}

	@Test
	public void updateExpenseTest() {
		Expense expense = new Expense("Food", 1000.00, "non-veg", LocalDate.now().toString());

		String content;
		try {
			content = objectWriter.writeValueAsString(expense);

			Mockito.when(expenseDAO.findById(expense.getExpenseId())).thenReturn(Optional.of(expense));
			Mockito.when(expenseDAO.save(expense)).thenReturn(expense);

			mockMvc.perform(MockMvcRequestBuilders.put("/api/expenses/1").contentType(MediaType.APPLICATION_JSON)
					.content(content)).andExpect(status().isOk());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
