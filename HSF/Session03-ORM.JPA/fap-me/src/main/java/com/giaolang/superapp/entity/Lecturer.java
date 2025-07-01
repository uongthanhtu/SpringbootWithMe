package com.giaolang.superapp.entity;

import jakarta.persistence.*;

@Entity //em muốn map/ánh xạ class này thành 1 table tương ứng số cột số field
@Table(name = "Lecturer") //tên table có thể khác tên class, thì dùng @Table
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tự generate key là con số tự tăng từ 1
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)",  length = 50, nullable = false)
    private String name;    //NVARCHAR(50) NOT NULL

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Salary")
    private double salary;

    //LOMBOK ĐỂ LOẠI BỎ BOILER-PLATE
    //BẮT BUỘC PHẢI CÓ:
    //CTOR RỖNG, CTOR FULL THAM SỐ, GET() SET() TOSTRING()

    public Lecturer() {
    }

    public Lecturer(String name, int yob, double salary) {
        this.name = name;
        this.yob = yob;
        this.salary = salary;
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", salary=" + salary +
                '}';
    }
}
