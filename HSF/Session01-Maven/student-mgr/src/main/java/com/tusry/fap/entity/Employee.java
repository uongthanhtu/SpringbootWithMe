package com.tusry.fap.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int empId;
    private String empName;
    private int empAge;
    private double empSalary;
}
