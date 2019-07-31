package com.svprdga.vertxspring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.core.io.ClassPathResource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.init.DatabasePopulator
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.sql.DataSource

/**
 * Simple Java Spring configuration to be used for the Spring example application. This configuration is mainly
 * composed of a database configuration and initial population via the script "products.sql" of the database for
 * querying by our Spring service bean.
 *
 * The Spring service bean and repository are scanned for via @EnableJpaRepositories and @ComponentScan annotations
 */
@Configuration
@EnableJpaRepositories(basePackages = ["com.svprdga.vertxspring.datasource"])
@PropertySource(value = ["classpath:application.properties"])
@ComponentScan("com.svprdga.vertxspring.service")
class SpringConfig {

    @Autowired
    private val env: Environment? = null

    @Bean
    @Autowired
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(env!!.getProperty("jdbc.driverClassName")!!)
        dataSource.url = env.getProperty("jdbc.url")
        dataSource.username = env.getProperty("jdbc.username")
        dataSource.password = env.getProperty("jdbc.password")
        return dataSource
    }

    @Bean
    @Autowired
    fun entityManagerFactory(dataSource: DataSource): LocalContainerEntityManagerFactoryBean {
        val factory = LocalContainerEntityManagerFactoryBean()
        factory.dataSource = dataSource
        val vendorAdapter = HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl(java.lang.Boolean.TRUE)
        vendorAdapter.setShowSql(java.lang.Boolean.TRUE)
        factory.dataSource = dataSource
        factory.jpaVendorAdapter = vendorAdapter
        factory.setPackagesToScan("com.svprdga.vertxspring.model")
        val jpaProperties = Properties()
        jpaProperties["hibernate.hbm2ddl.auto"] = env!!.getProperty("hibernate.hbm2ddl.auto")
        jpaProperties["hibernate.show_sql"] = env.getProperty("hibernate.show_sql")
        factory.setJpaProperties(jpaProperties)
        return factory
    }

    @Bean
    @Autowired
    fun transactionManager(entityManagerFactory: LocalContainerEntityManagerFactoryBean): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory.getObject()!!)
    }
}
