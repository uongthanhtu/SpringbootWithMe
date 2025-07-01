package com.giaolang.coffee.entity;

//tương lai là @Entity để xuống table, bữa nay làm nháp trong RAM, new hard-coded data thay vì lấy từ table!!!
public class Product {

    private String id;
    //nếu key tự tăng thì phải xài Long (wrapper class - số nhưng lưu như là object), ko dùng primitive long!!!
    private String name;
    private double price;

    //boiler-plate code: constructor, get/set, toString()
    //alt - insert, hoặc fn - alt - insert, chọn generate...

    public Product() {
    }

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
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
                ", price=" + price +
                '}';
    }
}
