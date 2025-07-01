package com.tusry.coffee.ngoctrinhcoffee3.service;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Account;
import com.tusry.coffee.ngoctrinhcoffee3.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    AccountRepository userRepository;

    public Account login (String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
