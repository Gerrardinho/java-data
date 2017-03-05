package org.luger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by gerardo8.
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Value("${dataSource.driver_class_name}")
    private String DATA_SOURCE_DRIVER_CLASS_NAME;

    @Value("${dataSource.url}")
    private String DATA_SOURCE_URL;

    @Value("${dataSource.username}")
    private String DATA_SOURCE_USERNAME;

    @Value("${dataSource.password}")
    private String DATA_SOURCE_PASSWORD;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${hibernate.default_schema}")
    private String HIBERNATE_DEFAULT_SCHEMA;

    @Value("${hibernate.hbm2dll.create_namespaces}")
    private String HIBERNATE_HBM2DLL_CREATE_NAMESPACES;

    @Value("${packagesToScan}")
    private String PACKAGES_TO_SCAN;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DATA_SOURCE_DRIVER_CLASS_NAME);
        dataSource.setUrl(DATA_SOURCE_URL);
        dataSource.setUsername(DATA_SOURCE_USERNAME);
        dataSource.setPassword(DATA_SOURCE_PASSWORD);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager =
            new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", HIBERNATE_DIALECT);
                setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
                setProperty("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
                setProperty("hibernate.hbm2dll.create_namespaces", HIBERNATE_HBM2DLL_CREATE_NAMESPACES);
//                setProperty("hibernate.default_schema", HIBERNATE_DEFAULT_SCHEMA);
            }
        };
    }

}
