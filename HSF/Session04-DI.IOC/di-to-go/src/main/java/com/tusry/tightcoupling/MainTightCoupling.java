package com.tusry.tightcoupling;

public class MainTightCoupling {
    public static void main(String[] args) {
        UserService userService = new UserService();
        // trong UserService đã có sẵn object MailSender đc new rồi
        userService.registerAccount("tuhihi@gmail.com");

        // Câu hỏi: TUI MUỐN DÙNG SMS THÌ SAO?? CODE THÊM, NHƯNG SỬA TỚI ĐÂU, SỬA NHIỀU HAY ÍT CLASS
        // KHÔNG NEW MAILSENDER NGẦM NGẦM ĐƯỢC HAY KHÔNG?
        // VÌ ĐÔI KHI APP TA, PHẦN MAIL SENDER CHỈ ĐANG CHƠI GOOGLE MAIL ĐỂ GỬI
        // GIỜ TUI MUỐN DÙNG YAHOO, MS MAIL ĐỂ GỬI



    }
}
