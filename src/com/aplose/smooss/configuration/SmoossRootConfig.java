package com.aplose.smooss.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.aplose.smooss.*" })
@EnableTransactionManagement

@PropertySources({
@PropertySource("classpath:/META-INF/spring/database.properties")
})

public class SmoossRootConfig {
	
	 @Autowired
     Environment env;


	@Value("${database.driverClassName}")
	private String driverClassName;
	@Value("${database.url}")
	private String url;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("spring-smooossJpa-unit");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("javax.persistence.jdbc.url", this.url);
		jpaProperties.setProperty("javax.persistence.jdbc.driver", this.driverClassName);
		jpaProperties.setProperty("javax.persistence.jdbc.user", this.username);
		jpaProperties.setProperty("javax.persistence.jdbc.password", this.password);
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.format_sql", "false");
		jpaProperties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
		jpaProperties.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
		jpaProperties.setProperty("javax.persistence.schema-generation.database.action", "none");
		jpaProperties.setProperty("hibernate.c3p0.max_size", "100");
		jpaProperties.setProperty("hibernate.c3p0.min_size", "0");
		jpaProperties.setProperty("hibernate.c3p0.acquire_increment", "1");
		jpaProperties.setProperty("hibernate.c3p0.idle_test_period", "300");
		jpaProperties.setProperty("hibernate.c3p0.max_statements", "0");
		jpaProperties.setProperty("hibernate.c3p0.timeout", "100");
		emf.setJpaProperties(jpaProperties);
		
		return emf;
	}
	
	@Bean
	public JpaTransactionManager getJpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		
		return transactionManager;
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();	  
	    mailSender.setHost("mail11.lwspanel.com");
	    mailSender.setPort(587);
	    mailSender.setUsername("contact@smooss.fr");
	    mailSender.setPassword("sB9_pF9Xc$");
	    
	    Properties props = new Properties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.debug", "true");
	    
	    
	    mailSender.setJavaMailProperties(props);
	    return mailSender;
	}

}
