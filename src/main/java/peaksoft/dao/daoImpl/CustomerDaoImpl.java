package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.CustomerDao;
import peaksoft.entities.Customer;
import peaksoft.entities.RentInfo;

public class CustomerDaoImpl implements CustomerDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public void saveCustomer(Customer customer) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void saveCustomerWithRentInfo(Customer customer, RentInfo rentInfo) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(rentInfo);
            entityManager.persist(customer);

            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
    }
}}
