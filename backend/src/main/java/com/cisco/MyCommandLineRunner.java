package com.cisco;

import com.cisco.model.Product;
import com.cisco.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyCommandLineRunner implements CommandLineRunner {

    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product();
        product1.setTitle("Amazon Kindle");
        product1.setPrice(450.00);
        product1.setQuantity(50);
        productService.save(product1);

        Product product2 = new Product();
        product2.setTitle("Apple iPad");
        product2.setPrice(950.00);
        product2.setQuantity(100);
        productService.save(product2);
    }
}
