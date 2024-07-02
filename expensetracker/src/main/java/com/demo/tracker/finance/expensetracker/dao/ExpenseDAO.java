package com.demo.tracker.finance.expensetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.tracker.finance.expensetracker.entity.Expense;

public interface ExpenseDAO extends JpaRepository<Expense, Integer> {

}
