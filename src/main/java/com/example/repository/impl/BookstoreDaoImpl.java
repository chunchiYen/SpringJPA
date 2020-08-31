package com.example.repository.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.repository.IBookstoreDao;
@Configuration
@Service("daoImpl")
@Repository
public abstract  class BookstoreDaoImpl implements IBookstoreDao {
	@PersistenceContext
	EntityManager em;

}
