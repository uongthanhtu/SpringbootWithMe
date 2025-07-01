package com.tusry.coffee.ngoctrinhcoffee3.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @Column(name = "Id")
    private String id;
    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String name;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Column(name = "Price", nullable = false)
    private double price;

    // relationship MANY TO ONE - NHIỀU SẢN PHẨM THÌ SẼ THUỘC VỀ 1 CATEGORY
    //                                  1 CATEGORY CÓ THỂ CÓ NHIỀU SẢN PHẨM
    @ManyToOne
    @JoinColumn(name = "CateId") // cột khóa ngoại , phần DB
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
