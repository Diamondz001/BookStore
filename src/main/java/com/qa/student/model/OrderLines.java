package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderLines {

	@Id
	@GeneratedValue
	private long lineId;
	
	@Column(name = "bookId", nullable = false)
	private long bookId;
	
	@Column(nullable = false)
	private int quantity;

	public OrderLines(){}
	
	public OrderLines(long bookId, int quantity) {
		super();
		this.bookId = bookId;
		this.quantity = quantity;
	}
	
	public OrderLines(long lineId, long bookId, int quantity) {
		super();
		this.lineId = lineId;
		this.bookId = bookId;
		this.quantity = quantity;
	}

	public long getLineId() {
		return lineId;
	}

	public void setLineId(long lineId) {
		this.lineId = lineId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// ======================================
	// = hashcode, equals & toString =
	// ======================================
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
		result = prime * result + (int) (lineId ^ (lineId >>> 32));
		result = prime * result + quantity;
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
		OrderLines other = (OrderLines) obj;
		if (bookId != other.bookId)
			return false;
		if (lineId != other.lineId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderLines [lineId=" + lineId + ", bookId=" + bookId
				+ ", quantity=" + quantity + "]";
	}		
}
