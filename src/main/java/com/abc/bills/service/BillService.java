package com.abc.bills.service;

import java.time.LocalDate;
import java.util.List;

import com.abc.bills.entity.Bill;

public interface BillService {
	public List<Bill> getAllBills();
	public void addBill(Bill bill);
	public Bill getBillById(long billNo);
	public List<Bill> getBillsByDueDate(LocalDate dueDate);

}
