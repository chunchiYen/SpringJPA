package com.example.repository.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.example.dao.entity.BookVo;
import com.example.datasource.MyDataSource;
import com.example.entity.Bookstore;
import com.example.repository.ISpring;
import com.example.util.Counter;

@Service
public class SpringImpl implements ISpring ,Serializable{
	static final long serialVersionUID = 1L;
	@Autowired
	MyDataSource dataSource;

	@PersistenceContext
	EntityManager em ;
	
	@Autowired
	EntityManagerFactory factory;
	
	@Autowired
	@Qualifier("sessionFactory02")
	SessionFactory sessionFactory;
	
	public String getString() {
		System.out.println("SpringImpl");
		return "SpringImpl";
	}
	
	// 使用 EntityManagerFactory 取得EntityManager進行查詢
	public String getDbVersion() {			
	
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.user", "sa");
		properties.put("javax.persistence.jdbc.password", "sa1217");
		//EntityManagerFactory  emf  = Persistence.createEntityManagerFactory("SpringJPA2",properties);
		
		//properties 在persistence.xml中已設定 ，所以可以不用加入
		EntityManagerFactory  emf  = Persistence.createEntityManagerFactory("SpringJPA");		
		EntityManager em2 = emf.createEntityManager();
	
		 em2.getTransaction().begin();
		 Bookstore bs = em2.find(Bookstore.class, "1012345092");
		 if(bs == null )
			 System.out.println("book is Null");
		 else
			 System.out.println(bs.getBid());
		 
		 Query query = em2.createNativeQuery("delete from Bookstore where bid=:bid");
		 query.setParameter("bid", "1012345092");
		 query.executeUpdate(); 
	
		 em2.getTransaction().commit();
		 em2.close();
	//	String result =(String) query.getSingleResult();	
		emf.close();
		return "VV";
	
	}
	
	
	// 這裡的EntityManager為共用，Not allowed to create transaction on shared EntityManager
	public String getDb2() {
		String sql2 ="delete From Bookstore where bid=:bid";
		em.getTransaction().begin();
		Query query = em.createQuery(sql2);			
		query.setParameter("bid", "1012345086");
		query.executeUpdate();
		em.getTransaction().commit();
		//String result =(String) query.getSingleResult();	
		return "VVV";
	}


	/**
	 * Entity.merage：有則更新，無則新增
	 * call update前先判斷該資料存在才可呼叫update
	 * EntityManager 使用完畢需close，否則後序的update會塞住
	 */
	// 從EntityManagerFactory Bean取的EntityManagerFactory
	public int update(Bookstore bookstore) {
		int executeResult =0;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Counter cnt = new Counter();
		bookstore.setVersion(cnt.toString());

		// 使用merage 更資料，有則更新，無則新增
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
	
	public int del(String sql) {
		EntityManager em2 = factory.createEntityManager();
		int result = toUpdate(em2 , sql);
		return result;
	}
	public int del2(String sql) {
		EntityManager em2 = factory.createEntityManager();
		EntityTransaction entityTransaction = em2.getTransaction();
		entityTransaction.begin();
		
		Bookstore bs = em2.find(Bookstore.class, "1012345092");
		 if(bs == null )
			 System.out.println("book is Null");
		 else
			 System.out.println(bs.getBid());
		 
		 Query query = em2.createNativeQuery("delete from Bookstore where bid='1012345092'");
		  query.executeUpdate(); 
		
		
		 //String sql = "delete from obapp.bookstore where bid='1012345092'";
		//Query query = em2.createNativeQuery(sql);
		//query.setParameter("bid", "1012345096");
		
		//query.executeUpdate();
	
		// em2.getTransaction().commit();
		  entityTransaction.commit();
		 em2.close();
		 
		
		int result = toUpdate(em2 , sql);
		return result;
	}
	public int toUpdate(EntityManager em2 , String sql) {		
		em2.getTransaction().begin();
		Query query = em2.createNativeQuery(sql);
		int result = query.executeUpdate(); 
		em2.getTransaction().commit();
		em2.close();
		return result;
	}
	
	public Bookstore useSessionFind(String bid) {

		Bookstore bookstore = new Bookstore();
		bookstore.setBid("1012345091");
		bookstore.setBookname("烤地瓜王國");
		bookstore.setAuthor("路邊攤");
		bookstore.setPublisher("社會天下");
		bookstore.setPrice(new BigDecimal(599));
		bookstore.setVersion("0.9");
		
		Session session = sessionFactory.openSession();
		
		Bookstore bs = new Bookstore();
	
		Transaction tc = session.beginTransaction();
		
		bs = session.find(Bookstore.class, bid);
		bs.setBookname("太古達人");
		bs.setPublisher(String.format("P-%d", System.currentTimeMillis() ));
		session.update(bs);			
		tc.commit();
		session.close();	
		
		return bs;
	
	}
	/**
	 * user createSQLQuery ResultList is present key-value to list, 
	 * can use .addEntity(entity.class)   ,  get  entity into list
	 */
	public List<BookVo> getAllWithAuthor() {
		
		Session session = sessionFactory.openSession();		
		Bookstore bs = new Bookstore();
		Transaction tc = session.beginTransaction();
		Query query = session.createSQLQuery("select b.bid , b.bookname , a.authorname as author , a.address from bookstore b , authors a where a.authorname = b.author").addEntity(BookVo.class);
		List<BookVo> lists =(List<BookVo> )query.getResultList();
		//session.getTransaction().commit();
		try {
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();			
		}
		session.close();	
		return lists;
	}
	
}
