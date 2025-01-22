package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.CustomerDao;
import peaksoft.entities.Agency;
import peaksoft.entities.Customer;
import peaksoft.entities.House;
import peaksoft.entities.RentInfo;

import java.time.LocalDate;

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
    }}

    @Override
    public void saveCustomerWithRentInfo(Customer customer, Long houseId, Long agencyId, Long rentId, LocalDate checkIn,LocalDate checkOut) {
        RentInfo rentInfo = entityManagerFactory.createEntityManager().find(RentInfo.class, rentId);
        House house = entityManagerFactory.createEntityManager().find(House.class, houseId);
        Agency agency = entityManagerFactory.createEntityManager().find(Agency.class, agencyId);

        customer.setRentInfo(rentInfo);
        customer.setHouse(house);
        customer.setAgency(agency);
//        customer.setCheckIn(checkIn);
//        customer.setCheckOut(checkOut);

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(rentInfo);
            entityManager.persist(customer);
            entityManager.persist(house);
            entityManager.getTransaction().commit();
            System.out.println("Successfully saved the customer");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
    }
}}
