package com.tusry.coffee.ngoctrinhcoffee3.service;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Account;
import com.tusry.coffee.ngoctrinhcoffee3.repository.AccountRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository userRepository;

    public void save(Account account) {
        userRepository.save(account);
    }

}
