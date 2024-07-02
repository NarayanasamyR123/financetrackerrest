package com.demo.tracker.finance.expensetracker.entity;

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
@Table(name = "Budget")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "itemname")
	private String itemName;
	@Column(name = "budgetamt")
	private double budgetAmt;
	@Column(name = "createddt")
	private String createdDate;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "incomebudgetjoin", joinColumns = @JoinColumn(name = "budgetid"), inverseJoinColumns = @JoinColumn(name = "incomeid"))
	private List<Income> income;

	public Budget() {

	}

	public Budget(String itemName, double budgetAmt, String createdDate) {
		this.itemName = itemName;
		this.budgetAmt = budgetAmt;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getBudgetAmt() {
		return budgetAmt;
	}

	public void setBudgetAmt(double budgetAmt) {
		this.budgetAmt = budgetAmt;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<Income> getIncome() {
		return income;
	}

	public void setIncome(List<Income> income) {
		this.income = income;
	}

}
