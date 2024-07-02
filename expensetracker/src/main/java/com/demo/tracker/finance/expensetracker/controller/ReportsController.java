package com.demo.tracker.finance.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tracker.finance.expensetracker.dao.BudgetDAO;
import com.demo.tracker.finance.expensetracker.dao.ExpenseDAO;
import com.demo.tracker.finance.expensetracker.dao.IncomeDAO;
import com.demo.tracker.finance.expensetracker.entity.Reports;

@RestController
public class ReportsController {

	private BudgetDAO budgetDAO;
	private ExpenseDAO expenseDAO;
	private IncomeDAO incomeDAO;

	@Autowired
	public ReportsController(ExpenseDAO expenseDAO, BudgetDAO budgetDAO, IncomeDAO incomeDAO) {
		this.budgetDAO = budgetDAO;
		this.expenseDAO = expenseDAO;
		this.incomeDAO = incomeDAO;
	}

	@GetMapping("/api/reports")
	public Reports getReport()

	{
		Reports reports = new Reports();

		reports.setIncome(incomeDAO);

		reports.setExpense(expenseDAO);

		reports.setBudgets(budgetDAO);

		return reports;
	}

}
