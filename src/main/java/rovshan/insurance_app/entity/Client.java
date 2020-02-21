package rovshan.insurance_app.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="client_id")
    private Long id;
    @Size(min=7, max=7, message = "FIN must contain 7 characters")
    private String fin;
}
