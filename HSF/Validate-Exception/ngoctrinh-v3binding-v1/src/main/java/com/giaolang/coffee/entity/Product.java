package com.giaolang.coffee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "Id", nullable = false)
    @NotBlank(message = "Id is required")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    @Pattern(regexp = "^[\\p{L}\\p{M}0-9 _-]+$", message = "Do not enter special characters")
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name = "Quantity", nullable = false)
    @NotNull(message = "Quantity is required")
    @Max(value = 100, message = " The quantity need >= 1 and <= 100")
    @Min(value = 1, message = " The quantity need >= 1 and <= 100")
    private int quantity;

    @Column(name = "Price", nullable = false)
    @NotNull(message = "Quantity is required")
    @Max(value = 10000000, message = " The price need >= 20 000 and <= 10 000 000")
    @Min(value = 20000, message = " The price need >= 20 000 and <= 10 000 000")
    private double price;

    //RELATIONSHIP MANY TO ONE - NHIỀU SẢN PHẨM CÓ THỂ THUỘC 1 CATEGORY
    //                           1 CATEGORY CÓ THỂ CÓ NHIỀU SẢN PHẨM
    @ManyToOne
    @JoinColumn(name = "CateId")  //cột khoá ngoại, phần DB
    private Category cate;        //phần OOP

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }


    public Product() {
    }

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
