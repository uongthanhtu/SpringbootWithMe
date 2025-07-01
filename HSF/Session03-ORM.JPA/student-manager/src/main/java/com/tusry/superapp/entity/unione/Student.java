package com.tusry.superapp.entity.unione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
                '}';
    }
}
