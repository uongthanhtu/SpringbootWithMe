package com.tusry.coffee.ngoctrinhcoffee3.controller;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Account;
import com.tusry.coffee.ngoctrinhcoffee3.entity.Product;
import com.tusry.coffee.ngoctrinhcoffee3.service.CategoryService;
import com.tusry.coffee.ngoctrinhcoffee3.service.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @GetMapping
    public String showProducts(Model model, HttpSession session) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return "redirect:/login";
        }
        model.addAttribute("account", account);
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
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model, @RequestParam("type") String type) {
        if(bindingResult.hasErrors()) {
            if(type.equals("edit")) {
                model.addAttribute("type", "edit");
                model.addAttribute("category", categoryService.getAll());
                model.addAttribute("product", product);
                return "product-form";
            }else{
                model.addAttribute("type", "create");
                model.addAttribute("product", product);
                model.addAttribute("category", categoryService.getAll());
                return "product-form";
            }
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
