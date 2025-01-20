package peaksoft.service.serviceImpl;

import peaksoft.dao.RentInfoDao;
import peaksoft.dao.daoImpl.RentInfoDaoImpl;
import peaksoft.entities.RentInfo;
import peaksoft.service.RentInfoService;

import java.time.LocalDate;
import java.util.List;

public class RentInfoServiceImpl implements RentInfoService {
    RentInfoDao rentInfoDao = new RentInfoDaoImpl();
    @Override
    public void saveRentInfo(RentInfo rentInfo) {
     rentInfoDao.saveRentInfo(rentInfo);
    }

    @Override
    public void deleteRentInfo(Long id) {
    rentInfoDao.deleteRentInfo(id);
    }

    @Override
    public List<RentInfo> getRentInfosByDateRange(LocalDate startDate, LocalDate endDate) {
        return rentInfoDao.getRentInfosByDateRange(startDate, endDate);
    }

    @Override
    public Long countActiveRentInfosByAgency(Long agencyId) {
        return rentInfoDao.countActiveRentInfosByAgency(agencyId);
    }
}
