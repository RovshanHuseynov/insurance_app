package rovshan.insurance_app.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="company_id")
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    private String name;
}
