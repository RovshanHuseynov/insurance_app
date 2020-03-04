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
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty(message = "Id is mandatory")
    @Size(max = 20)
    @Column(name="insurance_id", unique = true)
    private Long id;
}
