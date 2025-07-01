package com.tusry.coffee.ngoctrinhcoffee3.service;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Product;
import com.tusry.coffee.ngoctrinhcoffee3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    // GUI/ CONTROLLER ---- SERVICE ----- REPO ----- JPA/ HIBERNATE ----- JDBC ----- TABLE
    //  cần xài CLASS này giao tiếp với GUI để cung cấp info cho GUI
    // nó cần nhờ Repo trợ giúp thao tác với DB
    //@Autowired              // FIELD INJECTION
    private ProductRepository productRepository;
    //@Autowire không caanf vì class có 1 contructor và tự tim vào đúng !!!
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // các hàm CRUD TABLE
    public List<Product> findAll() {
        return productRepository.findAll();// class/interface Repo chưa có dòng code nào
                                            // hàm tự sinh trong repo
    }

    //dành cho link và edit
    public Product findById(String id) {
        return productRepository.findById(id).get();
    }

    //dành cho link post save sản phẩm khi tạo mới và khi save
    public void saveProduct (Product product) {
        productRepository.save(product);
    }// key mới thì -> insert
    // key đang có thì là update

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}
