package com.giaolang.superapp;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.service.StudentService;

import java.util.List;

public class Main3Layer {
    //class này thử nghiệm 3-layer, thay cho GUI
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student an = new Student("SE1", "AN NGUYỄN", 2004, 8.6);
        //studentService.save(an);
        //studentService.save(new Student("SE2", "BÌNH LÊ", 2004, 8.7));

        List<Student> result = studentService.getAllStudents();
        System.out.println("The list of student:" + result.size() +"records");
        result.forEach(System.out::println);
        //Student x = studentService.getStudentById("SE1");
        Student x = new Student("SE2", "BÌNH LÊ", 2004, 8.7);
        studentService.updateStudent(x);
        result = studentService.getAllStudents();
        result.forEach(System.out::println);
    }
}
