package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the bookstore database table.
 * 
 */
@Entity
@Table(name="bookstore")
@NamedQuery(name="Bookstore.findAll", query="SELECT b FROM Bookstore b")
@NamedQuery(name="Bookstore.getone" , query="SELECT b FROM Bookstore b where b.bid=:bid")

public class Bookstore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String bid;

	@Column(length=30)
	private String author;

	@Column(nullable=false, length=50)
	private String bookname;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal price;

	@Column(length=50)
	private String publisher;

	@Column(length=10)
	private String version;

	public Bookstore() {
	}

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}