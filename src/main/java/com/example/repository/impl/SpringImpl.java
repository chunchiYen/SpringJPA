package com.example.repository.impl;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import com.example.datasource.MyDataSource;
import com.example.repository.ISpring;
import com.exmaple.config.MySysConfig;

@Service
public class SpringImpl implements ISpring {
		
	@Autowired
	MyDataSource dataSource;
	
	
	@PersistenceContext
	EntityManager em ;
	
	public String getString() {
		System.out.println("SpringImpl");
		return "SpringImpl";
	}
	
	// 使用 EntityManagerFactory 取得EntityManager進行查詢
	public String getDbVersion() {			

		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.user", "sa");
		properties.put("javax.persistence.jdbc.password", "sa1217");
		
		EntityManagerFactory  emf  = Persistence.createEntityManagerFactory("SpringJPA",properties);
		EntityManager em2 = emf.createEntityManager();
		Query query = em2.createNativeQuery("select version()");
		String result =(String) query.getSingleResult();	
		emf.close();
		return result;
	
	}

	public String getDb3() {

		Query query = em.createNativeQuery("select version()");
		String result =(String) query.getSingleResult();
		return result;
	}
	
	public String getDb2() {
		MySysConfig config = new MySysConfig();
		
		Session session = config.getSessionFactory(dataSource).openSession();
		
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		Query query = em.createNativeQuery("select version()");
		
		String result =(String) query.getSingleResult();
		session.close();
		return result;
	
	}
    public SessionFactory getSessionFactory( DataSource dataSource) {
		LocalSessionFactoryBean sessionBean = new LocalSessionFactoryBean();	
		sessionBean.setDataSource(dataSource);	
		sessionBean.setPackagesToScan("spittr.domain");
	    Properties props = new Properties();
	    props.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
	    sessionBean.setHibernateProperties(props);
	    try {
			sessionBean.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		System.out.println(sessionBean);
		
		if(sessionBean.getObject() ==null) {
			System.out.println("NULL");
		}else {
			System.out.println("not null");
		}
		return sessionBean.getObject() ; 
    }
    

	public  DataSource getDataSource() {
		
		BasicDataSource  dataSource = new BasicDataSource();
		
		dataSource.setUrl("jdbc:mysql://localhost/OBAPP?serverTimezone=UTC&useSSL=false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");	
		dataSource.setUsername("sa");
		dataSource.setPassword("sa1217");
		
		return dataSource;
	}

	

}
