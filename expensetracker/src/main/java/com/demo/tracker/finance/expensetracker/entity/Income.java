package com.demo.tracker.finance.expensetracker.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Income")
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int incomeId;
	@Column(name = "incomesrc")
	private String incomeSource;
	@Column(name = "incomeamt")
	private double incomeAmount;
	@Column(name = "creationdt")
	private String creationDate;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "incomeexpensejoin", joinColumns = @JoinColumn(name = "incomeid"), inverseJoinColumns = @JoinColumn(name = "expenseid"))
	private List<Expense> expenses;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "incomebudgetjoin", joinColumns = @JoinColumn(name = "incomeid"), inverseJoinColumns = @JoinColumn(name = "budgetid"))
	private List<Budget> budgets;

	public Income() {
	}

	public Income(String incomeSource, double incomeAmount, String creationDate) {
		super();
		this.incomeSource = incomeSource;
		this.incomeAmount = incomeAmount;
		this.creationDate = creationDate;
	}

	public int getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}

	public String getIncomeSource() {
		return incomeSource;
	}

	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}

	public double getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public void addExpense(Expense expense) {
		if (expenses == null) {
			expenses = new ArrayList<>();
		}
		expenses.add(expense);
	}

	public List<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}


}
