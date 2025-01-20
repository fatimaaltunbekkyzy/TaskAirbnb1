package peaksoft.dao;

import peaksoft.entities.Agency;
import peaksoft.entities.RentInfo;

import java.time.LocalDate;
import java.util.List;

public interface RentInfoDao {

    void saveRentInfo(RentInfo rentInfo);

    void deleteRentInfo(Long id);

    List<RentInfo> getRentInfosByDateRange(LocalDate startDate, LocalDate endDate);

    Long countActiveRentInfosByAgency(Long agencyId);
}
