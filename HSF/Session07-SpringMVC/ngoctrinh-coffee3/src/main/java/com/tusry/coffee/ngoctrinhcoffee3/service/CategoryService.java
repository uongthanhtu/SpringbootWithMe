package com.tusry.coffee.ngoctrinhcoffee3.service;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Category;
import com.tusry.coffee.ngoctrinhcoffee3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // tạo hàm crud như truyền thống
    // bài thi PE chỉ cần :
    // hàm save(), để mình save data lúc khởi đầu
    // hàm getAll(), để minh cung cấp cho drop-down

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }


}
