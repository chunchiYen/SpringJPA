package com.example.transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TranscationUtils {
	
	
	public static int  update(EntityManager entityManager , String sql) {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery(sql);
		int result = query.executeUpdate(); 
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
	public static int  execute(EntityManager entityManager , String sql) {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery(sql);
		int result = query.executeUpdate(); 
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
}
