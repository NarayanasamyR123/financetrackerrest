package com.demo.tracker.finance.expensetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.tracker.finance.expensetracker.entity.Income;

public interface IncomeDAO extends JpaRepository<Income, Integer> {

}
