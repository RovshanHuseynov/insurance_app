package rovshan.insurance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rovshan.insurance_app.entity.Employer;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Employer, Long> {
    Optional<Employer> findByUsernameAndPassword(String username, String password);
    List<Employer> findUsersByCompanyId(Long companyId);
}
