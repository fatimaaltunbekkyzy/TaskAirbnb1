package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entities.*;
import peaksoft.enums.FamilyStatus;
import peaksoft.enums.Gender;
import peaksoft.service.*;
import peaksoft.service.serviceImpl.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        //  HibernateConfig.getEntityManagerFactory();
   //        Agency тузулуп жатканда адреси кошо тузулсун!
            AgencyService agencyService = new AgencyServiceImpl();
            Agency agency1 = new Agency("TechSolutions","+996500360300");
            Agency agency2 = new Agency("SkyLine","+996500300360");
            Agency agency3 = new Agency("Altyn Service","+996500360390");

            //  Save address
            Address address1 = new Address("Гражданское 119","Bishkek","chui");
            Address address2 = new Address("Советская 5","Москва","Центр");
            Address address3 = new Address("Шевченко 88","Bishkek","Север");
          address1.setAgency(agency1);
          address2.setAgency(agency2);
          address3.setAgency(agency3);
          agency1.setAddress(address1);
          agency2.setAddress(address2);
          agency3.setAddress(address3);
          agencyService.saveAgency(agency1);
          agencyService.saveAgency(agency2);
          agencyService.saveAgency(agency3);
        System.out.println(address1);
        System.out.println(address2);
        System.out.println(address3);


       //   Agency очкондо адреси жана rent_info кошо очсун
          agencyService.getAllAgency();
          agencyService.deleteAgency(2L);
          AddressService addressService = new AddressServiceImpl();
          addressService.countAgenciesInCity("Bishkek");
        Agency agency = new Agency("Tил Академиясы", "+996500360300");
        addressService.updateAddress(new Address(1L,"ПентХаус","Кореа","Нам Сан",agency);

       //  1-жол: Save customer
         //  Customer объектин түзүү
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Adilet", "Egemberdiev", "a@email.com", "KG", LocalDate.of(1990, 5, 20), Gender.MALE, FamilyStatus.MARRIED);
        customerService.saveCustomer(customer);


 //2-ЖОЛ: Customer түзүү жана RentInfo менен сактоо Customer уйду ижарага алса болот. Ижарага алып жатканда customer id, house id, agency id жана check in check out жазышы керек.
        // Customer, RentInfo, House, Agency түзүү
        RentInfo rentInfo = new RentInfo(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 3, 1));
        House house = new House(BigDecimal.valueOf(19500.50), 3.2, "Comfortable apartment in city center", 3, true);
        Agency agency4 = new Agency("TechSolutions", "+996500360300");

        // Customer объектин түзүү
        Customer customer1 = new Customer("Sakina", "Isakova", "s@email.com", "Kyrgyz", LocalDate.of(2006, 9, 1), Gender.FEMALE,FamilyStatus.SINGLE);

        // CustomerService жана RentInfoService кызматы
//        CustomerService customerService1 = new CustomerServiceImpl();
//        RentInfoService rentInfoService = new RentInfoServiceImpl();
//        HouseService houseService = new HouseServiceImpl();
//        AgencyService agencyService1 = new AgencyServiceImpl();
//
//        // RentInfo, House жана Agency сактоо
//        rentInfoService.saveRentInfo(rentInfo);
//        houseService.saveHouse(house);
//        agencyService.saveAgency(agency);
//
//        // Сакталган объекттердин ID'лерин алуу
//        Long houseId = house.getHouseId();  // Сакталган House объектинен ID алуу
//        Long agencyId = agency.getAgencyId();  // Сакталган Agency объектинен ID алуу
//        Long rentInfoId = rentInfo.getRentInfoId();  // Сакталган RentInfo объектинен ID алуу
//
//        // Customer түзүү жана RentInfo, House жана Agency менен сактоо (check-in жана check-out менен)
//        LocalDate checkInDate = LocalDate.of(2024, 1, 1);
//        LocalDate checkOutDate = LocalDate.of(2024, 3, 1);
//        customerService.saveCustomerWithRentInfo(customer, houseId, agencyId, rentInfoId, checkIn, checkOut);

        System.out.println("Customer and related information saved successfully!");

//      RENT_INFO CLASS
        RentInfoService rentInfoService1 = new RentInfoServiceImpl();
        RentInfo rentInfo1 = new RentInfo(LocalDate.of(2002,2,1),LocalDate.of(2002,3,2));
        RentInfo rentInfo2 = new RentInfo(LocalDate.of(2003,1,1),LocalDate.of(2003,3,3));
        RentInfo rentInfo3 = new RentInfo(LocalDate.of(2004,5,6), LocalDate.of(2004,7,8));

        rentInfoService1.saveRentInfo(rentInfo1);
        rentInfoService1.saveRentInfo(rentInfo2);
        rentInfoService1.saveRentInfo(rentInfo3);




    }}