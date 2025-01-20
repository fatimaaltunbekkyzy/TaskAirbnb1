package peaksoft.service;

import peaksoft.entities.RentInfo;

import java.time.LocalDate;
import java.util.List;

public interface RentInfoService {

    void saveRentInfo(RentInfo rentInfo);

    void deleteRentInfo(Long id);

    List<RentInfo> getRentInfosByDateRange(LocalDate startDate, LocalDate endDate);

    Long countActiveRentInfosByAgency(Long agencyId);
}
