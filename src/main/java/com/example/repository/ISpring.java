package com.example.repository;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import com.example.entity.Bookstore;

public interface ISpring  {
	String getString();
	String getDbVersion();
	String getDb2();
	String getDb3();
	Bookstore find(String bid);
	int update(Bookstore bookstore);
	List<Bookstore>	getBookstoreAll();
	//SessionFactory getSessionFactory( DataSource dataSource);
	//DataSource getDataSource();
}
