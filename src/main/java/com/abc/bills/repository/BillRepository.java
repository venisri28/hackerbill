package com.abc.bills.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.bills.entity.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {
	public List<Bill> findByDueDate(LocalDate dueDate);

}
