package rovshan.insurance_app.repository;

import org.springframework.data.repository.CrudRepository;
import rovshan.insurance_app.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
