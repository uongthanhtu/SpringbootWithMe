package com.tusry.coffee.pe_prj_book_cate.repository;

import com.tusry.coffee.pe_prj_book_cate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
