package rovshan.insurance_app.repository;

import org.springframework.data.repository.CrudRepository;
import rovshan.insurance_app.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
