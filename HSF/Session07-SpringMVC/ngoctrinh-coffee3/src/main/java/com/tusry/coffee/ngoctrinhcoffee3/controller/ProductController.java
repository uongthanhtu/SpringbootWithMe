package com.tusry.coffee.ngoctrinhcoffee3.controller;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Product;
import com.tusry.coffee.ngoctrinhcoffee3.service.CategoryService;
import com.tusry.coffee.ngoctrinhcoffee3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @GetMapping()
    public String showProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/edit/{productId}")
    public String showEditProductForm(@PathVariable String productId, Model model) {
        model.addAttribute("type", "edit");
        model.addAttribute("category", categoryService.getAll());
        model.addAttribute("product", productService.findById(productId));
        return "product-form";
    }

    @GetMapping("/create")
    public String showCreateProductForm(Model model) {
        model.addAttribute("type", "create");
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryService.getAll());
        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
