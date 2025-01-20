package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="rentInfos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RentInfo {
    @Id
    @GeneratedValue(generator= "rentInfo_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="rentInfo",sequenceName = "rentInfo_seq", allocationSize=1)

    private Long id;
    private LocalDate checkin;
    private LocalDate checkOut;

    @ManyToOne(cascade={
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
            private Agency agency;

    @OneToMany(mappedBy = "rentInfo")//Customer классы RentInfo классы менен many_to_one bi-directional
    private List<Customer> customers;

    @OneToMany(mappedBy = "rentInfo") //Owner классы RentInfo классы менен many_to_one bi-directional байланышында
    private List<Owner> owners;

    @OneToOne
    private House house;

    public RentInfo(LocalDate checkin, LocalDate checkOut) {
        this.checkin = checkin;
        this.checkOut = checkOut;
    }

    public RentInfo(LocalDate checkin, LocalDate checkOut, House house) {
        this.checkin = checkin;
        this.checkOut = checkOut;
        this.house = house;

    }
}

