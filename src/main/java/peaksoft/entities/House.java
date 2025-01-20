package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="houses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class House {
    @Id
    @GeneratedValue(generator= "house_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="house_gen",sequenceName = "house_seq", allocationSize=1)
    private Long id;
    private BigDecimal price;
    private double rating;
    private String description;
    private int room;
    private boolean furniture;
    @ManyToOne
    private Owner owner;//Owner деген класс House классы менен many_to_one bi-directional байланышында

    @OneToOne
    private Address address;//House класс Address деген класс менен one_to_one uni-directional байланышында

    public House(BigDecimal price, double rating, String description, int room, boolean furniture) {
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.room = room;
        this.furniture = furniture;
    }
}
