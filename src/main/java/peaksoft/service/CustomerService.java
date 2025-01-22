package peaksoft.service;

import peaksoft.entities.Customer;
import peaksoft.entities.RentInfo;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void saveCustomerWithRentInfo(Customer customer,Long houseId, Long agencyId,Long rentInfoId);
}
