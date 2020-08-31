package com.example.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.entity.Bookstore;
import com.example.entity.Author;

public class BookAuthor {
	private Bookstore bookstore;
	private Author authors;
	
	@Id	 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	public void setBookstore(Bookstore bookstore) {
		this.bookstore = bookstore;
		
	}
	public Bookstore getBookstore() {
		return this.bookstore ;
	}
	
	public void setAuthors(Author auth) {
		this.authors = auth;
		
	}
	public Author getAuthors() {
		return authors;
	}
}
