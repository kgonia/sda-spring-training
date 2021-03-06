package pl.sda.sdaspringtraining.domain.car;

import lombok.*;
import pl.sda.sdaspringtraining.domain.rent.RentEntity;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registerPlate;
    private String producer;
    private String model;
    private int yearOfProduction;
    private String options;
    @OneToMany(mappedBy = "car")
    private Set<RentEntity> rents;

}
