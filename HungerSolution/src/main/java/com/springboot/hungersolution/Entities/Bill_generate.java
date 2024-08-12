package com.springboot.hungersolution.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bill_generate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int orderid;
private double bill_amount;
private int custid;
private String payment_status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public double getBill_amount() {
	return bill_amount;
}
public void setBill_amount(double bill_amount) {
	this.bill_amount = bill_amount;
}
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public String getPayment_status() {
	return payment_status;
}
public void setPayment_status(String payment_status) {
	this.payment_status = payment_status;
}
public Bill_generate(int id, int orderid, double bill_amount, int custid, String payment_status) {
	super();
	this.id = id;
	this.orderid = orderid;
	this.bill_amount = bill_amount;
	this.custid = custid;
	this.payment_status = payment_status;
}
public Bill_generate() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Bill_generate [id=" + id + ", orderid=" + orderid + ", bill_amount=" + bill_amount + ", custid=" + custid
			+ ", payment_status=" + payment_status + "]";
}



}
