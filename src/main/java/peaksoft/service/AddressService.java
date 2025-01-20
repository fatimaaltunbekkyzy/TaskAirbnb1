package peaksoft.service;

import peaksoft.entities.Address;

import java.util.List;

public interface AddressService {
   // void saveAddress(Address address);

    List<Address> getAllAddress();

    void updateAddress(Address address,Long id);

    void deleteAddress(Long id);

    long countAgenciesInCity(String city);
}
