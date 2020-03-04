package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Product;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
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
                new Exception("CREATE PRODUCT operation could not be executed. Input data is invalid")));
    }

    public Product read(Long productId_) {
        return productRepository.findById(productId_).orElseThrow(() ->
                new Exception(String.format("READ PRODUCT operation could not be executed. PRODUCT with %d id could not be found", productId_)));
    }

    public List<Product> readAll() {
        ArrayList<Product> products = new ArrayList<>();

        for(Product p : productRepository.findAll()){
            products.add(p);
        }

        if(products.size() == 0){
            throw new Exception("READ ALL PRODUCTS operation could not be executed. There are no any products.");
        }
        else {
            return products;
        }
    }
}