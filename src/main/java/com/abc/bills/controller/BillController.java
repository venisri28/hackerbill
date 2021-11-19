package com.abc.bills.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bills.entity.Bill;
import com.abc.bills.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	
	@GetMapping("/bills")
	public List<Bill> getAllBills() {
		List<Bill> billsList=billService.getAllBills();
		return billsList;
	}
	
	@PostMapping("/addBill")
	public ResponseEntity<Bill> addBill (@Valid @RequestBody Bill bill) {
	billService.addBill(bill);
	return new ResponseEntity<>(bill,HttpStatus.OK);	
	}
	
	@GetMapping("/bills/{id}")
	public Bill getBillById(@PathVariable("id") long billNo) {
		Bill bill=billService.getBillById(billNo);
		return bill;
	}
	
	@GetMapping("/bills/due/{date}")
	public List<Bill> getBillByDueDate(@PathVariable("date")  @DateTimeFormat(iso = ISO.DATE) LocalDate dueDate) {
		List<Bill> billsList=billService.getBillsByDueDate(dueDate);
		return billsList;
	}

}
