package pl.sda.sdaspringtraining.api.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomer {
    @NotEmpty(message = "first name cannot be empty")
    private String firstName;
    @NotEmpty(message = "last name cannot be empty")
    private String lastName;
    @Length(max = 30, message = "Address is too long")
    private String address;
    @Pattern(regexp = "[0-9]*")
    private String driverLicense;
}
