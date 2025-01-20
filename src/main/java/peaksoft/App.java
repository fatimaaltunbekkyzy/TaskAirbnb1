package peaksoft;

import peaksoft.entities.*;
import peaksoft.enums.Gender;
import peaksoft.service.AddressService;
import peaksoft.service.AgencyService;
import peaksoft.service.CustomerService;
import peaksoft.service.RentInfoService;
import peaksoft.service.serviceImpl.AddressServiceImpl;
import peaksoft.service.serviceImpl.AgencyServiceImpl;
import peaksoft.service.serviceImpl.CustomerServiceImpl;
import peaksoft.service.serviceImpl.RentInfoServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
       // HibernateConfig.getEntityManagerFactory();
        //  AGENCY CLASS Agency тузулуп жатканда адреси кошо тузулсун!
            AgencyService agencyService = new AgencyServiceImpl();
            Agency agency1 = new Agency("Peaksoft","+996500360300");
            Agency agency2 = new Agency("Кызыл Алма","+996500300360");
            Agency agency3 = new Agency("GreenLing","+996500360390");
//      ADDRESS CLASS
          Address address1 = new Address("Гражданское 112","Bishkek","chui");
          Address address2 = new Address("Гражданское 119","Франция","Професор зима");
          Address address3 = new Address("Гражданское 120","Bishkek","chui");

          address1.setAgency(agency1);
          address2.setAgency(agency2);
          address3.setAgency(agency3);
          agency1.setAddress(address1);
          agency2.setAddress(address2);
          agency3.setAddress(address3);
          agencyService.saveAgency(agency1);
          agencyService.saveAgency(agency2);
          agencyService.saveAgency(agency3);
          //Agency очкондо адреси жана rent_info кошо очсун
          agencyService.getAllAgency();
          agencyService.deleteAgency(2L);

        AddressService addressService = new AddressServiceImpl();
        addressService.getAllAddress();
        addressService.deleteAddress(1L);
        addressService.countAgenciesInCity("Bishkek");
//        Agency agency = new Agency("Tил Академиясы", "+996500360300");
//        addressService.updateAddress(new Address(1L,"ПентХаус","Кореа","Нам Сан",agency);

        CustomerService customerService = new CustomerServiceImpl();
        RentInfoService rentInfoService = new RentInfoServiceImpl();
        // 1-ЖОЛ: Жөнөкөй Customer түзүү
        // Customer объектин түзүү
        Customer customer = new Customer("Adilet", "Egemberdiev", "a@email.com", "KG", LocalDate.of(1990, 5, 20), Gender.MALE);
        customerService.saveCustomer(customer);

       //  2-ЖОЛ: Customer түзүү жана RentInfo менен сактоо
        House house = new House(BigDecimal.valueOf(19500.50),3.2,"Comfortable apartment in city center",3,true);
        RentInfo rentInfo = new RentInfo(LocalDate.of(2002,2,1),LocalDate.of(2002,3,2),house);
        Customer customer1 = new Customer("Elmir", "Elmirovich","e@email.com","KG",LocalDate.of(2024,1,1),Gender.MALE,rentInfo);
        customerService.saveCustomerWithRentInfo(customer1,rentInfo);
        rentInfoService.saveRentInfo(rentInfo);

//RENT_INFO CLASS
        RentInfo rentInfo1 = new RentInfo(LocalDate.of(2002,2,1),LocalDate.of(2002,3,2));
        RentInfo rentInfo2 = new RentInfo(LocalDate.of(2003,1,1),LocalDate.of(2003,3,3));
        RentInfo rentInfo3 = new RentInfo(LocalDate.of(2004,5,6), LocalDate.of(2004,7,8));

        rentInfoService.saveRentInfo(rentInfo1);
        rentInfoService.saveRentInfo(rentInfo2);
        rentInfoService.saveRentInfo(rentInfo3);

rentInfo1.setAgency(agency1);
rentInfo2.setAgency(agency2);
rentInfo3.setAgency(agency3);



    }
}
