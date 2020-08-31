package com.example.repository.impl;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import com.example.entity.Bookstore;
import com.example.repository.BookstoreRepository;
import com.example.util.MyStringUtils;


@Configuration
@Service("boo")
public abstract   class BookstoreRepositoryImpl  implements BookstoreRepository{
	
	@PersistenceContext
	EntityManager em ;
	
	
	public String showmethemoney2() {
		return "show me the money";
	}
	

/*	
	public Bookstore findByIndex(String bid) {		

		String sql = String.format("select a from bookstore　a where a.bid='"+  bid +"'");
		System.out.println("sql: " +sql);
		
		Query query = em.createNamedQuery(sql);
		 if( query.getResultList().size() >0 ) {
			 
			 return null;
		 }
		return (Bookstore)query.getResultList().get(0);
	}
	*/
	public String getSql( Bookstore bookstore){
		
		
		StringBuilder conditions = new StringBuilder();
		Map<String , Object> conditionMap = new HashMap<String,Object>();
		String columns ="";
		String sql ="";
		
		if( MyStringUtils.isEmptyOrNull(bookstore.getBid()) ) {
			return null;
		}else if( bookstore.getBid().length()>10 ){
			return null;
		}else {
		
			conditionMap.put("bid", bookstore.getBid());
			conditions.append(bookstore.getBid());
			columns = columns + "bid ";
			
			if(!MyStringUtils.isEmptyOrNull(bookstore.getBookname())) {
				conditionMap.put("Bookname", bookstore.getBookname());
				conditions.append(" ,");
				conditions.append(bookstore.getBookname());
				columns = columns + " ,Bookname";
			}
			if(!MyStringUtils.isEmptyOrNull(bookstore.getAuthor()) ) {
				conditionMap.put("Author", bookstore.getAuthor());
				conditions.append(" ,");
				conditions.append(bookstore.getAuthor());
				columns = columns + " ,Author";
			}
			if(!MyStringUtils.isEmptyOrNull(bookstore.getPublisher()) ) {
				conditionMap.put("Publisher", bookstore.getPublisher());
				conditions.append(" ,");
				conditions.append(bookstore.getPublisher());
				columns = columns + " ,Publisher";
			}
			if(bookstore.getPrice() == null ) {
				conditionMap.put("Price", bookstore.getPrice()==null ? 0 : bookstore.getPrice());
				conditions.append(" ,");
				conditions.append(bookstore.getPrice()==null ? 0 : bookstore.getPrice().intValue());
				columns = columns + " ,Price";
			}
			if(!MyStringUtils.isEmptyOrNull(bookstore.getVersion()) ) {
				conditionMap.put("Version", bookstore.getVersion());
				conditions.append(" ,");
				conditions.append(bookstore.getVersion());
				columns = columns + " ,Version";
			}
		}
		
		
		
		sql =String.format("Insert into Bookstore(%1$s)values(%2$s)", columns , conditions.toString());
		
		return sql;
	}
	
}
