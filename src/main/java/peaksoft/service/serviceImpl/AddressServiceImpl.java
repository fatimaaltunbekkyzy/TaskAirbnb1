package peaksoft.service.serviceImpl;

import peaksoft.dao.AddressDao;
import peaksoft.dao.daoImpl.AddressDaoImpl;
import peaksoft.entities.Address;
import peaksoft.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    AddressDao addressDao = new AddressDaoImpl();
//    @Override
//    public void saveAddress(Address address) {
//        addressDao.saveAddress(address);
//    }

    @Override
    public List<Address> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public void updateAddress(Address address, Long id) {
    addressDao.updateAddress(address, id);
    }

    @Override
    public void deleteAddress(Long id) {
    addressDao.deleteAddress(id);
    }

    @Override
    public long countAgenciesInCity(String city) {
        return addressDao.countAgenciesInCity(city);
    }
}
