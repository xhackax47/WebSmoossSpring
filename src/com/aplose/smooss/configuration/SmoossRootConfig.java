package com.aplose.smooss.configuration;

import java.util.Properties;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.aplose.smooss.*" })
@EnableTransactionManagement
@PropertySource("classpath:/META-INF/spring/database.properties")
public class SmoossRootConfig {

	@Value("${database.driverClassName}")
	private String driverClassName;
	@Value("${database.url}")
	private String Url;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driverClassName);
		dataSource.setUsername(this.username);
		dataSource.setUrl(this.Url);
		dataSource.setPassword(this.password);

		return dataSource;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException {
		JpaTransactionManager jpaTransaction = new JpaTransactionManager();
		jpaTransaction.setEntityManagerFactory(emf);

		return jpaTransaction;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEMF() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPersistenceUnitName("spring-smooossJpa-unit");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.format_sql", "false");
		jpaProperties.put("javax.persistence.schema-generation.database.action", "none");
		emf.setJpaProperties(jpaProperties);

		return emf;
	}


}
