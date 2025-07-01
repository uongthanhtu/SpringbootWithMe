package com.giaolang.coffee.controller;

import com.giaolang.coffee.entity.Category;
import com.giaolang.coffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

//class này sẽ lo các xử lí liên quan đến sản phầm - product bao gồm
//CRUD product NHƯNG Ở GÓC ĐỘ XỬ LÍ REQUEST RESPONSE
//NÓ PHỤ TRÁCH CÁC URL DÍNH DÁNG ĐẾN CRUD PRODUCT,
//NHƯNG LÁT HỒI NÓ SẼ KÍNH CHUYỂN DẦN CHO SERVICE, REPO
//CLASS NÀY LẮNG NGHE CÁC URL, VÀ XEM URL NÀO PHÙ HỢP VỚI HÀM TRONG CLASS NÀY THÌ GỌI HÀM ĐÓ - METHOD MAPPING VỚI URL!!!
//2 VIỆC: NÓ PHẢI LẮNG NGHE URL, NGHE XONG, GỌI ĐÚNG HÀM ỨNG VỚI URL
//VIỆC 0: NÓ PHẢI LÀ 1 BEAN ĐC NEW TỰ ĐỘNG, VÀO RAM VÀ NGHE
//VIỆC 1: NGHE - MÀY LÀ @CONTROLLER: BEAN VÀ LẮNG NGHE
//VIỆC 2: HÀM NÀO ỨNG VỚI URL NÀO; TRẢ VỀ HTML!!!
//QUAN TRỌNG: 1 URL GET -> ỨNG VỚI 1 HÀM RETURN "TÊN TRANG (HTML) NÀO ĐÓ"
//                                   HÀM PHẢI NẰM TRONG 1 CLASS @CONTROLLER
//                      -> GET CÓ NGHĨA LÀ MUỐN LẤY 1 TRANG THÔNG TIN

@Controller  //@RestController, cũng nghe, nhưng trả về JSON
public class ProductController {

    // chuẩn bị danh sách category , trả về cho trang product-form để show danh sách chọn sản phẩm
    // hard code danh sách
    public List<Category> getCategories() {
        List<Category>  categories = new ArrayList<>();
        categories.add(new Category(100L, "Cà phê Java nguyên bản", "30_000"));
        categories.add(new Category(200L, "Beer", "30_000"));
        categories.add(new Category(300L, "Nước ngọt ", "5_700_000"));
        return categories;
    }



    @GetMapping("/msg")
    public String showMessage(Model model) {

        //làm sao lấy đc name sản phẩm của bên post, và câu chào

        //1 URL, 1 HÀM TƯƠNG ỨNG, 1 THÙNG MODEL MỚI TINH ĐỂ TA BỎ ĐỒ VÀO TRƯỚC KHI RENDER TRANG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //MỖI HÀM 1 MODEL RIÊNG, 1 THÙNG RIÊNG
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //KĨ THUẬT CHUYỂN DATA TỪ MODEL KIA SANG MODEL NÀY Ở CÂU LỆNH
        //REDIRECT. TẠI SAO LÀM VẬY: REDIRECT LÀGO5OI URL MỚI,
        //URL MỚI LÀ CHƠI THÙNG MỚI
        //TRƯỚC KHI REDIRECT, GỬI KÉ THÊM DATA TỪ MODEL CŨ SANG MODEL MỚI
        //TỪ MODEL CỦA THẰNG POST, KÉ SANG MODEL THẰNG NÀY GET NÀY!!!

        //MODEL Ở ĐÂY, NGOÀI DATA CỦA CHÍNH CHỦ HÀM NÀY, CÒN NHẬN THÊM TỪ BÊN POST GỬI SANG!!!!!!!!!!

        return "result";  //.html
    }



    //hàm này update 1 sản phẩm xuống db, đc gọi bởi việc nhấn nút [Save]
    //và nhận vào các data gõ trong ô nhập đc gửi lên đây

