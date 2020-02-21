package rovshan.insurance_app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="insurance_id")
    private Long id;
}
