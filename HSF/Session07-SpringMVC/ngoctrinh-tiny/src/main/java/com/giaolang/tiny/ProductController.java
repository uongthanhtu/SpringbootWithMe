package com.giaolang.tiny;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/products/edit")
    public String edit(){
        return "product-form"; //redirect trả về url
    }

    @GetMapping("/products/new")
    public String create(){
        return "product-form"; //redirect trả về url
    }

    @GetMapping("/products")  //localhost:6969/  localhost:6969/login
    public String showProducts(@RequestParam(name = "keyword", required = false) String kw, Model model, HttpSession session) {

        //CHẶN NGAY TỪ ĐẦU HÀM, KO CẤM USER GÕ URL
        //SERVER VÀ CODE MÌNH SẼ CHẶN... GÌ ĐÓ KHI CHƯA LOGIN THÌ VÒNG VỀ LOGIN, ĐỔI URL LUÔN
        Integer role = (Integer) session.getAttribute("role");
        if (role == null) {
            return "redirect:/login";
        }

        //XÀI KW ĐỂ WHERE TRONG DATABASE, NẾU ĐI CON ĐƯỜNG SEARCH
        //  LÚC NÀY SHOW ÍT HƠN
        if (kw != null && !kw.isEmpty()) {
            //gọi Service | gọi Repo để where data, trả về table
            model.addAttribute("result", kw + " | Đã WHERE RỒI NHEN!!!");
        }
        else {
            //đi con đường login, show full từ database
            model.addAttribute("result", " FULL KO CHE NGỌC TRINH ƠI!");
        }

        //ĐI TỪ LOGIN SANG THÌ KO CÓ FIELD KW LUÔN!!!
        //  LÚC NÀY SHOW FULL

        model.addAttribute("role", session.getAttribute("role")); //lấy đc 1 hoặc 2

        return "products"; //products.html
    } //phần gửi ké từ login sẽ bị mất nếu F5 vì F5 là gọi lại hàm,
    //gọi hàm là có thùng mới, thùng này ko ai gửi ké ở lần F5, do đó role = null
}
