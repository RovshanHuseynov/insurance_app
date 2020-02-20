package rovshan.insurance_app.entity;

import lombok.Data;
import rovshan.insurance_app.enumm.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "Surname is mandatory")
    private String surname;
    @NotEmpty(message = "Username is mandatory")
    private String username;
    @Size(min=3, message = "Password must contain minimum 3 characters")
    private String password;
    @NotNull(message = "Status cannot be null")
    private boolean status;
    @NotNull(message = "Company cannot be null")
    //private Company company;
    private LocalDateTime registerDate;
    private LocalDateTime lastLoginDate;
    private String phoneNumber;
    @NotEmpty(message = "Role is mandatory")
    private Role role;
    @NotEmpty(message = "Email is mandatory") @Email(message = "Enter a valid email address")
    private String email;
}
