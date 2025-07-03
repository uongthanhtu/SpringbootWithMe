package com.tusry.coffee.ngoctrinhcoffee3.config;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Account;
import com.tusry.coffee.ngoctrinhcoffee3.entity.Category;
import com.tusry.coffee.ngoctrinhcoffee3.entity.Product;
import com.tusry.coffee.ngoctrinhcoffee3.service.AccountService;
import com.tusry.coffee.ngoctrinhcoffee3.service.CategoryService;
import com.tusry.coffee.ngoctrinhcoffee3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    AccountService accountService;


    @Override
    public void run(String... args) throws Exception {
        // Tạo tự động khi localhost:6969 run
        //1, Tạo sẵn vài CATE
        Category category1 = new Category("Trà sữa", "Uống vào không pass java");
        Category category2 = new Category("Cà phê", "Uống vào là mất ngủ nên pass java");
        Category category3 = new Category("Beer nước ngọt", "Uống vào tiểu đường");
        Category category4 = new Category("Bánh kẹo", "Ăn vào sâu răng đó banh ưi");

        categoryService.saveCategory(category1);
        categoryService.saveCategory(category2);
        categoryService.saveCategory(category3);
        categoryService.saveCategory(category4);

        Product p1c1 = new Product("TS01", "Trà sữa hàng xóm nấu", 25555, 50);
        Product p2c1 = new Product("TS02", "Trà sữa ngọc trinh nấu", 125555, 12);
        Product p1c2 = new Product("CF01", "Cà phê java vị nguyên bản", 700000, 62);

        Product p2c2 = new Product("CF02", "Cà phê java vị nguyên bản" , 700000, 42);

        category1.addProduct(p1c1);
        category1.addProduct(p2c1);

        category2.addProduct(p1c2);
        category2.addProduct(p2c2);

        categoryService.saveCategory(category1);
        categoryService.saveCategory(category2);
        categoryService.saveCategory(category3);
        categoryService.saveCategory(category4);

        Account admin = new Account("admin", "admin123", 1);
        Account user = new Account("user", "user123", 2);

        accountService.save(admin);
        accountService.save(user);
    }
}
