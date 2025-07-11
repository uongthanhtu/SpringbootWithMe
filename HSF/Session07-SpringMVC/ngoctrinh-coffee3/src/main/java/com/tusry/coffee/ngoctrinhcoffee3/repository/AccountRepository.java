package com.tusry.coffee.ngoctrinhcoffee3.repository;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsernameAndPassword(String username, String password);
}
