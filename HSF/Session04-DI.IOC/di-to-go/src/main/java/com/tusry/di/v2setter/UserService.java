package com.tusry.di.v2setter;

public class UserService {
    //trao quyền new dependency cho người khác là: IoC
    //Object dependency được đưa từ bên ngoài vào qua: constructor, hàm set, sở trực tiếp field thì gọi là DI
    // @Autowire -> Reflection
    private MailSender mailSender;

    // nhận obj từ constructor đã vừa học

    //chích qua con đường set() bị vấn đề null không gọi hàm này
    // chích qua con đường CONSTRUCTOR LUÔN ĐẢM BẢO RẰNG CÓ DEPENDENCY ĐC ĐƯA VÀO.

    public void setMailSender(MailSender email) {
        this.mailSender = email;
    }

    public void registerAccount(String email) {
        System.out.println("Send mail to in service" + email);
        mailSender.sendNoti();
    }
    // nhận obj qua set(), giống set()yob


}
