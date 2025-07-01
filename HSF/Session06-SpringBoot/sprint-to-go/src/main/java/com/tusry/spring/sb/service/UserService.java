package com.tusry.spring.sb.service;

import com.tusry.spring.sb.entity.ExcepGenerator;
import com.tusry.spring.sb.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //cần dependency rồi: chắc chắn cần UserRepo
    //                      có th generateEXcel

    //Chích tiêm này vào theo 3 đương chích
    //@Autowired        REFLECTION  TECHNIQUE
    private UserRepo repo;
    //@Autowired
    private ExcepGenerator generator;
    //@Autowired    --> mặc định không cần Constructor
    public UserService(UserRepo repo, ExcepGenerator generator) {
        this.repo = repo;
        this.generator = generator;
    }

    //đúng chuẩn là phải nhận DTO hoặc Entity từ Controller chuyển xuống
    //mock hoy
    public void createUser() {
        repo.save(); // có message đc in ra
    }


}
