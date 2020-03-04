package rovshan.insurance_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty(message = "Id is mandatory")
    @Size(max = 20)
    @Column(name="employer_id", unique = true)
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(max = 20)
    private String name;
}