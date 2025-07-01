package com.giaolang.superapp.service;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.repository.StudentRepository;

import java.util.List;

public class StudentService {
    //CLASS NÀY SẼ NHẬN INFO TỪ GUI/WEB VÀ ĐẨY XUỐNG REPO
    //GUI ------- SERVICE -------- REPO --------- UTIL ---------- TABLE
    //L1            L2                  L3
    //LAYER: TẦNG, KIẾN TRÚC 3-LAYER
    //CODE DỰ ÁN THẬT NGOÀI ĐỜI CÒN THÊM : REPO CÓ THÊM INTERFACE
    //                                      SERVICE CÓ THÊM INTERFACE

    //service cần object repo dể CRUD
    private StudentRepository studentRepository = new StudentRepository();

    //CÁC HÀM CRUD STUDENT BÌNH THƯỜNG, DÙNG CHO GUI
    // TÊN HÀM THƯỜNG GẦN GŨI HƠN SO VỚI REPO
    //saveStudent() getAllStudents() searchStudentById()
    //removeStudent() updateStudent()

    public void save(Student student) {
        //mình có thể thêm các tiền xử lí : trùng email, trùng id, ,,,
        //sau đó mới mới gọi repo xuống table
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    public void deleteStudent(String id) {
        studentRepository.remove(id);
    }

}
