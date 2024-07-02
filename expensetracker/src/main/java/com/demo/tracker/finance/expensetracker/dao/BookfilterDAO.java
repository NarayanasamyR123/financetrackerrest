package com.demo.tracker.finance.expensetracker.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.tracker.finance.expensetracker.entity.Income;

public interface BookfilterDAO extends PagingAndSortingRepository<Income, Integer> {
 
	Page<Income> findAll(Pageable pageable);

	Page<Income> findByIncomeSource(String incomeSource, Pageable pageable);

	List<Income> findByCreationDate(String creationDate, Sort sort);

}
