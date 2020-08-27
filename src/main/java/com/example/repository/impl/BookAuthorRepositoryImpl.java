package com.example.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Configuration;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import com.example.repository.BookAuthorRepository;
import com.example.vo.BookAuthor;


@Service
@Configuration

public abstract class BookAuthorRepositoryImpl implements BookAuthorRepository{

	@PersistenceContext
	EntityManager em ;
	

	public List<BookAuthor> searchAll(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("select a.* , b.*  from bookstore a left join authors b on a.author = b.authorname");
	
		Query query = em.createQuery(sql.toString());
		return (List<BookAuthor>)query.getResultList();
		
	}
	
	
}

