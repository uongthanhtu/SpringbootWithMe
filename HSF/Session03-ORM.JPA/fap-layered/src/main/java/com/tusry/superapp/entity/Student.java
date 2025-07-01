package com.tusry.superapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id; // key tự tăng -> không new cột này
    @Column(name = "StuName", nullable = false, length = 50)
    @Nationalized
    private String name;
    @Column(name = "Yob", nullable = false)
    private int yob;
    @Column(name = "Gpa")
    private double gpa;

    //BOILERPLATE CODE
    //BẮT BUỘC PHẢI CÓ CONSTRUCTOR RỖNG, FULL THAM SỐ (KEY TỰ TĂNG THÌ SAO)
}
