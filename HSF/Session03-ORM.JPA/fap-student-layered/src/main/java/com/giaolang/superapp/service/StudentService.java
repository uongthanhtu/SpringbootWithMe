package com.giaolang.superapp.service;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.infra.JpaUtil;
import com.giaolang.superapp.repository.StudentRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentService {

    //CLASS NÀY ĐỨNG GIỮA, HỨNG INFO TỪ USER/NGƯỜI DÙNG, TẠO OBJECT, ĐẨY XUỐNG
    //CHO REPO LO GIÚP
    //NÓ CŨNG NHỜ REPO LẤY OBJECT TỪ TABLE, ĐẨY NGƯỢC LÊN UI CHO USER XEM

    //CHẮC CHẮN NÓ PHẢI KHAI BÁO BIẾN REPO ĐỂ REPO GIÚP
    //CHỈ CẦN 1 BIẾN REPO DÙNG CHUNG CHO CÁC HÀM, DO MÌNH GỌI BÊN TRONG REPO
    //.save()  .findAll()...

    //CLASS NÀY PHẢI CHUẨN BỊ OBJECT ĐỂ ĐƯA XUỐNG REPO

    //TÊN HÀM CLASS NÀY ĐẶT THƯỜNG GẦN GŨI VỚI USER HƠN, DO GẦN USER GẦN HƠN DB, MÌNH LÀ SERVICE CUNG CẤP DATA CHO USER, NHẬN THẦU DATA TỪ USER
    //TÊN HÀM GỢI Ý:
    //createStudent()  getAllStudents()  updateStudent() deleteStudent()

    //FLOW:  UI --- SERVICE (ĐÂY) --- REPO --- JPAUTIL (ENTITY-MANAGER VÀ FACTORY) --- TABLE
    private StudentRepo studentRepo = new StudentRepo();

    public void createStudent(Student obj) {
        //cần repo, dùng riêng, chung okie
        //TODO: CHECK TRÙNG KEY, EMAIL, VALIDATE...
        //TODO: BẮT TRY-CATCH THÔNG BÁO...
        studentRepo.save(obj);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void updateStudent(Student obj) {
        studentRepo.update(obj);
    }

    public void deleteStudent(Student obj) {
        studentRepo.delete(obj);
    }

    public void deleteStudent(String id) {
        studentRepo.delete(id);
    }

}
