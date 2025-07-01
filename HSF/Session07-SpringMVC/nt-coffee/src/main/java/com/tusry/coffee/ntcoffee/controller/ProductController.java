package com.tusry.coffee.ntcoffee.controller;

import com.tusry.coffee.ntcoffee.entity.Account;
import com.tusry.coffee.ntcoffee.entity.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/products")
    public String showProducts(Model model, HttpSession session) {
        List<Product> products = List.of(new Product("NTCF1", "Cà phê vị Java",30000 ),
                new Product("NTCF2", "Cà phê vị NT", 40000),
                new Product("NTCF3", "Cà phê vị Java mix NT", 5700000));
        model.addAttribute("products", products);
//        session.setAttribute("sentUser", session.getAttribute("sentUser"));
        // có session lo giữ acc rồi
        Account account = (Account) session.getAttribute("acc");
        model.addAttribute("role", account.getRole() );
        return "products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(Model model, @PathVariable String id) {
        // có trong tay id số mấy rồi vào db query lên (ta tự hardcode vì chưa có db)

        Product product;
        if(id.equalsIgnoreCase("NTCF1")) {
            product = new Product("NTCF1", "Cà phê vị Java",30000 );
        }else if (id.equalsIgnoreCase("NTCF2")) {
            product = new Product("NTCF2", "Cà phê vị NT", 40000);

        }else{
            product =   new Product("NTCF3", "Cà phê vị Java mix NT", 5700000);
        }
        model.addAttribute("product", product);

        return "product-form";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products/save")
    public String saveProduct(@RequestParam("id") String id, @RequestParam("name") String name, HttpSession session, RedirectAttributes redirectAttributes) {
        // 1 field dưới form map thành 1 biếnở trên hàm post tron controller, tốm kém và code dài

        // save thanh cong thi quay lai trang danh sach sn pham da co them thu vua sua la edit vaf create
        //url bị giữu nguyên nên nó resubmitsion của F5 -> model rỗng
        //thùng rỗng
        //return "products";
        redirectAttributes.addFlashAttribute("msg", "Product saved successfully");
        return "redirect:/products";
    }

}
