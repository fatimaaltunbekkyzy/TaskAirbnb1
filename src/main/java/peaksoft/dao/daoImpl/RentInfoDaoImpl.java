package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.RentInfoDao;
import peaksoft.entities.Agency;
import peaksoft.entities.RentInfo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class RentInfoDaoImpl implements RentInfoDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public void saveRentInfo(RentInfo rentInfo) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(rentInfo);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRentInfo(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            RentInfo rentInfo = entityManager.find(RentInfo.class, id);
            if (rentInfo != null) {
                entityManager.remove(rentInfo);
            }
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
    // Даталар ортосундагы RentInfo объекттерин табуу
    @Override
    public List<RentInfo> getRentInfosByDateRange(LocalDate startDate, LocalDate endDate) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            // SQL запросу аркылуу текшерүү жана чыгуучу күндөрүнүн ортосундагы RentInfo объекттерин табуу
            List<RentInfo> rentInfos = entityManager.createQuery(
                            "SELECT r FROM RentInfo r WHERE (r.checkin BETWEEN :startDate AND :endDate) OR (r.checkOut BETWEEN :startDate AND :endDate)", RentInfo.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();

            entityManager.getTransaction().commit();
            return rentInfos;

        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    // Агенттик боюнча активдүү RentInfo санын алуу
    @Override
    public Long countActiveRentInfosByAgency(Long agencyId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            // Агенттиктин IDсине жана учурдагы күнгө ылайык активдүү RentInfo объектиси
            long count = entityManager.createQuery(
                            "SELECT COUNT(r) FROM RentInfo r WHERE r.agency.id = :agencyId AND r.checkOut >= :currentDate", Long.class)
                    .setParameter("agencyId", agencyId)
                    .setParameter("currentDate", LocalDate.now())
                    .getSingleResult();

            entityManager.getTransaction().commit();
            return count;

        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
            return 0L;
        }

}}