package com.tusry.coffee.ngoctrinhcoffee3.repository;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsernameAndPassword(String username, String password);
}
