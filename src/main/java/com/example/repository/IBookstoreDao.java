package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.Bookstore;
@Service("dao")
@Repository
public interface IBookstoreDao extends JpaRepository<Bookstore, String>{
		
	@Query(value="select * from bookstore" , nativeQuery = true)
	List<Bookstore> searchMyAll();	
/*	
	@Query(value="select 'showmeinfo'" , nativeQuery = true)
	String toShowInfo();	
*/
	List<Bookstore> findAll();
	Bookstore getOne(String bid);
	
	boolean existsById(String bid);
	
	@Query(value = "select * from bookstore where bid=:bid" , nativeQuery = true)
	Bookstore getMyBook(String bid);
	
	List<Bookstore> findByAuthorContaining(String bookname);
	List<Bookstore> findByBooknameContaining(String bookname);
	
	@Query(value="select * from bookstore where author like :author" , nativeQuery=true)
	List<Bookstore> findByLikeAuthor(String author);

}
