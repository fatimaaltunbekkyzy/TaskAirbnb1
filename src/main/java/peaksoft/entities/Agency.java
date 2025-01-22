package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="agencies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Agency {
    @Id
    @GeneratedValue(generator= "agency_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="agency_gen",sequenceName = "agency_seq", allocationSize=1)
    private Long AgencyId;
    private String agencyName;
    private String phoneNumber;
    @OneToOne(cascade={
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Address address;

    @ManyToMany(mappedBy = "agencies") // Agency классы Owner классы менен many_to_many байланышында bi-directional
    private List<Owner> owners = new ArrayList<>();

    public Agency(String agencyName, String phoneNumber) {
        this.agencyName = agencyName;
        this.phoneNumber = phoneNumber;
    }
}
