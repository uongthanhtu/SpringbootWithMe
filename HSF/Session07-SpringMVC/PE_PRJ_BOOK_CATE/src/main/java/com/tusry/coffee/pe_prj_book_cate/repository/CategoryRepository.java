package com.tusry.coffee.pe_prj_book_cate.repository;

import com.tusry.coffee.pe_prj_book_cate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
