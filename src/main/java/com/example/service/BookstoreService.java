package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.entity.Bookstore;
import com.example.repository.BookstoreRepository;
import com.example.repository.IBookstoreDao;
import com.example.repository.ISpring;
import com.example.util.MyStringUtils;
import com.example.util.SpringUtil;
import org.springframework.data.domain.Sort;

@Service
public class BookstoreService {
	@Autowired
	SpringUtil sprintUtil;
	
	@Autowired//(required=false)
	IBookstoreDao bookstoreDaoImpl;

	@Autowired
	ISpring springImpl;
	
	@Autowired
	BookstoreRepository bookstoreJpa;
	
	public List<Bookstore> getAll(){
		return bookstoreJpa.findAll();
	}
	
	public int getCount() {
		return bookstoreJpa.getCount();
	}

	
	public String showmethemoney() {
		return bookstoreDaoImpl.toShowInfo();
		//return bookstoreJpa.showmethmoney();
			
	}
	public int del(String id) {
		boolean result = false ;
		result = bookstoreJpa.existsById(id);
		if(result) {
			bookstoreJpa.deleteById(id);
			return 1;
		}else {
			return 0;
		}
	}
	public Bookstore save(Bookstore bs) {
		
		return bookstoreJpa.save(bs);
	}
	
	public List<Bookstore> getAll2(){		
		return bookstoreDaoImpl.findAll();
		//return bookstoreDaoImpl.searchMyAll();
	}

	public Bookstore save2(Bookstore bs) {		
		/*
		Bookstore bbs = new Bookstore();			
		bbs= bookstoreJpa.selectByBid(bs.getBid());	
		if( bbs !=null) {
			System.out.println(String.format(" Data index bid  %s exist " , bbs.getBid()));
			return null;
		}else {
			System.out.println(String.format(" Data index bid  %s will be inserted  " , bs.getBid()));
			if(getSql(bs)==null)
				return null;
			return bookstoreJpa.save(bs);	
		}
*/
		if(MyStringUtils.isEmptyOrNull(bs.getBid()))
			return null;
		if(bs.getBid().isEmpty()){
			System.out.println("IS EMPTY");
			return null;
		}
		boolean existFlag = false;
		existFlag = bookstoreJpa.existsById(bs.getBid());
		if(!existFlag) {
			return bookstoreJpa.save(bs);
		}else {
			return null;
		}
		
	}
	
	public List<Bookstore> getAll(Sort sort){		
		return bookstoreJpa.findAll(sort);
	}
	public String getString() {
		return springImpl.getString();
	}
	
	public List<Bookstore> getLikeBookname(String bookname){
		return bookstoreDaoImpl.findByBooknameContaining(bookname);
		//return bookstoreDaoImpl.findByAuthorContaining(bookname);
	}
	public Bookstore getMyBook(String bid) {
		return bookstoreDaoImpl.getMyBook(bid);
	}
	public String getDbVersion() {
		
		return String.format("MySQL Verion : %1$s", springImpl.getDbVersion() );
	}
	
	public String getDb2() {
		
		return String.format("MySQL Verion : %1$s", springImpl.getDb2() );
	}
	public String getDb3() {
		
		return String.format("MySQL Verion : %1$s", springImpl.getDb3() );
	}

	public String getSql( Bookstore bookstore){

		StringBuilder conditions = new StringBuilder();	
		String columns ="";
		String sql ="";
		
		if( MyStringUtils.isEmptyOrNull(bookstore.getBid()) ) {
			return null;
		}else if( bookstore.getBid().length()>10 ){
			return null;
		}else {
			conditions.append("'");
			conditions.append(bookstore.getBid());
			conditions.append("'");
			columns = columns + "bid ";
			
			if(!MyStringUtils.isEmptyOrNull(bookstore.getBookname())) {				
				conditions.append(" ,'");
				conditions.append(bookstore.getBookname());
				conditions.append("'");
				columns = columns + " ,Bookname";
			}
			if(!MyStringUtils.isEmptyOrNull(bookstore.getAuthor()) ) {			
				conditions.append(" ,'");
				conditions.append(bookstore.getAuthor());
				conditions.append("'");
				columns = columns + " ,Author";
				
			}
			if(!MyStringUtils.isEmptyOrNull(bookstore.getPublisher()) ) {				
				conditions.append(" ,'");
				conditions.append(bookstore.getPublisher());
				conditions.append("'");
				columns = columns + " ,Publisher";
			}
			if(bookstore.getPrice() == null ) {			
				conditions.append(" ,");
				conditions.append(bookstore.getPrice()==null ? 0 : bookstore.getPrice().intValue());
				columns = columns + " ,Price";
			}
			if(!MyStringUtils.isEmptyOrNull(bookstore.getVersion()) ) {				
				conditions.append(" ,'");
				conditions.append(bookstore.getVersion());
				conditions.append("'");
				columns = columns + " ,Version";
			}
		}
		
		
		
		sql =String.format("Insert into Bookstore(%1$s)values(%2$s)", columns , conditions.toString());
		
		return sql;
	}
}
