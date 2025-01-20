package peaksoft.dao;

import peaksoft.entities.Address;
import peaksoft.entities.Agency;

import java.util.List;

public interface AgencyDao {
    void saveAgency(Agency agency);

    List<Agency> getAllAgency();

    void deleteAgency(Long id);
}
