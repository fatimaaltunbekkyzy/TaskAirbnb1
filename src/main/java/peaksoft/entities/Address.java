package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    @Id
    @GeneratedValue(generator= "address_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="address_gen",sequenceName = "address_seq", allocationSize=1)
    private Long AddressId;
    //@Column(name = "street", unique = true)
    private String street;
    private String city;
    private String region;

    @OneToOne(mappedBy = "address",cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Agency agency;

    public Address(String street, String city, String region) {
        this.street = street;
        this.city = city;
        this.region = region;
    }
}

