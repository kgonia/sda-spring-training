package pl.sda.sdaspringtraining.api.model;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomer {
    private Integer id;
    private String newAddress;
}
