package com.demo.tracker.finance.expensetracker.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tracker.finance.expensetracker.dao.BudgetDAO;
import com.demo.tracker.finance.expensetracker.entity.Budget;

@RestController
public class BudgetController {

	@Autowired
	private BudgetDAO budgetDAO;

	@PostMapping("/api/budgets")
	public void setUpBudget(@RequestBody Budget budget) {
		budget.setCreatedDate(LocalDate.now().toString());
		budgetDAO.save(budget);
	}

	@GetMapping("/api/budgets")
	public List<Budget> retrieveAllBudget() {
		return budgetDAO.findAll();
	}
}
