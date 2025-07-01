package com.tusry.coffee.ngoctrinhcoffee3.repository;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // mặc định JPA sẽ cung cấp cho bạn rất nhiều hàm, tự nó code luôn cho bạn
    // bạn chỉ cần đặt tên hàm theo 1 quy tắc, dính đên  tên field là sẽ có hàm luôn

}
