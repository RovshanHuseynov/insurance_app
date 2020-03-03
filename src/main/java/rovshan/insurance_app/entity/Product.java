package rovshan.insurance_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Size(max = 20)
    @Column(name = "product_id")
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(max = 20)
    @Column(name="name")
    private String name;

    @NotEmpty(message = "FirstAmount is mandatory")
    @Size(max = 40)
    @Column(name="first_amount")
    private String firstAmount;

    @NotEmpty(message = "SecondAmount is mandatory")
    @Size(max = 40)
    @Column(name="second_amount")
    private String secondAmount;

    @NotEmpty(message = "ThirdAmount is mandatory")
    @Size(max = 40)
    @Column(name="third_amount")
    private String thirdAmount;

    @NotEmpty(message = "CommissionCost is mandatory")
    @Size(max = 40)
    @Column(name="commission_cost")
    private String commissionCost;
}
