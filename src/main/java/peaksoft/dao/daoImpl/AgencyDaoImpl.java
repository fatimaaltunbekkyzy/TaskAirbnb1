package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.AgencyDao;
import peaksoft.entities.Agency;

import java.util.ArrayList;
import java.util.List;

public class AgencyDaoImpl implements AgencyDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public void saveAgency(Agency agency) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(agency);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
    }}

    @Override
    public List<Agency> getAllAgency() {
        List<Agency> agencies = new ArrayList<>();
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            agencies = entityManager.createQuery("SELECT a FROM Agency a", Agency.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Error while fetching agencies: " + e.getMessage());
        }

        return agencies;
    }

    @Override
    public void deleteAgency(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Agency agency = entityManager.find(Agency.class, id);
            if (agency != null) {
                entityManager.remove(agency);
            }
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
    }
}}
