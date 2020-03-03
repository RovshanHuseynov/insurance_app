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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Size(max = 20)
    @Column(name="user_id")
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(max = 20)
    @Column(name="name")
    private String name;

    @NotEmpty(message = "Surname is mandatory")
    @Size(max = 20)
    @Column(name="surname")
    private String surname;

    @NotEmpty(message = "Username is mandatory")
    @Size(max = 40)
    @Column(name="username", unique = true)
    private String username;

    @NotEmpty(message = "Password is mandatory")
    @Size(min=3, max=20)
    @Column(name="password")
    private String password;

    @NotNull(message = "Status cannot be null")
    @Size(max = 5)
    @Column(name="status")
    private boolean status;

    @NotNull(message = "Company cannot be null")
    @ManyToOne
    @JoinColumn(name="company_id",foreignKey=@ForeignKey(name="company_id_FK"))
    @Column(name="companyId")
    private Company company;

    @CreatedDate
    @Column(name="registerDate")
    private Date registerDate;

    @LastModifiedDate
    @Column(name="lastLoginDate")
    private Date lastLoginDate;

    @Size(max = 20)
    @Column(name="phoneNumber")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Role is mandatory")
    @Size(max = 20)
    @Column(name="role")
    private Role role;

    @NotEmpty(message = "Email is mandatory")
    @Size(max = 30)
    @Email(message = "Enter a valid email address")
    @Column(name="email", unique = true)
    private String email;
}