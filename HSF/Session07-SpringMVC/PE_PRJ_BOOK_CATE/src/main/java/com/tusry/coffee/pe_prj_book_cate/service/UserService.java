package com.tusry.coffee.pe_prj_book_cate.service;

import com.tusry.coffee.pe_prj_book_cate.entity.User;
import com.tusry.coffee.pe_prj_book_cate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void createUser(User user) {
        userRepository.save(user);
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
