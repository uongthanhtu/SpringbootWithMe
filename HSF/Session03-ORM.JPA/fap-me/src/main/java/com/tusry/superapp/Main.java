package com.tusry.superapp;

import com.tusry.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //insertStudents();
        //getAllStudents();
        //searchStudents();
        //findByID();
        //updateStudent();
        removeStudent();
    }

    //Hàm update 1 record, nhưng trong ORM thì là UPDATE/SETTER 1 OBJECT
    //OBJECT nào?, object được lấy từ hàm search, hàm find()
    //tự ORM sẽ biêt object nào bị thay đổi trạng thái và ập nhật lâu dài xuống DB -> cất trữ lâu dài xuống db -> cất trữ lâu dài -> persit (V) persistance (N)
    //JPA: JAVA/JAKARTA PERSISTENCE API
    //KHI C THAY ĐỔI TRONG TABLE/DATABASE, BẮT BUỘC PHẢI NHÉT THAY ĐỔI NÀY TRONG CỤM LỆNH TRANSACTION
    //TRANSACTION: DO ALL OR  NOTHING - NGUYÊN LÝ ACID
    //              HOẶ TẤT CẢ, HOẶC KHÔNG GÌ CẢ

    //OPP: 4 +
    // ABSTRACTION, ENCAPSULATION, INHERITANCE, POLYMORPHISM
    //
    // 5+ NGUYÊN LÝ SOLID
    // S: SINGLE RESPONSIBILITY ĐƠN TRẮC NHIỆM TRONG THIẾT KẾ CLASS, MỖI CLASS KHÔNG NÊN ÔM DDOOMGF CÁC THỨ KHÔNG LIÊN QUAN
    //
    public static void updateStudent(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tusry.superapp-PU");
        EntityManager em = emf.createEntityManager();
        // giả xử muốn cập nhật điểm của SE000001
        em.getTransaction().begin();
        Student student = em.find(Student.class, "SE000001");
        student.setGpa(10);

        em.getTransaction().commit();
        findByID();
        // Dành cho tính năng edit 1 đơn hàng, khách hàng, khi chọn từ GRID/TABLE 1 dòng muốn edit lại
    }
    //Các framework ORM đều hỗ trợ tìm 1 record theo key
    //Record theo key

    public static void removeStudent(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tusry.superapp-PU");
        EntityManager em = emf.createEntityManager();
        // giả xử muốn xóa SE000001
        em.getTransaction().begin();
        Student student = em.find(Student.class, "SE000001");
        em.remove(student);
        em.getTransaction().commit();
        em.close();
        emf.close();
        getAllStudents();
    }

    public static void findByID(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tusry.superapp-PU");
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, "SE000001");
        System.out.println(student);
        // Dành cho tính năng edit 1 đơn hàng, khách hàng, khi chọn từ GRID/TABLE 1 dòng muốn edit lại

    }

    public static void insertStudents(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tusry.superapp-PU"); // gửi thông số cấu hình, nhà thầu JPA: Hibernate, nhà thầu JDBC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL SERVER
        EntityManager em = emf.createEntityManager();
        //Tạo ra 1 object dùng để quản lí entity, class ~ map sang table. Class Student chịu sự quản lí của EntityManager
        //em/EntityManager sẽ lo 1 CRUD trên 1 table nào đó!
        // qua mấy hàm huyền thoại: persit(), find(), merge(), remove()
        // Toàn chơi object, đằng sau là table bị ảnh hưởng - tự sinh ra sql ngầm và nó  cho mình thấy câu sql này luôn khi mình chấm các hàm ở trên .persit(), .find(), .merge(), .remove()
        Student tu = new Student("SE000001", "Thanh Tú", 2004, 9);
        Student binh = new Student("SE000002", "Binh Bình", 2002, 8);
        Student cuong = new Student("SE000003", "Cường võ", 2003, 5);

        //gọi để sếp manage cho CRUD
        em.getTransaction().begin();//Bắt buộc có transaction khi có sự thay đổi trong DB

        em.persist(tu);
        em.persist(binh);
        em.persist(cuong);
        em.getTransaction().commit(); // hoặc cả 3 thành công, hoặc chưa bạn nào đc insert
        //SELECT KHÔNG CẦN VÌ KHÔNG THAY ĐỔI TRẠNG THÁI

        em.close();
        emf.close();
    }

    //JPQL: 1 dạng biến thể của câu SQL truyền thống nhưng viết theo OOP: OBJECT và chấm(getter,setter, method)
    //Lấy tất cả data từ table -> là class student
    //"FROM STUDENT" - SQL truyền thống : SELECT * FROM STUDENT
    //"SELECT nt FROM Student nt" ~ SQL: SELECT * FROM STUDENT
    //                        nt là 1 biến trỏ vào object Student
    //                        nt = new Student() lấy từ trong table
    //ta sẽ select nt

    //SELECT CÓ WHERE ĐỂ DÀNH CHO SEARCH WHERE
    // "FROM Student x WHERE x.name = :pName" // pName sẽ được truyền vào sau
    // "SELECT x FROM Student x WHERE x.name = :pName" // pName sẽ được truyền vào sau

    // "SELECT x FROM Student x WHERE x.name LIKE :pName" // pName sẽ được truyền vào sau, THEO format like "%A%" tên có chữ A.

    public static void getAllStudents(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tusry.superapp-PU"); // gửi thông số cấu hình, nhà thầu JPA: Hibernate, nhà thầu JDBC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL SERVER
        EntityManager em = emf.createEntityManager();
        List<Student> result = em.createQuery("SELECT x FROM Student x", Student.class).getResultList();
        System.out.println("The list students (3 records)");
//        for (Student student : result) {
//            //System.out.println(student);
//            System.out.printf("|%8s|%-50s|%4d|%5d\n", student.getId(), student.getName(), student.getYob(), student.getGpa());
//        }
        result.forEach(x -> System.out.println(x));
        result.forEach(student -> System.out.printf("|%8s|%-50s|%4d|%5d\n", student.getId(),
                student.getName(), student.getYob(), student.getGpa()));

        result.forEach(student -> {
            System.out.println("Các số từ 1...100");
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
        });

        // lambda dính dáng đến stream api
        //xử lí filter ữ liệu trong ram. siêu trí tuệ VN
        em.close();
        emf.close();

    }

    public static void searchStudents(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tusry.superapp-PU");
        EntityManager em = emf.createEntityManager();
        System.out.println("Search by gpa = 8");
        List<Student> result = em.createQuery("SELECT x FROM Student x WHERE x.gpa = 8", Student.class).getResultList();
        result.forEach(student -> System.out.println(student));
        result = em.createQuery("SELECT x FROM Student x WHERE x.yob = :pYob", Student.class).setParameter("pYob", 2004).getResultList();
        System.out.println("Search by yob = 2004");
        result.forEach(student -> System.out.println(student));
    }


}