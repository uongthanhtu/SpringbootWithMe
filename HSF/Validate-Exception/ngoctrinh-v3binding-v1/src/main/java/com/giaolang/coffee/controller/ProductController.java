package com.giaolang.coffee.controller;

import com.giaolang.coffee.entity.Product;
import com.giaolang.coffee.service.CategoryService;
import com.giaolang.coffee.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //bean luôn
public class ProductController {

    //NHỜ SERVICE GIÚP LÁY FULL DATA TỪ TABLE
    //TỰ SERVICE CHƠI VỚI REPO. NGUYÊN LÝ SRP
    @Autowired
    private ProductService productService;

    @Autowired  //phục vụ cho danh sách treo đầu dê...
    private CategoryService categoryService;

    @GetMapping("/products")
    public String showProducts(Model model) {

        List<Product> productList = productService.getAllProducts();

        model.addAttribute("prods", productList);

        //thùng hàng đi kèm trang chứa full sản phầm từ table
        return "products"; //.html
    }

    //link edit đc nhấn
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {
        model.addAttribute("type", "edit");
        Product product = productService.getProductById(id);
        model.addAttribute("selectedOne", product);
        model.addAttribute("cates", categoryService.getAllCategories());
        return "product-form";
    }
    //link new đc nhân
    @GetMapping("/products/new")
    public String newProduct(Model model) {
        model.addAttribute("type", "create");
        model.addAttribute("selectedOne", new Product());
        model.addAttribute("cates", categoryService.getAllCategories());
        return "product-form"; //.html
    }

    @PostMapping("/products/save")
    public String saveProduct(@Valid @ModelAttribute("selectedOne") Product product, BindingResult bindingResult, Model model,@RequestParam(name = "type") String type) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("type", type);
            model.addAttribute("cates", categoryService.getAllCategories());
            model.addAttribute("selectedOne", product);
            return "product-form";
        }

        if(type.equalsIgnoreCase("create")) {
            try {
                Product productTmp = productService.getProductById(product.getId());
                if(productTmp != null) {
                    throw new Exception("Product already exists");
                }
            }catch (Exception e) {
                model.addAttribute("type", type);
                model.addAttribute("cates", categoryService.getAllCategories());
                model.addAttribute("selectedOne", product);
                bindingResult.reject("error", "Create Product Failed");
                bindingResult.reject("error", "Product Id already exists, please try another Product ID");
                return "product-form";
            }
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id, Model model) {

        productService.deleteProductById(id);

        //thùng hàng đi kèm trang chứa full sản phầm từ table
        return "redirect:/products"; //.html
    }
    //link n
    //link search đc nhấn

}
