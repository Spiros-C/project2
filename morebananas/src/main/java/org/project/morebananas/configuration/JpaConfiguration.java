package org.project.morebananas.configuration;
//https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-one-configuration/

//configure the persistence layer of a Spring application that uses Spring Data JPA and Hibernate.

import com.zaxxer.hikari.HikariConfig;
import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
@EnableJpaRepositories(basePackages = "org.project.morebananas.repositories",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class JpaConfiguration {
    
        @Autowired
	private Environment environment;

//	@Value("${datasource.model.maxPoolSize:10}")
//	private int maxPoolSize;
        
//        @Bean
//	@Primary
//	@ConfigurationProperties(prefix = "datasource.model")
//        public DataSourceProperties dataSourceProperties(){
//        return new DataSourceProperties();
//        }
        
//        catch(HibernateException exception){
//     System.out.println("Problem creating session factory");
//     exception.printStackTrace();
//}
        	
	 // Configure HikariCP pooled DataSource.
	 
//	@Bean
//	public DataSource dataSource() {
//		DataSourceProperties dataSourceProperties = dataSourceProperties();
//			HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder
//					.create(dataSourceProperties.getClassLoader())
//					.driverClassName(dataSourceProperties.getDriverClassName())
//					.url(dataSourceProperties.getUrl())
//					.username(dataSourceProperties.getUsername())
//					.password(dataSourceProperties.getPassword())
//					.type(HikariDataSource.class)
//					.build();
//			dataSource.setMaximumPoolSize(maxPoolSize);
//			return dataSource;
//	}
        @Bean(destroyMethod = "close")
        DataSource dataSource(Environment env) {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
        dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
 
        return new HikariDataSource(dataSourceConfig);
    }

	/*
	 * Entity Manager Factory setup.
	 */
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
//		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setDataSource(dataSource());
//		factoryBean.setPackagesToScan(new String[] { "org.project.morebananas.entities" });
//		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//		factoryBean.setJpaProperties(jpaProperties());
//		return factoryBean;
//	}
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
                                                                Environment environment) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("org.project.morebananas.entities");
//        return factoryBean;
//    }
        Properties jpaProperties = new Properties();
     
        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
 
        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto", 
                environment.getRequiredProperty("hibernate.hbm2ddl.auto")
        );
 
        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        //https://www.devglan.com/hibernate/hibernate-naming-strategy
//        jpaProperties.put("hibernate.ejb.naming_strategy", 
//                environment.getRequiredProperty("hibernate.ejb.naming_strategy")
//        );
 
        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql", 
                environment.getRequiredProperty("hibernate.show_sql")
        );
 
        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql", 
                environment.getRequiredProperty("hibernate.format_sql")
        );
 
        factoryBean.setJpaProperties(jpaProperties);
 
        return factoryBean;
    }
	/*
	 * Provider specific adapter.
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		return hibernateJpaVendorAdapter;
	}

	/*
	 * Here you can specify any provider specific properties.
	 */
//	private Properties jpaProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.method"));
//		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
//		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//		if(StringUtils.isNotEmpty(environment.getRequiredProperty("defaultSchema"))){
//			properties.put("hibernate.default_schema", environment.getRequiredProperty("defaultSchema"));
//		}
//		return properties;
//	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}

}
