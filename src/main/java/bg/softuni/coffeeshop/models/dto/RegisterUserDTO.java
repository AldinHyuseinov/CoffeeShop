package bg.softuni.coffeeshop.models.dto;

import bg.softuni.coffeeshop.utils.validation.FieldMatch;
import bg.softuni.coffeeshop.utils.validation.UniqueEmail;
import bg.softuni.coffeeshop.utils.validation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords must match.")
public class RegisterUserDTO {
    @Size(min = 5, max = 20, message = "Username length must be between 5 and 20 characters.")
    @UniqueUsername
    private String username;

    private String firstName;

    @Size(min = 5, max = 20, message = "Last name length must be between 5 and 20 characters.")
    private String lastName;

    @Email(regexp = ".+@.+", message = "Enter valid email address.")
    @UniqueEmail
    private String email;

    @Size(min = 3, message = "Password length must be more than 3 characters.")
    private String password;

    @Size(min = 3, message = "Password length must be more than 3 characters.")
    private String confirmPassword;
}
