package peaksoft.service;

import peaksoft.entities.Agency;

import java.util.List;

public interface AgencyService {
    void saveAgency(Agency agency);

    List<Agency> getAllAgency();

    void deleteAgency(Long id);
}
