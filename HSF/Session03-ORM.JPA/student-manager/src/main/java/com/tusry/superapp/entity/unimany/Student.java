package com.tusry.superapp.entity.unimany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//
//@Entity
//@Table(name = "Student")
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;
    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;
    @Column(name = "Yob")
    private int yob;
    @Column(name = "Gpa")
    private double gpa;

    //1 student thuộc về 1 chuyên ngành
    //ta
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "MajorId")
    private Major major;
    public void setMajor(Major major) {

        this.major = major;
    }

    public Student() {}
    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                ", major=" + major +
                '}';
    }
}
