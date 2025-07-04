package com.tusry.coffee.ngoctrinhcoffee3.service;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Product;
import com.tusry.coffee.ngoctrinhcoffee3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id).get();
    }

    public void saveProduct (Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}
