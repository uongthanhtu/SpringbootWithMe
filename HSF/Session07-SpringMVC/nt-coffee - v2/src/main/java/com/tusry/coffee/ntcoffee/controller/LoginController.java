package com.tusry.coffee.ntcoffee.controller;

import com.tusry.coffee.ntcoffee.entity.Account;
import com.tusry.coffee.ntcoffee.entity.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller// bean này tồn tại sẵn trong ram, Tomcat, để handle cái request url gửi lên
//@RequestMapping("/api/v1")
public class LoginController {
    //các hàm phục vụ nhu cầu login, map tới //login, post của login

    //load tragn login cho thymeleaf -> render -> Tomcat -> browser
    @GetMapping({"/", "/login"})
    public String showLogin(){
        return "login"; // ghép trang + .html -> login .html đưa cho Thymeleaf gủi kèm thêm data nếu cần - Model model
    }

    @PostMapping({"/", "/login"})
    public String doLogin(@RequestParam("user") String username, @RequestParam("pass") String password, RedirectAttributes redirectAttributes, Model model, HttpSession session){
        List<Product> products = List.of(new Product("NTCF1", "Cà phê vị Java",30000 ),
                new Product("NTCF2", "Cà phê vị NT", 40000),
                new Product("NTCF3", "Cà phê vị Java mix NT", 5700000));
        // Chuẩn bị sẵn danh sách món Cafe, List<>, đính kèm theo thằng thùng chứa model
        // Thùng chứa sẽ chứa email + list
        // Lẽ ra code này của service, làm sau

        // model chính là 1 hộp gửi dồ, chứa được nhiều dồ, đồ chính là các object nào ddc bạn cất trữ, mỗi món dồ khi bỏ vào hộp luôn đi kèm 1 cái chìa khóa
        //model.addAtribute("chìa khóa", món đồ)
        //thông qua chìa khóa, ta mở tủ và lấy được món đồ
        // y chang hộc tủ
        // tủ được đẩy kèm cái trang
        // nó luôn được đi kèm với cái lệnh chuyển trang
        // view -> lấy hộp trong tủ và chiếu lên và render ra
        //      MVC, CONTROLLER NHẬN REQUEST, CHUẨN BỊ MODEL(DATE) GỬI SANG VIEW VÀ RENDER


        //====================================================================


        //fill thêm vào thùng bên products
        //redirectAttributes.addFlashAttribute("sentUser", username);


        //----------------------------------------------------------------
        //lấy từ db lên 1 account where user = user, pass = pass, đưa vào và có đc role 1, 2 tùy
        Account account;
        if(username.equalsIgnoreCase("admin")){
            account = new Account(username, password, 1);
        }else{
            account = new Account(username, password, 2);
        }

        //----------------------------------------------------------------

        session.setAttribute("acc", account);

        return "redirect:/products";
        // không cần chữ
        // resubmission nếu F5 lại thì submit lại form,
        // Đặc biệt với mà nhình tạo mới
    }
}
// nếu dùng redirect thì không giữ lại được model đang có, vì redirect là get mới url mới
// mỗi get mới sẽ có 1 model thùng chứa mới và rỗng vì nó làm mới request!!!
