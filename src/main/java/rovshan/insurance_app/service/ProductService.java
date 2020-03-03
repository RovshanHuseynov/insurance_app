package rovshan.insurance_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Product;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        Optional<Product> productOP = Optional.ofNullable(product);
        return productRepository.save(productOP.orElseThrow(() ->
                new Exception("CREATE PRODUCT operation could not be executed. Product could not found")));
    }
}
