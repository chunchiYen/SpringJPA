package com.example.repository;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

public interface ISpring {
	String getString();
	String getDbVersion();
	String getDb2();
	String getDb3();
	
	SessionFactory getSessionFactory( DataSource dataSource);
	DataSource getDataSource();
}
