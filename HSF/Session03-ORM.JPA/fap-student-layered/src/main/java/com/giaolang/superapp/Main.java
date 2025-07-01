package com.giaolang.superapp;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.service.StudentService;

public class Main {


    public static void main(String[] args) {
        //FLOW:  UI (ĐÂY) --- SERVICE --- REPO --- JPAUTIL (ENTITY-MANAGER VÀ FACTORY) --- TABLE
        StudentService studentService = new StudentService();
        //1. TẠO MỚI HỒ SƠ SINH VIÊN
        //Student an = new Student("SE10", "AN NGUYỄN", 2005, 8.6);
        //studentService.createStudent(an);
        //studentService.createStudent(new Student("SE11", "BÌNH LÊ", 2005, 8.7));

        //2. SHOW ALL
        System.out.println("THE LIST STUDENTS");
        studentService.getAllStudents().forEach(x -> System.out.println(x));
        //GỌI THẦM TÊN EM TOSTRING()

        //3. UPDATE 1 HỒ SƠ SV
        //Student an = new Student("SE10", "AN NGUYỄN VĂN", 2005, 9.2);
        //studentService.updateStudent(an);

        //System.out.println("THE LIST STUDENTS AFTER UPDATING");
        //studentService.getAllStudents().forEach(x -> System.out.println(x));

        //4. REMOVE 1 HỒ SƠ SV
        studentService.deleteStudent("SE11");
        System.out.println("THE LIST STUDENTS AFTER DELETING");
        studentService.getAllStudents().forEach(x -> System.out.println(x));


    }
}