package com.demo.tracker.finance.expensetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.tracker.finance.expensetracker.entity.Budget;

public interface BudgetDAO extends JpaRepository<Budget, Integer> {

}
