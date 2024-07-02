package com.demo.tracker.finance.expensetracker.entity;

import java.util.List;

import com.demo.tracker.finance.expensetracker.dao.BudgetDAO;
import com.demo.tracker.finance.expensetracker.dao.ExpenseDAO;
import com.demo.tracker.finance.expensetracker.dao.IncomeDAO;

public class Reports {

	private List<Income> income;
	private List<Expense> expense;
	private List<Budget> budgets;

	public List<Income> getIncome() {
		return income;
	}

	public void setIncome(IncomeDAO incomeDAO) {
		this.income = incomeDAO.findAll();
	}

	public List<Expense> getExpense() {
		return expense;
	}

	public void setExpense(ExpenseDAO expenseDAO) {
		this.expense = expenseDAO.findAll();
	}

	public List<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(BudgetDAO budgetDAO) {
		this.budgets = budgetDAO.findAll();
	}

}
