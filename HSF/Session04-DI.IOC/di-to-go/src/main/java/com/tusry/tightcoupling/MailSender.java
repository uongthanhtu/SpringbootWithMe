package com.tusry.tightcoupling;

public class MailSender {
    // class này chuyên phụ trách gửi email- pro trong công việc của mình
    // giúp chia việc độc lập!!!! Gom chung trong UserService, quá tải cho class đó và bạn dev phụ trách

    //pseudo code - code giả lập
    public void sendNoti(){
        //logic gửi mail ở đây: Khai báo các thông số email/ pass, server

        System.out.println("Email was sent to customer successfully!");

    }

}
