package com.example.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.example.vo.BookAuthor;

@Configuration

//@Repository
@Component
public interface BookAuthorRepository{
	
	List<BookAuthor> searchAll();
	
	
}
