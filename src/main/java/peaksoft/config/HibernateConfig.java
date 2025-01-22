package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entities.*;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManagerFactory getEntityManagerFactory() {
        try{
            Properties properties = new Properties();
            properties.put(Environment.JAKARTA_JDBC_DRIVER,"org.postgresql.Driver");
            properties.put(Environment.JAKARTA_JDBC_URL,"jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.JAKARTA_JDBC_USER,"postgres");
            properties.put(Environment.JAKARTA_JDBC_PASSWORD,"1234");
            properties.put(Environment.HBM2DDL_AUTO,"update");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL,"true");

            Configuration configuration = new Configuration();
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Agency.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(RentInfo.class);

            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(House.class);
           configuration.addAnnotatedClass(Owner.class);


            return  configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
}}
