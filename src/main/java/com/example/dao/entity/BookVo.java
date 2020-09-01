package com.example.dao.entity;

import javax.persistence.*;

@Entity
public class BookVo {

	@Id
	private String bid;
	private String bookname;
	private String author;
	private String address;
	
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBid() {
		return bid;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookname() {
		return bookname;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
}
