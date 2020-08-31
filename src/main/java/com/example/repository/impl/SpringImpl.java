package com.example.repository.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;


import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.datasource.MyDataSource;
import com.example.entity.Bookstore;
import com.example.repository.BookstoreRepository;
import com.example.repository.ISpring;
import com.example.util.Counter;
import com.example.config.MySysConfig;

@Service
public class SpringImpl implements ISpring ,Serializable{
	static final long serialVersionUID = 1L;
	@Autowired
	MyDataSource dataSource;
	@Autowired
	SessionFactory factory;
	
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
		//properties 在persistence.xml中已設定 ，所以可以不用加入
		EntityManagerFactory  emf  = Persistence.createEntityManagerFactory("SpringJPA",properties);
		EntityManager em2 = emf.createEntityManager();
	
		 em2.getTransaction().begin();
		Query query = em2.createQuery("delete From Bookstore where bid=:bid");
		query.setParameter("bid", "1012345096");
		query.executeUpdate();
		em2.getTransaction().commit();
	
		//String result =(String) query.getSingleResult();	
		emf.close();
		return "VV";
	
	}
	
	
	// 這裡的EntityManager為共用，Not allowed to create transaction on shared EntityManager
	public String getDb3() {
		String sql = "select version()";
		String sql2 ="delete From Bookstore where bid=:bid";
		em.getTransaction().begin();
		Query query = em.createQuery(sql2);			
		query.setParameter("bid", "1012345086");
		query.executeUpdate();
		em.getTransaction().commit();
		//String result =(String) query.getSingleResult();	
		return "VVV";
	}
	
	public String getDb2() {
	

		MySysConfig config = new MySysConfig();
		
		Session session = config.getSessionFactory(dataSource).openSession();
		
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNativeQuery("delete from bookstore where bid='1012345092'");
		int exeResult = query.executeUpdate();
		em.getTransaction().commit();
		em.close();		
		session.close();
		
		/*	
		EntityManager em2  =factory.createEntityManager();
		em2.getTransaction().begin();
		Query query = em2.createNativeQuery("delete from bookstore where bid='1012345092'");
		int exeResult = query.executeUpdate();
		em2.getTransaction().commit();
		em2.close();
		*/
		
		return String.valueOf(exeResult);
	
	}

	/**
	 * Entity.merage：有則更新，無則新增
	 * call update前先判斷該資料存在才可呼叫update
	 * EntityManager 使用完畢需close，否則後序的update會塞住
	 */
	public int update(Bookstore bookstore) {//MySysConfig config = new MySysConfig();
		int executeResult =0;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Counter cnt = new Counter();
		bookstore.setVersion(cnt.toString());

		// 使用merage，有則更新，無則新增
		// 在呼叫update前，先
		Bookstore resultBs = em.merge(bookstore);
		
		if(resultBs!=null) {
			System.out.println(resultBs.getBid());
			executeResult = 1;
		}else {
			executeResult = 0;
		}
		/*
		//Query query = em.createNativeQuery("update bookstore set bookname=? , author=? , publisher=? , price=? , version=?  where bid=?");
	
		query.setParameter(1, bookstore.getBookname() );
		query.setParameter(2,bookstore.getAuthor());
		query.setParameter(3, bookstore.getPublisher());
		query.setParameter(4,bookstore.getPrice());
		query.setParameter(5, cnt.toString());
		query.setParameter(6, bookstore.getBid() );		
		executeResult = query.executeUpdate();
		*/
		em.getTransaction().commit();
		em.close();
		
		cnt.setAmount();
		System.out.println(cnt.getAmount());
		
		return executeResult;
	}
	/**
	 * em.createNamedQuery：映射@NamedQuery 文件的query語句, 可設定多組，應需求映射所要的query
	 * em.createNativeQuery：使用查詢語句
	 */
	public Bookstore find(String bid) {		
		EntityManager em =  factory.createEntityManager(); 
		
		Query query = em.createNamedQuery("Bookstore.getone", Bookstore.class);
		query.setParameter("bid", bid);
		
	//	Query query = em.createNativeQuery("select bid, bookname , author, publisher , price , version from bookstore where bid=:bid" , Bookstore.class);
	//	query.setParameter("bid", bid);
		
		List<Bookstore> resultLists =(List<Bookstore>) query.getResultList();
		Bookstore exeResult = new Bookstore();
		if(resultLists.size()>0) {
			exeResult = (Bookstore)resultLists.get(0);
		}else {
			exeResult = null;
		}
			
		em.close();		
		return exeResult;
	}
	public List<Bookstore> getBookstoreAll(){
		EntityManager em =  factory.createEntityManager(); 
		
		Query query = em.createNamedQuery("Bookstore.findAll", Bookstore.class);
		List<Bookstore> resultLists =(List<Bookstore>) query.getResultList();
		return resultLists;
	}
}
