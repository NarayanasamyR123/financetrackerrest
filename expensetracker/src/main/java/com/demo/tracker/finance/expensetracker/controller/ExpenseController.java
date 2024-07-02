package com.demo.tracker.finance.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.tracker.finance.expensetracker.dao.ExpenseDAO;
import com.demo.tracker.finance.expensetracker.entity.Expense;
import com.demo.tracker.finance.expensetracker.exception.ExpenseNotFoundException;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseDAO expenseDAO;

	@PostMapping("/api/expenses")
	public void recordExpense(@RequestBody Expense expense) {
		expenseDAO.save(expense);

	}

	@GetMapping("/api/expenses")
	public List<Expense> getExpense() {
		List<Expense> list = expenseDAO.findAll();

		return list;

	}

	@PutMapping("/api/expenses/{expenseId}")
	public Expense updateExpense(@PathVariable("expenseId") int id, @RequestBody Expense expense) {
		Expense exp = expenseDAO.findById(id).orElse(null);

		if (exp == null) {
			throw new ExpenseNotFoundException(id + " id was not found");
		}

		exp.setExpenseName(expense.getExpenseName());
		exp.setDescription(expense.getDescription());
		exp.setExpenseAmount(expense.getExpenseAmount());
		exp.setCreationDate(expense.getCreationDate());
		expenseDAO.save(exp);

		return exp;
	}

	@DeleteMapping("/api/expenses/{expenseId}")
	public void deleteExpense(@PathVariable("expenseId") int id) {
		expenseDAO.deleteById(id);
	}

}
