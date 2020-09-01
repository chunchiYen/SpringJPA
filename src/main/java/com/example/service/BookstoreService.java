package com.example.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.dao.entity.BookVo;
import com.example.entity.Bookstore;
import com.example.repository.BookstoreRepository;
import com.example.repository.IBookstoreDao;
import com.example.repository.ISpring;
import com.example.util.Counter;
import com.example.util.MyStringUtils;
import com.example.util.SpringUtil;
import org.springframework.data.domain.Sort;

@Service
public class BookstoreService  {
	private static final Logger logger = LoggerFactory.getLogger(BookstoreService.class);
		
	@Autowired
	SpringUtil sprintUtil;
	
	@Autowired
	//@Qualifier(value="daoImpl")
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
		//return bookstoreDaoImpl.toShowInfo();
		return "";
	}
	public int del(String bid) {
		boolean result = false ;
		result = bookstoreJpa.existsById(bid);
		System.out.println(result);
		if(result) {
			bookstoreJpa.deleteById(bid);
			return 1;
		}else {
			return 0;
		}
	}

	public int del2(String bid) {
		boolean exists = false ;
		int result = 0;
		exists = bookstoreJpa.existsById(bid);
		
		if(exists) {	
			String sql = String.format("delete from bookstore where bid=%s", bid);
			result = springImpl.del(sql);
			return result;
		}else {
			return result;
		}
	}
	public Bookstore save(Bookstore bs) {
		
		return bookstoreJpa.save(bs);
	}
	
	public List<Bookstore> getAll2(){		
		return bookstoreDaoImpl.findAll();	
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
			return null;
		}
		boolean existFlag = false;
		existFlag = bookstoreJpa.existsById(bs.getBid());
		if(!existFlag) {
			logger.info("Bookstore Insert Success bid :{}   , ",bs.getBid());
			return bookstoreJpa.save(bs);
		}else {
			logger.error("Bookstore Insert Fail ,  bid :{} exist",bs.getBid());
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

	public Bookstore getOne(String bid) {
		System.out.println("bookstore Service - > getOne");
		return bookstoreJpa.getOne(bid);
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
	
	public int update(Bookstore bookstore) {
		String id = bookstore.getBid();
		int result = 0;
		
		Bookstore resultBs = springImpl.find(id);
		if(resultBs != null) {
			System.out.println("1012345098 存在");
		
			System.out.println(resultBs.getBookname());
			int s = springImpl.update(bookstore);
			if(s>0) {
				result = 1;
			}else {
				result = 0;
			}
			
		}else {
			System.out.println("1012345098 不存在");
			result = 0;
		}
		return result;
		
		
		
	}
	public List<Bookstore>	getBookstoreAll(){

		return springImpl.getBookstoreAll();
	}
	
	public Bookstore sessionFind(String bid) {
		return springImpl.useSessionFind(bid);
	
	}
	public List<BookVo> getAllWithAuthor() {
		
		return springImpl.getAllWithAuthor();
	}
}
