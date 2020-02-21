package rovshan.insurance_app.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="payment_id")
    private Long id;
    @NotEmpty(message = "Value is mandatory")
    private String value;
}
