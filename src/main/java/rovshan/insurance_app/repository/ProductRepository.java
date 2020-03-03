package rovshan.insurance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rovshan.insurance_app.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
