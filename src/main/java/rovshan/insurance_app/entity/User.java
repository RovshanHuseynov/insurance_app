package rovshan.insurance_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import rovshan.insurance_app.enumm.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Size(max = 20)
    @Column(name="user_id")
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(max = 20)
    private String name;

    @NotEmpty(message = "Surname is mandatory")
    @Size(max = 20)
    private String surname;

    @NotEmpty(message = "Username is mandatory")
    @Size(max = 40)
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Password is mandatory")
    @Size(min=3, max=20)
    private String password;

    @NotNull(message = "Status cannot be null")
    @Size(max = 5)
    private boolean status;

    @NotNull(message = "Company cannot be null")
    @ManyToOne
    @JoinColumn(name="company_id",foreignKey=@ForeignKey(name="company_id_FK"))
    private Company company;

    @CreatedDate
    private Date registerDate;

    @LastModifiedDate
    private Date lastLoginDate;

    @Size(max = 20)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Role is mandatory")
    @Size(max = 20)
    private Role role;

    @NotEmpty(message = "Email is mandatory")
    @Size(max = 30)
    @Email(message = "Enter a valid email address")
    @Column(unique = true)
    private String email;
}