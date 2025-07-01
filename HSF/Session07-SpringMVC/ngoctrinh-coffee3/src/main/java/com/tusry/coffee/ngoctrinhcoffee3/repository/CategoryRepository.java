package com.tusry.coffee.ngoctrinhcoffee3.repository;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
