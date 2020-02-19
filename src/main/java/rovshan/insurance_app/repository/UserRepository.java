package rovshan.insurance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rovshan.insurance_app.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
