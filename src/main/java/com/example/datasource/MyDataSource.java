package com.example.datasource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class MyDataSource extends BasicDataSource{
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	
	
	public MyDataSource() {
		super();
		
	}

	@PostConstruct
	public void init() {
		setUrl(url);
		setDriverClassName(driverClass);	
		setUsername(username);
		setPassword(password);
	}
	public  DataSource getDataSource() {
		return this;
		/*
		BasicDataSource  dataSource = new BasicDataSource();
		
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClass);	
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
		*/
	}
}
