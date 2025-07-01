package com.tusry.di.v2setter;

public class MainSetter {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.setMailSender(new MailSender());
        userService.registerAccount("tuhihihi@gmail.com");
    }
}
