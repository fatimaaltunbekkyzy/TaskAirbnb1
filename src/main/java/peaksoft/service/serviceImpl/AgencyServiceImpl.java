package peaksoft.service.serviceImpl;

import peaksoft.dao.AgencyDao;
import peaksoft.dao.daoImpl.AgencyDaoImpl;
import peaksoft.entities.Agency;
import peaksoft.service.AgencyService;

import java.util.List;

public class AgencyServiceImpl implements AgencyService {
    AgencyDao agencyDao = new AgencyDaoImpl();
    @Override
    public void saveAgency(Agency agency) {
        agencyDao.saveAgency(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return agencyDao.getAllAgency();
    }

    @Override
    public void deleteAgency(Long id) {
        agencyDao.deleteAgency(id);
    }
}
