package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.FamilyStatus;
import peaksoft.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(generator= "customer_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="customer_gen",sequenceName = "customer_seq", allocationSize=1)
   // @Column(name = "customerId")
    private Long customerId;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
  //  @Column(name = "email", unique = true)
    private String nationality;
    private LocalDate dateOfBirth;
    private Gender gender;
    private FamilyStatus familyStatus;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private RentInfo rentInfo;// Customer классы  RentInfo классы менен many_to_one bi-directional байланышында

    public Customer(String firstName, String lastName, String email, String nationality, LocalDate dateOfBirth, Gender gender, RentInfo rentInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.rentInfo = rentInfo;
    }
         public Customer(String firstName, String lastName, String email, String nationality, LocalDate dateOfBirth, Gender gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.nationality = nationality;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
    }
}
