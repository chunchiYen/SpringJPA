package com.example.repository.impl;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.repository.IBookstoreDao;

@Service("dao2")
@Repository
public abstract  class BookstoreDaoImpl implements IBookstoreDao {
	/*
	public String toShowInfo() {
		return "Show Info";
	}
	*/


	/*
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
	*/
}
