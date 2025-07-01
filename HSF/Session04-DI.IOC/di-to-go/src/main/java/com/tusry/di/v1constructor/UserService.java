package com.tusry.di.v1constructor;


public class UserService {
    private MailSender mailSender; // không new mà chờ đưa từ bên ngoài đưa vào, chích / tiêm từ bên ngoài, new đâu đó đưa vào đây

    // DI chính là kĩ thuật đưa 1 object phụ thuộc ở bên ngoài đưa vào trong nơi cần nó, new B() đưa vào class A qua constructor, A không tự new ngầm bên trong
    public UserService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    // có 4 cách chích/ tiêm 1 object mà ta không chủ động new
    // qua field = ???
    // qua constructor
    // qua setter
    // dùng framwork

    public void registerAccount(String email) {
        System.out.println("Send mail to in service" + email);
        mailSender.sendNoti();
    }
}
