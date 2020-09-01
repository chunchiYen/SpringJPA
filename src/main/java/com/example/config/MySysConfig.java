package com.example.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class MySysConfig {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;


	@Bean(name = "dataSource")
	public  DataSource getDataSource() {
		DriverManagerDataSource   dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClass);	
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	 @Bean(name = "transactionManager")	
	public DataSourceTransactionManager transactionManager() {
		 return new DataSourceTransactionManager(getDataSource());

	 }
	 /**
	  * @Bean, 使用@Autowired 時未使用@Qualifier指定bean，應該會先捉取有 @Primary的Bean
	  * @param dataSource
	  * @return
	  */
	@Bean(name = "sessionFactory01")	
	@Primary
    public SessionFactory getSessionFactory( DataSource dataSource){
		LocalSessionFactoryBean sessionBean = new LocalSessionFactoryBean();	
		sessionBean.setDataSource(dataSource);
		sessionBean.setPackagesToScan("com.example");
		
	  Properties props = new Properties();
	  props.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
	 sessionBean.setHibernateProperties(props);
		 try {
				sessionBean.afterPropertiesSet();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
		return sessionBean.getObject() ; 
    }
	/**
	 * 從cfg.xml取得設定
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "sessionFactory02")	
    public SessionFactory catchSessionFactory( DataSource dataSource){
		LocalSessionFactoryBean sessionBean = new LocalSessionFactoryBean();	
		sessionBean.setDataSource(dataSource);
	    
	    sessionBean.setConfigLocation((org.springframework.core.io.Resource) new ClassPathResource("cfg.xml"));
	  
		sessionBean.setPackagesToScan("com.example");
	
	  Properties props = new Properties();
	  props.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
	 sessionBean.setHibernateProperties(props);
		 try {
				sessionBean.afterPropertiesSet();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
		return sessionBean.getObject() ; 
    }

	@Bean (name="entityManagerFactory")
	public EntityManagerFactory getEntityManagerFactory(SessionFactory sf) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.user", "sa");
		properties.put("javax.persistence.jdbc.password", "sa1217");
		EntityManagerFactory  emf  = Persistence.createEntityManagerFactory("SpringJPA",properties);
		
		
		return emf;
	}
}
