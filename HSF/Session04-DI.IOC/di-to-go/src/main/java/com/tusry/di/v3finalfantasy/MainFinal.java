package com.tusry.di.v3finalfantasy;


public class MainFinal {
    public static void main(String[] args) {
        // DI, IoC, Polymorphism, SO của solid
        //
        NotiService smsSender = new SmsSender();
        NotiService mailSender = new EmailSender();

        // Muốn xài thằng nào trích tiêm thằng đó
        UserService userService = new UserService(mailSender);
        userService.registerUser(); // đa hình ngầm bên trong hàm gửi noti

        //Thách thức danh hài: SMS QUA MOBI
        //1. TẠO CLASS RỜI            MobiSMS implements NotiService(...)
        //2. ANONYMOUS CLASS

        NotiService mobi = new NotiService() {
            @Override
            public void sendNoti() {
                System.out.println("Sending noti {MOBIPHONEEEEEEEEEE}");
            }
        };

        UserService userService2 = new UserService(mobi);
        userService2.registerUser();
    }
}
