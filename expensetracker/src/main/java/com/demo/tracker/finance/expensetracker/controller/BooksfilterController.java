package com.demo.tracker.finance.expensetracker.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tracker.finance.expensetracker.dao.BookfilterDAO;
import com.demo.tracker.finance.expensetracker.entity.Income;

@RestController
@RestResource
public class BooksfilterController {

	@Autowired
	private BookfilterDAO bookfilterDAO;

	@GetMapping("/api/books")
	public ResponseEntity<Map<String, Object>> getIncomesData(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
			@RequestParam(defaultValue = "incomeId") String[] sort) {

		try {
			Pageable pagingSort;
			List<Income> income = new ArrayList<Income>();
			if (sort != null) {
				pagingSort = PageRequest.of(page, size, Sort.by(sort));

			} else {
				pagingSort = PageRequest.of(page, size);

			}

			Page<Income> pageTuts;
			if (title == null)
				pageTuts = bookfilterDAO.findAll(pagingSort);
			else
				pageTuts = bookfilterDAO.findByIncomeSource(title, pagingSort);

			income = pageTuts.getContent();

			if (income.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			Map<String, Object> response = new HashMap<>();
			response.put("income", income);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
