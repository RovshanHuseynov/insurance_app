package rovshan.insurance_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="employee_id", unique = true)
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(max = 20)
    private String name;

    //@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;
}