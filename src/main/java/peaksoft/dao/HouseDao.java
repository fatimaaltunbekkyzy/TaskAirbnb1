package peaksoft.dao;

import peaksoft.entities.Agency;
import peaksoft.entities.House;

import java.util.List;

public interface HouseDao {
    void saveHouse(House house);

    List<House> getAllHouse();

    void deleteHouse(Long id);
}
