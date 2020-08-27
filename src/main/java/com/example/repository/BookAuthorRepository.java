package com.example.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.vo.BookAuthor;

@Configuration

//@Repository
@Component
public interface BookAuthorRepository{
	
	List<BookAuthor> searchAll();
	
	
}
