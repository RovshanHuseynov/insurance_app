package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Product;
import rovshan.insurance_app.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Product create(@Valid @RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("/read/{productId}")
    public Product read(@Valid @PathVariable("productId") Long productId_){
        return productService.read(productId_);
    }

    @GetMapping("/readAll")
    public List<Product> readAll(){
        return productService.readAll();
    }

    @PutMapping("/update")
    public Product update(@Valid @RequestBody Product product){
        return productService.update(product);
    }
}
