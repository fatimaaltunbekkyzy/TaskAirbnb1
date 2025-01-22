package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.AddressDao;
import peaksoft.entities.Address;
import peaksoft.entities.Agency;

import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl  implements AddressDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();


    @Override
    public List<Address> getAllAddress() {
        List<Address> addresses = new ArrayList<>();
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            addresses = entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Error occurred while fetching agencies: " + e.getMessage());
        }

        return addresses;
    }

    @Override
    public void updateAddress(Address address, Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Address updatedAddress = entityManager.find(Address.class, id);
            updatedAddress.setStreet(address.getStreet());
            updatedAddress.setCity(address.getCity());
            updatedAddress.setRegion(address.getRegion());
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void deleteAddress(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Address address = entityManager.find(Address.class, id);
            if (address != null) {
                entityManager.remove(address);
            }
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //Колдонуучу бир шаардын атын жазса ошол шаарда канча агентсво бар экенин эсептеп чыгарсын
    @Override
    public long countAgenciesInCity(String city) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Long count = entityManager.createQuery(
                            "SELECT COUNT(ag) FROM Agency ag JOIN ag.address a WHERE a.city = :city", Long.class)
                    .setParameter("city", city)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            System.out.println("Error while counting agencies in city: " + e.getMessage());
            return 0;
        }
}}