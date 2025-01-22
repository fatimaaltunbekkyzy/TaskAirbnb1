package peaksoft.dao;

import peaksoft.entities.Customer;
import peaksoft.entities.RentInfo;

import java.time.LocalDate;

public interface CustomerDao {
    void saveCustomer(Customer customer);
    void saveCustomerWithRentInfo(Customer customer, Long houseId, Long agencyId, Long rentInfoId, LocalDate checkIn, LocalDate checkOut);
}
