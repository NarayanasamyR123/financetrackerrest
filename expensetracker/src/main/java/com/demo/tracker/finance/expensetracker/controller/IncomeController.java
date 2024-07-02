package com.demo.tracker.finance.expensetracker.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tracker.finance.expensetracker.dao.IncomeDAO;
import com.demo.tracker.finance.expensetracker.entity.Income;

@RestController
public class IncomeController {

	@Autowired
	private IncomeDAO incomeDAO;

	@PostMapping("/api/incomes")
	public void createIncomeRecord(@RequestBody Income income) {
		income.setCreationDate(LocalDate.now().toString());

		incomeDAO.save(income);
	}

}
