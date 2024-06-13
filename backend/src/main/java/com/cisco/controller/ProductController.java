package com.cisco.controller;

import com.cisco.model.Product;
import com.cisco.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        log.info("ProductController=> saveProduct=> start");
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        log.info("ProductController=> updateProduct=> start");
        return productService.updateById(id, product);
    }

    @GetMapping
    public List<Product> findAllProducts() {
        log.info("ProductController=> findAllProducts=> start");
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        log.info("ProductController=> findProductById=> start");
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable Long id) {
        log.info("ProductController=> deleteProductById=> start");
        productService.deleteById(id);
    }

}
