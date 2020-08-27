package com.exmaple.config;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.cj.jdbc.Driver;
@Configuration
@Component
public class MySysConfig {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;


	@Bean(name = "dataSource")
	public  DataSource getDataSource() {
		
		BasicDataSource  dataSource = new BasicDataSource();
		
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClass);	
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	 @Bean(name = "transactionManager")	
	public DataSourceTransactionManager transactionManager() {
		 return new DataSourceTransactionManager(getDataSource());

	 }
	 
	//@Bean(name = "SessionFactory")
	
    public SessionFactory getSessionFactory( DataSource dataSource){
		LocalSessionFactoryBean sessionBean = new LocalSessionFactoryBean();	
		sessionBean.setDataSource(dataSource);
	//	sessionBean.setPackagesToScan("com.example");
	//  Properties props = new Properties();
	//  props.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
	//  sessionBean.setHibernateProperties(props);
		 try {
				sessionBean.afterPropertiesSet();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
		return sessionBean.getObject() ; 
		

    }
}
