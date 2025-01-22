package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="owners")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Owner {
    @Id
    @GeneratedValue(generator= "owner_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="owner_gen",sequenceName = "owner_seq", allocationSize=1)
    private Long  OwnerId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private Gender gender;
    @OneToMany(mappedBy = "owner")
    private List<House> houses;//Owner деген класс House классы менен many_to_one bi-directional байланышында
    @ManyToOne
    private  RentInfo rentInfo;// Owner классы RentInfo классы менен many_to_many байланышында bi-directional
    @ManyToMany
    private List<Agency> agencies;// Agency классы Owner классы менен many_to_many байланышында bi-directional

}
