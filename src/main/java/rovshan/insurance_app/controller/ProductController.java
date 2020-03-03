package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rovshan.insurance_app.entity.Product;
import rovshan.insurance_app.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public Product create(@Valid @RequestBody Product product){
        return productService.create(product);
    }
}
