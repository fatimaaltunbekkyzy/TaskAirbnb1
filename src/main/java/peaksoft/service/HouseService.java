package peaksoft.service;

import peaksoft.entities.House;

import java.util.List;

public interface HouseService {
    void saveHouse(House house);

    List<House> getAllHouse();

    void deleteHouse(Long id);
}
