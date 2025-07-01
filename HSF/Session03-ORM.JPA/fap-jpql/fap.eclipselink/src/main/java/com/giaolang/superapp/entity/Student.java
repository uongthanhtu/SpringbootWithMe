package com.giaolang.superapp.entity;

import jakarta.persistence.*;
//import org.hibernate.annotations.Nationalized;

//import org.hibernate.annotations.Nationalized;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

//CLASS NÀY SẼ ĐC KHAI BÁO ĐỂ
//ÁNH XẠ/BIẾN ĐỔI TƯƠNG ĐƯƠNG, ĐC MAP THÀNH TABLE TƯƠNG ỨNG
@Entity
@Table(name = "Student")  //nếu ko có khai báo này thì mặc định lấy tên class thành tên table!!!
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)") //nếu ko có khai báo này, thì mặc định lấy tên field làm tên cột
    private String id; //camelCase, id tự nhập (id tự tăng tính sau)

    @Column(name = "Name", nullable = false, length = 50, columnDefinition = "NVARCHAR(50)")
    //@Nationalized //THIẾU KHAI BÁO NÀY, THÌ STRING -> VARCHAR
    //              KO LƯU TIẾNG VIỆT CÓ DẤU. ĐỂ STRING -> NVARCHAR THÌ CẦN THÊM KHAI BÁO @NATIONALIZED
    //NẾU KO LÀM, TIẾNG VIỆT SẼ DẤU ? THAY THẾ CHO DẤU '\?~/
    //TA DÙNG @NATIONALIZED CỦA HIBERNATE SẼ MẤT ĐI TÍNH KHẢ CHUYỂN KHI CODE NÀY KO THỀ CHƠI ĐC VỚI NHÀ THẦU ECLIPSELINK
    //ĐỘ VARCHAR CHƠI VỚI NHIỀU NHÀ CUNG CẤP ORM/JPA QUA COLUMNDEFINTION
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    //BẮT BUỘC PHẢI CÓ CONSTRUCTOR RỖNG, CONSTRUCTOR FULL THAM SỐ
    //GET()/SET()/TOSTRING()
    //BOILER-PLATE, LOMBOK
    //THÊM DEPENDENCY LOMBOK SAU...

    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }
}
