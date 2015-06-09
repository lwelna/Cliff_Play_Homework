package configs;

import org.springframework.orm.jpa.vendor.Database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import play.Play;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TestDataConfig {
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(false);
        vendorAdapter.setDatabase(Database.H2);
        // Necessary for h2 database in test for table creation!
        vendorAdapter.setGenerateDdl(true);

        // Scanned packages are hard-coded in test
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("models");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    // Thread-safety
    private DataSource ds = null;

    @Bean
    public DataSource dataSource() {
        // Avoid synchronization when not necessary
        if (ds == null) {
                // Necessary to avoid lock race causing double initialization.
                if (ds == null) {
                    // Delete any existing databases before starting
                    new java.io.File("testdb.h2.db").delete();

                    // Not pooled!
                    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
                    dataSource.setDriverClassName("org.h2.Driver");
                    dataSource.setUrl("jdbc:h2:mem:play;MODE=MYSQL;DB_CLOSE_DELAY=-1");

                    // Assign after all of the configuration is complete to avoid races.
                    ds = dataSource;
                }
        }
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
