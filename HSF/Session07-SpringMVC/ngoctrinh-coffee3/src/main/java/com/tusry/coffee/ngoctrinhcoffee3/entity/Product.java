package com.tusry.coffee.ngoctrinhcoffee3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @Column(name = "Id")
    @NotBlank(message = "Id is required")
    private String id;
    @NotBlank(message = "Name is required")
    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String name;
    @Column(name = "Quantity", nullable = false)
    @Max(value = 100, message = " The quantity need less than 100")
    @Min(value = 10, message = " The quantity need more than 10 ")
    private int quantity;
    @Column(name = "Price", nullable = false)
    @Max(value = 1000000, message = " The price need less than 1000000 ")
    @Min(value = 20000, message = " The price need more than 20000 ")
    private double price;

    @ManyToOne
    @JoinColumn(name = "CateId")
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
