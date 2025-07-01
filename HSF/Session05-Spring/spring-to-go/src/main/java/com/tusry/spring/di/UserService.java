package com.tusry.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //Service cần sự trợ giúp từ Repo, EmailSender, 2 đứa này là Dependency
    //Code cũ, không DI, chủ động new
    private UserRepository repository; //= new UserRepository();
    private EmailSender emailSender ;//= new EmailSender();

    // code mới không new chỉ chờ tiêm vào -> Ai new: Spring new giúp, chích giúp

    // chích tiêm có 3 cách
    //
    @Autowired // new ở đâu vào chích vào giùm em
    public UserService(UserRepository repository, EmailSender emailSender) {
        this.repository = repository;
        this.emailSender = emailSender;
    }

    public void registerAccount(){
        repository.getAll();
        //để kiểm tra trùng email hay không
        //repo.persit() .save()
        emailSender.sendEmail();
    }

}
