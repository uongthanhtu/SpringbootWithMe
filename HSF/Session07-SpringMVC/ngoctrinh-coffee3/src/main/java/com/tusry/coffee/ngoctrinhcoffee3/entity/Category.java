package com.tusry.coffee.ngoctrinhcoffee3.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(1000)")
    private String description;

    // Mối quan hệ với Product ..... 1-N
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> productList = new ArrayList<Product>();

    // cho 1 sản phẩm nào đó thuộc về category này
    public void addProduct(Product product) {
        productList.add(product);
        // chính trong Object o thì cũng phải lưu tôi đã thuộc về đội
        product.setCategory(this);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
        product.setCategory(null);
    }

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
