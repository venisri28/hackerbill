package com.abc.bills.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bill 
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billNo;
	private String billedTo;
	private LocalDate billedDate;
	private double price;
	private double taxOnTheBill;
	private double totalAmount;
	private LocalDate dueDate;
	
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public long getBillNo() {
		return billNo;
	}
	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}
	public String getBilledTo() {
		return billedTo;
	}
	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}
	public LocalDate getBilledDate() {
		return billedDate;
	}
	public void setBilledDate(LocalDate billedDate) {
		this.billedDate = billedDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTaxOnTheBill() {
		return taxOnTheBill;
	}
	public void setTaxOnTheBill(double taxOnTheBill) {
		this.taxOnTheBill = taxOnTheBill;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}

