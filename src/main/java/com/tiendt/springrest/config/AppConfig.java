package com.tiendt.springrest.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.tiendt.springrest")
@PropertySource({"classpath:persistence-mysql.properties"})
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource theDataSource() {
		ComboPooledDataSource theDataSource = new ComboPooledDataSource();
		
		try {
			theDataSource.setDriverClass(env.getProperty("jdbc.Driver"));
		} catch (PropertyVetoException exc) {
			exc.printStackTrace();
		}
		
		theDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		theDataSource.setUser(env.getProperty("jdbc.user"));
		theDataSource.setPassword(env.getProperty("jdbc.password"));
		
		theDataSource.setInitialPoolSize(toInt("connection.pool.InitialPoolSize"));
		theDataSource.setMinPoolSize(toInt("connection.pool.MinPoolSize"));
		theDataSource.setMaxPoolSize(toInt("connection.pool.MaxPoolSize"));
		theDataSource.setMaxIdleTime(toInt("connection.pool.MaxIdleTime"));
		
		return theDataSource;
	}
	
	public int toInt(String data) {
		String str = env.getProperty(data);
		int theData = Integer.parseInt(str);
		
		return theData;
	}
	
	//Hibernate Config
	@Bean
	public Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return prop;
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		factoryBean.setDataSource(theDataSource());
		factoryBean.setPackagesToScan(env.getProperty("hibernate.package_to_scan"));
		factoryBean.setHibernateProperties(getHibernateProperties());
		
		return factoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txtManger = new HibernateTransactionManager();
		
		txtManger.setSessionFactory(sessionFactory);
		
		return txtManger;
	}
	
	
	
	
	
	
	
}











