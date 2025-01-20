package peaksoft.dao;

import peaksoft.entities.Customer;
import peaksoft.entities.RentInfo;

public interface CustomerDao {
    void saveCustomer(Customer customer);
    void saveCustomerWithRentInfo(Customer customer, RentInfo rentInfo);
}
