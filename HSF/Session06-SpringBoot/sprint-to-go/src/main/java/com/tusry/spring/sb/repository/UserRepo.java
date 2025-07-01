package com.tusry.spring.sb.repository;

import org.springframework.stereotype.Repository;

@Repository // @Component, @Service okie luôn nhưng...
public class UserRepo {
    // mock - làm giả mấy cái hàm để test xem chúng gọi nhau ổn không
    // các hàm CRUD, tên ham đặt gần với table
    // Xài JPA/Hibernate như đã học - xài thuần chưa dùng SpringDate
    //thì phảu tự viết JPQL(SQL style OOP) chỉ chơi object
    // SELECT ...
    //
    public void save() {
        System.out.println("Spring DAta/SpringJPA has been called to generate JPQL");
    }

    //findAll() findById()
}
