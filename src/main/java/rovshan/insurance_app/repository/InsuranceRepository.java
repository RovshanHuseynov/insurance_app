package rovshan.insurance_app.repository;

import org.springframework.data.repository.CrudRepository;
import rovshan.insurance_app.entity.Insurance;

public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
}