    @PostMapping("/products/edit")
    //@RequestParam: gửi từng ô nhập ở form lên server, map vào biến hứng trong hàm
    //tên biến hứng ko cần giống biến trong form
    //nhưng @RequestParam("tên-biến-ở-bên-form-html-thuộc-tính-name-của-ô-nhập")
    public String update(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("price") String price, Model model, RedirectAttributes redirectAtts) {

        model.addAttribute("msg", "Đã update thành công - Mock message!!!");
        model.addAttribute("pname", name);
        //2 LỆNH NÀY SẼ VÔ DỤNG NẾU CHƠI REDIRECT VÌ BÊN REDIRECT XÀI THÙNG MODEL KHÁC!!!


        //thùng có 2 món: câu thông báo, và tên sản phẩm đã edit

        //return "result";  //.html HIỆN TƯỢNG RESUBMISSION XUẤT HIỆN

        //gửi ké sang bên model/thùng của hàm /msg - mỗi shipper 1 thùng riêng
        redirectAtts.addFlashAttribute("formMsg", "Đã update/create thành công - Mock message!!!");
        redirectAtts.addFlashAttribute("pname", name);

        return "redirect:/products"; //gọi url /products để show toàn bộ sp

    }
    //VỚI HÀM POST (BẢN CHẤT VẪN LÀ GET - NHƯNG GỬI KÈM NHIỀU DATA KHI "GET")
    //KHI HÀM POST TRẢ VỀ 1 TRANG KẾT QUẢ QUA LỆNH RETURN "TÊN TRANG"
    //THÌ URL POST VẪN GIỮ NGUYÊN, TRONG KHI ĐÓ THÂN TRÌNH DUYỆT CÓ DATA ĐC TRẢ VỀ - TRANG TRẢ VỀ
    //F5 VỚI POST THÌ SAO?
    //THÌ VẪN TRẢ VỀ TRANG KQ NHƯ BT, NHƯNG LẠI GỬI LẠI ĐỐNG DATA
    //RESUBMITSION FORM, GIỐNG NHƯ NHẤN LẠI NÚT BẤM (VÌ NHẤN NÚT GỌI URL NÀY)
    //CỰC KÌ NGUY HIỂM VỚI TÍNH NĂNG CREATE, F5 MÀN HÌNH HÌNH KQ SẼ TƯƠNG ĐƯƠNG
    //VIỆC GỬI LẠI DATA, CHẠY LẠI XỬ LÍ => DUPLICATE DATA!!!

    //CHỐT HẠ: VỚI POST, TA CẦN ĐỔI URL TRÁNH SUBMIT LẠI KHI F5
    //URL GET, F5, GET LẠI

    //URL POST, F5, POST LẠI, NGUY HIỂM. URL POST XỬ LÍ XONG, RETURN TRANG VÀ ĐỔI URL LUÔN, LỠ F5 LẠI, KO CÒN URL POST ĐỂ RE-SUBMIT FORM
    //REDIRECT METHOD!!!!!!!!!!!!!!!!!!!!
    //ĐỊNH HƯỚNG LẠI URL, GỌI LẠI 1 URL MỚI NHƯNG VẪN CÙNG KẾT QUẢ TRẢ VỀ TRANG!!!

    //>>>>>>>>>>>>> QUAN TRỌNG: XỬ LÍ POST XONG, THÌ NHỚ ĐỔI URL KẾT QUẢ!!!
    //                          TRÁNH F5 LẠI CÁI POST!!!
    //                          ĐỔI URL VÀ F5 LÀ F5 KẾT QUẢ, KO PHẢI F5 POST

    //HIỆN TƯỢNG GET Y CHANG: URL GET VẪN GIỮ NGUYÊN, TRONG KHI ĐÓ THÂN TRÌNH DUYỆT CÓ DATA ĐC TRẢ VỀ - TRANG TRẢ VỀ
    //F5 VỚI GET THÌ SAO? THÌ TRẢ VỀ KQ NHƯ BT

    //Ý NGHĨA VIỆC GIỮ NGUYÊN URL: GỌI HÀM THÌ TRẢ VỀ KQ Ở DƯỚI, TÊN HÀM VẪN Ở TRÊN


    @GetMapping("/products/create")  //tách url thành 2 phần, 1 phần cố định, và 1 phần thay đổi - phần thay đổi gọi là path variable
    public String showProductFormByCreate(Model model) {
        model.addAttribute("minzy", new Product());
        model.addAttribute("cate", getCategories());
        return "product-form";
    }


    //@GetMapping(path = {"/products/edit/NTCF1", "/products/edit/NTCF2", "/products/edit/NTCF3"})
    @GetMapping("/products/edit/{pid}")  //tách url thành 2 phần, 1 phần cố định, và 1 phần thay đổi - phần thay đổi gọi là path variable
    public String showProductForm(Model model, @PathVariable("pid") String id ) {

        //đã trích đc id muốn xem chi tiết từ click hyperlink của user
        //TODO: DÙNG SERVICE GỌI REPO ĐỂ WHERE TRONG TABLE PRODUCT RA SẢN PHẨM CÓ ID VỪA CLICK, LÀM SAU

        //TẠM THỜI MOCK, HARD-CODED
        //Product selectedProduct = //lấy từ DB;
        Product selectedProduct;
        if (id.equalsIgnoreCase("NTCF1")) {
            selectedProduct = new Product("NTCF1", "Cà phê Java nguyên bản",30_000);
        } else if (id.equalsIgnoreCase("NTCF2")) {
            selectedProduct = new Product("NTCF2", "Cà phê vị Ngọc Trinh", 30_000);
        } else {
            selectedProduct = new Product("NTCF3", "Cà phê Java mix đậm đà vị Ngọc Trinh ", 5_700_000);
        }

        //quan trọng. ném vào thùng cho trang render!!!
        model.addAttribute("minzy", selectedProduct);
        //model.addAttribute("minzy", "Hello");
        model.addAttribute("cate", getCategories());

        return "product-form";  //.html mà ko cần ghi ra
        //lệnh return trang luôn đính kèm theo 1 thùng giao hàng, gửi đồ
        //theo style "key"-value, chìa khoá, mảnh giấy để lấy món đồ trong thùng. Thymeleaf engine dùng chìa khoá để mò vào thùng lấy đồ ra mix trộn thành HTML THUẦN VÀ TRẢ VỀ CHO TOMCAT -> BROWSER!!!
    }


