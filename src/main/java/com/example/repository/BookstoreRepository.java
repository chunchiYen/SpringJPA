package com.example.repository;

import com.example.entity.Bookstore;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Configuration
@Component
@Repository
public interface BookstoreRepository  extends JpaRepository<Bookstore, String> {

	List<Bookstore> findAll();
	List<Bookstore> findAll(Sort sort);

	//void deleteById(String bid) ;

	
	@SuppressWarnings("unchecked")
	Bookstore save(Bookstore bs);
		
	@Query(value = "select b.* from bookstore b where b.bid =:bid", nativeQuery = true)
	Bookstore selectByBid(String bid);
	
	@Query(value ="select count(*) from Bookstore" ,  nativeQuery = true)
	int getCount();

	@Query(value="select bookname from Bookstore limit 1" ,   nativeQuery = true)
	public String showmethmoney();
	
	public Bookstore getOne(String bid);
	
	//public Bookstore findByIndex(String bid) ;
}
