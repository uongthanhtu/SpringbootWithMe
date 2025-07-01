package com.tusry.spring.di;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    // class chịu trách nhiêm rất giỏi về CRUD table Account/ User, nhò JapUtils

    //mock/ làm giả cái hàm getAll()
    public void getAll () {
        System.out.println("Here is the list of Users from table Account....");
    }
}