    //@RequestMapping("/jack")  //url map với hàm này localhost:6969/ngoctrinh
    //nguy hiểm 1 chút: url này dành cho cả GET/POST/PUT/... miễn match url
    //ta cần phân tách: hàm nào dành cho GET, hàm nào dành cho POST

    //CÁCH VIẾT CHUẨN, PHÂN BIỆT HÀM NÀO DÀNH CHO GET/POST...
    //@RequestMapping(path = {"/jack", "/products" }, method = RequestMethod.GET)
    //CÁCH VIẾT NGẮN HƠN

    //HÀM NHẬN REQUEST, THUỘC NHÓM GET, LÁT HỒI CÒN NHÓM POST, PUT...
    //@GetMapping(path = {"/jack", "/products"})  //CÓ BAO NHIÊU URL ĐC MAP TỚI HÀM NÀY
    @GetMapping("/products")
    public String list(Model model) {  //list nghĩa là show danh sách sản phẩm
                           //nằm trong trang products.html
                           //tên hàm đặt là gì cx đc, showList() showProducts()
        //gửi đồ cho view, bỏ vào hộc tủ, thùng chứa đồ
        model.addAttribute("msg", "Xin chào Admin. Cafe hơm?!!!");

        //chẩn bị 1 danh sách sản phẩm để show ra trang web products.hmtl
        //hard-coded test thử, thực tế gọi Service, Repo... làm sau; tiêm chích tự động ko cần new

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("NTCF1", "Cà phê Java nguyên bản", 30_000));
        productList.add(new Product("NTCF2", "Cà phê vị Ngọc Trinh", 30_000));
        productList.add(new Product("NTCF3", "Cà phê Java mix đậm đà vị Ngọc Trinh ", 5_700_000));

        //gửi danh sách sản phẩm trong thùng đồ, lấy lại đồ qua key products
        model.addAttribute("minzy", productList);

        return "products"; //return tên trang - view, ko cần .html
    }              //tự thymeleaf dedpenency nó lo gắn tên

}

//KHI CONTROLLER TÌM THẤY HÀM XỬ LÍ URL TƯƠNG ỨNG, NÓ SẼ GỌI HÀM NÀY
//NHƯNG TRƯỚC KHI GỌI, NÓ GỬI CHO HÀM 1 THÙNG CHỨA ĐỒ RỖNG GỌI LÀ MODEL

//MÌNH NHÉT DATA VÀO THÙNG CHỨA ĐỒ NÀY, THÙNG ĐỒ MODEL ĐC NEW TỰ ĐỘNG VÀ CHÍCH VÀO HÀM XỬ LÍ URL

//KHI THỰC THI LỆNH RETURN CHO URL GET... THÌ SPRING NÓ SẼ ĐÍNH KÈM CÁI THÙNG ĐỒ VÀO CÙNG TRANG TRẢ VỀ, VÀ ĐƯA TÊN TRANG + THÙNG ĐỒ CHO THYMELEAF MIX, TRỘN, RENDER
//THYMELEAF SẼ LẤY ĐỒ TRONG THÙNG, TRỘN VỚI CÁC TAG HMTL, TRỘN XONG, TRẢ CHO TOMCAT TRANG WEB HTML NGON -> ĐẨY VỀ TRÌNH DUYỆT USER!!!

//CÂU HỎI: LÀM SAO NHÉT ĐỒ - DATA VÀO THÙNG, VÀ LẤY RA - THÙNG CHỨA ĐC NHIỀU ĐỒ...
//         CONTROLLER LÀ NHÉT ĐỒ VÀO THÙNG
//         HTML/THYMELEAF LÀ LẤY ĐỒ RA KHỎI THÙNG VÀ MIX

//HÃY TƯỞNG TƯỢNG TỦ GỬI ĐỒ, QUẦY GỬI TÚI/GIỎ Ở SIÊU THỊ VÀ TTTM
//BỎ ĐỒ VÀO HỘC TỦ, LẤY CHÌA KHOÁ, MẢNH GIẤY

//CHÌA KHOÁ, MẢNH GIẤY GỌI LÀ KEY  |  MÓN ĐỒ GỌI LÀ VALUE!!!!!!!!!!
//CÓ CHÌA, MẢNH GIẤY THÌ LẤY ĐC VALUE/MÓN ĐỒ!!!

//GỬI ĐỒ VÀO THÙNG (TRONG CONTROLLER)
//model.addAtribute(key-mảnh-giấy,                   value);
//                 chuỗi ko trùng     object bất kì bạn muốn cất
//                   tên-biến                        value

//lát hồi bên trang view, lấy đồ, dùng key
//        ${tên-key, mảnh-giấy}  -> trả về object, món đồ!!!
