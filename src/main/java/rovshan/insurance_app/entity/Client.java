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
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty(message = "Name is mandatory")
    @Size(max = 20)
    @Column(name="client_id")
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(min=7, max=7, message = "FIN must contain 7 characters")
    @Column(name="fin")
    private String fin;
}