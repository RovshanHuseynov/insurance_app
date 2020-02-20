package rovshan.insurance_app.entity;

import lombok.Data;
import rovshan.insurance_app.enumm.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private Role role;
    @Size(min=3, message = "Password should contain minimum 3 characters")
    private String password;
    @Email
    private String email;
}
