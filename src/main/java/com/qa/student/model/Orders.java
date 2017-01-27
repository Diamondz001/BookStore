package com.qa.student.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	private long orderId;
	
	//@Column(name = "customerId", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Customers customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<OrderLines> orderLines = new HashSet<OrderLines>();
	
	public Orders(){} // ? 

	public Orders(long orderId, Customers customer) {
		super();
		this.orderId = orderId;
		this.customer = customer;
	}
	public Orders(Customers customer, Set<OrderLines> orders) {
		super();
		this.customer = customer;
		this.orderLines = orders;
	}
	public Orders(int orderId, Customers customer, Set<OrderLines> orders) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderLines = orders;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Customers getCustomerId() {
		return customer;
	}

	public void setCustomerId(Customers customer) {
		this.customer = customer;
	}

	public Set<OrderLines> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLines> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customer=" + customer
				+ ", orderLines=" + orderLines + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result
				+ ((orderLines == null) ? 0 : orderLines.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderLines == null) {
			if (other.orderLines != null)
				return false;
		} else if (!orderLines.equals(other.orderLines))
			return false;
		return true;
	}
	
}
