package cz.greca.tabor.skladGre.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "cz.greca.tabor.skladGre")
@EnableJpaRepositories(basePackages = "cz.greca.tabor.skladGre.repository")
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// GRE: varianta kdy jsem pouzival DB HSQLBD a data pouze v pameti, ktere se
	// inicializovala v service InitDbService, a v pom byla pro to nejaka
	// dependence
	// @Bean
	// public DataSource dataSource() {
	// BasicDataSource dataSource = new BasicDataSource();
	// dataSource.setUrl("jdbc:hsqldb:mem:test");
	// dataSource.setUsername("sa");
	// dataSource.setPassword("");
	// return dataSource;
	// }

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/greca");
		dataSource.setUsername("skladnik");
		dataSource.setPassword("gregre");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan("cz.greca.tabor.skladGre.entity");
		emf.setPersistenceProvider(new HibernatePersistenceProvider());
		Properties jpaProperties = new Properties();
		// GRE: toto vzdy pri vzniku entityManageru vytvori znova celou db ...
		// takze vse smaze
		// jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		jpaProperties.setProperty("hibernate.show_sql", "false");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		emf.setJpaProperties(jpaProperties);
		emf.setDataSource(dataSource);
		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}