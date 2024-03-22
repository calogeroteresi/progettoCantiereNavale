package it.epiocde.progettoCantiereNavale.requests.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "date request")
    private String username;

    @NotBlank(message = "email request")
    @Email
    private String email;

    @NotBlank(message = "first name request")
    private String firstName;

    @NotBlank(message = "last name request")
    private String lastName;
}
