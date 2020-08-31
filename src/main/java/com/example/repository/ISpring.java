package com.example.repository;


import java.util.List;
import javax.persistence.EntityManager;
import com.example.entity.Bookstore;

public interface ISpring  {
	String getString();
	String getDbVersion();
	String getDb2();

	Bookstore find(String bid);
	int update(Bookstore bookstore);

	int del(String sql) ;
	int del2(String sql);
	int toUpdate(EntityManager em2 , String sql);
	List<Bookstore>	getBookstoreAll();
	Bookstore useSessionFind(String bid);
}
