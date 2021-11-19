package com.abc.bills.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bills.entity.Bill;
import com.abc.bills.exception.DuplicateEntryException;
import com.abc.bills.exception.ResourceNotFoundException;
import com.abc.bills.repository.BillRepository;


@Service
public class BillServiceImplementation implements BillService {
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public List<Bill> getAllBills() {
		List<Bill> billsList=billRepository.findAll();
		return billsList;
	}

	@Override
	public void addBill(Bill bill) throws DuplicateEntryException {
		Optional<Bill> optionalBill=billRepository.findById(bill.getBillNo());
		if(optionalBill.isPresent()) {
			throw new DuplicateEntryException("Bill already existing with id : "+bill.getBillNo());
		}
		billRepository.save(bill);		
	}

	@Override
	public Bill getBillById(long billNo)throws ResourceNotFoundException {
		Optional<Bill> optionalBill=billRepository.findById(billNo);
		if(optionalBill.isEmpty()) {
			throw new ResourceNotFoundException("Bill not existing with id : "+billNo);
		}
		Bill bill=optionalBill.get();
		return bill;
	}

	@Override
	public List<Bill> getBillsByDueDate(LocalDate dueDate) {
		List<Bill> billsList=billRepository.findByDueDate(dueDate);
		return billsList;
	}

}
