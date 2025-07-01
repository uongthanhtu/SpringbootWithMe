package com.tusry.di.v1constructor;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainDIV1 {
    public static void main(String[] args) {

        //MailSender mailSender = new MailSender();
        // UserService userService = new UserService(mailSender); tiêm obj vào trong
        UserService userService = new UserService(new MailSender()); // tiêm obj vào trong

        // Main class là nơi tạo ra object dependency và truyền vào nơi cần UserService
        // new MailSender
        // Main còn gọi là Container nơi chứa object dependency
        // hành dộng class không chủ động new, không chủ động việc kiểm soat tạo dependency nữa mà đưa cho nơi khác lo, ở đây là Main
        // ta class A, class UserService đã trao quyền kiểm soát việc new dependency cho chỗ khác - được gọi là: IoC Inversion of Control, đảo ngược điều khiển code
        // thay vì mình (Service) lo hết vieectaoj dependency, nay để cho đứa khác lo

        //SPRING, SPRINGBOOT lo cho mình 2 việc : tạo ra object dependency
        // chích và tiêm vào luôn -> IoC CONTAINER(ApplicationContext)

        userService.registerAccount("tuhaycuoi@gmail.com");


    }
}