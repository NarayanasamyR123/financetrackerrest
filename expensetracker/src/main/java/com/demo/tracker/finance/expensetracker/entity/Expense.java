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
@Table(name = "Expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expid")
	private int expenseId;
	@Column(name = "expname")
	private String expenseName;
	@Column(name = "expamount")
	private double expenseAmount;
	@Column(name = "expdesc")
	private String description;
	@Column(name = "credate")
	private String creationDate;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "incomeexpensejoin", joinColumns = @JoinColumn(name = "expenseid"), inverseJoinColumns = @JoinColumn(name = "incomeid"))
	private List<Income> income;

	public Expense() {
	}

	public Expense(String expenseName, double expenseAmount, String description, String creationDate) {
		super();
		this.expenseName = expenseName;
		this.expenseAmount = expenseAmount;
		this.description = description;
		this.creationDate = creationDate;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public List<Income> getIncome() {
		return income;
	}

	public void setIncome(List<Income> income) {
		this.income = income;
	}

	public void addIncome(Income inc) {
		if (income == null) {
			income = new ArrayList<>();
		}

		income.add(inc);
	}

}
