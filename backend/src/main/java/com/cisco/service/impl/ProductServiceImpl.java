package com.cisco.service.impl;

import com.cisco.model.Product;
import com.cisco.repository.ProductRepository;
import com.cisco.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product save(Product product) {
        log.info("ProductServiceImpl=> save=> start");
        return productRepository.save(product);
    }

    @Override
    public Product updateById(Long id, Product product) {
        log.info("ProductServiceImpl=> updateById=> start");
        Product managedProduct = this.findById(id);
        managedProduct.setTitle(product.getTitle());
        managedProduct.setQuantity(product.getQuantity());
        managedProduct.setPrice(product.getPrice());
        return this.save(managedProduct);
    }

    @Override
    public List<Product> findAll() {
        log.info("ProductServiceImpl=> findAll=> start");
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        log.info("ProductServiceImpl=> findById=> start");
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        log.info("ProductServiceImpl=> deleteById=> start");
        productRepository.deleteById(id);
    }

}
