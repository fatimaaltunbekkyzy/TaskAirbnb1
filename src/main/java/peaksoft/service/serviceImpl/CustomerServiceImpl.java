package peaksoft.service.serviceImpl;

import peaksoft.dao.CustomerDao;
import peaksoft.dao.daoImpl.CustomerDaoImpl;
import peaksoft.entities.Customer;
import peaksoft.entities.RentInfo;
import peaksoft.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void saveCustomerWithRentInfo(Customer customer, RentInfo rentInfo) {
customerDao.saveCustomerWithRentInfo(customer, rentInfo);
    }
}
