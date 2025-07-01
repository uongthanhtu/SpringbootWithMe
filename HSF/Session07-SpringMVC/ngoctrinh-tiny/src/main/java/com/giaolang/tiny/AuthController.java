package com.giaolang.tiny;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; //login.html
    }

    @GetMapping({"/", "/login"})  //localhost:6969/  localhost:6969/login
    public String showLogin() {
        return "login"; //login.html
    }

    @PostMapping("/do-login") //lấy data từ trang web gửi lên qua 2 cách: @RequestParam, @ModelAtributes
    public String doLogin(@RequestParam("username") String username, HttpSession session) {
        //session là cái thùng dành cho từng user khác nhau
        //chứa nhiều món đồ, dùng chung cho các page luôn
        //f5 của mỗi page, vùng session này ko mất
        //thông tin login hay cất ở đây, role cất ở đây

        //TODO: PHẢI LẤY ROLE TỪ DATABASE, TUẦN SAU SẼ HỌC
        if (username.equalsIgnoreCase("admin")) {
            session.setAttribute("role", 1);
                              //    key     value
            //hộp cất đồ - value, có chìa khoá để mở ra lấy đồ - value
        }
        else {
            session.setAttribute("role", 2);
        }

        return "redirect:/products"; //bắt trình duyệt gọi lại url mới ứng trang cần trả về
        //return "products"; //products.html

    }

//    @PostMapping("/do-login") //lấy data từ trang web gửi lên qua 2 cách: @RequestParam, @ModelAtributes
//    public String doLogin(@RequestParam("username") String username, Model model, RedirectAttributes redirectAttrs) {
//
//        //TODO: PHẢI LẤY ROLE TỪ DATABASE, TUẦN SAU SẼ HỌC
//        if (username.equalsIgnoreCase("admin")) {
//            //model.addAttribute("role", 1);
//            redirectAttrs.addFlashAttribute("role", 1); //gửi ké cái role sang model của thằng /products ở dưới
//        }
//        else {
//            //model.addAttribute("role", 2);
//            redirectAttrs.addFlashAttribute("role", 2);
//        }
//
//        return "redirect:/products"; //bắt trình duyệt gọi lại url mới ứng trang cần trả về
//        //return "products"; //products.html
//
//    }

    //HTTP: GIAO THỨC THEO STYLE STATELESS, KO NHỚ NHAU LÂU
    //REQUEST/RESPONSE XONG, QUÊN LUÔN AI ĐÃ GỌI
    //CẦN CÓ KĨ THUẬT ĐỂ LƯU LẠI DẤU VẾT CỦA 1 USER: REQUEST LẦN TRƯỚC, LẦN NÀY LÀ CỦA CÙNG 1 NGƯỜI
    //SETTING NGÔN NGỮ CỦA WEB APP: USER HOANG: SETTING LANG -> EN
    //                         DÙNG CHUNG CHO NHIỀU TRANG
    //GIỎ HÀNG QUA NHIỀU TRANG KHÁC NHAU
    //SESSION: CƠ CHẾ LƯU TRỮ GIÁ TRỊ DÙNG CHUNG CHO NHIỀU TRANG CỦA 1 USER

}
