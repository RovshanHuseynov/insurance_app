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
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="payment_id", unique = true)
    private Long id;

    @NotEmpty(message = "amount is mandatory")
    @Size(max = 20)
    @Column(name="amount")
    private String amount;
}