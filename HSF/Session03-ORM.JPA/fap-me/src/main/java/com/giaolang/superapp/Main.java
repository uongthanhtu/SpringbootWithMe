package com.giaolang.superapp;

import com.giaolang.superapp.entity.Lecturer;
import com.giaolang.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.superapp-PU");

    public static void main(String[] args) {
        //insertStudents(); //tạo bảng, chèn data qua OOP, CODE FIRST
        //getAllStudents();  //select * from style OOP, CODE FIRST
        //insertLecturers();
        getAllLecturers();
    }


    //HỌC THÊM VỀ JPQL: JAVA PERSISTENCE QUERY LANGUAGE
    //LÀ PHIÊN BẢN ĐỘ TỪ SQL NHƯNG DÀNH CHO THẾ GIỚI OOP, OBJECT
    //HIBERNATE CX CÓ PHIÊN BẢN RIÊNG NỮA CỦA NÓ GỌI HQL
    //SQL: SELECT * FROM LECTURER
    //JPQL: FROM LECTURER
    //      SELECT lec FROM LECTURER lec
    //                      với mỗi dòng/record lấy từ table Lecturer
    //                      ta new nó trong RAM, new Lecturer() và gọi vùng new này là
    //                      lec, tức là lec = new Lecturer()
    //                      và lặp lại cho toàn bộ record trong table Lecturer
    //ADD KẾT QUẢ ĐỌC TỪ TABLE VÀO KẾT QUẢ CUỐI CÙNG DÙNG LỆNH SELECT lec
    //SELECT lec tức là lấy từng object lec được new từ từng dòng trong table Lecturer

    //WHERE
    //SQL: SELECT * FROM Lecturer WHERE Salary = 2000000 //tên cột trong table
    //JPQL: SELECT x FROM Lecturer x WHERE x.salary = 2000000 //tên field trong class
    //                           x. là biến object nhen!!!, ko phải cột trong talbe!!!
    public static void getAllLecturers() {
        EntityManager em = emf.createEntityManager();
        //luôn cần có người quản lí các Entity
        //viết câu SQL style object, gọi là JPQL, HQL khá giống SQL truyền thống, nhưng là làm việc, select, thao tác trên object, trên cái class Entity chứ ko quan tâm tên cột trong table như JDBC ĐÃ HỌC
        List<Lecturer> result = em.createQuery("SELECT x FROM Lecturer x WHERE x.salary = 20000000", Lecturer.class).getResultList();
        //Lecturer là class, từ đó sinh ra object, class Lecturer đã đc map thành table Lecture ở bên khai báo @Entity
        //in kq
        System.out.println("The list of lecturers (" + result.size() + " records):");
        for (Lecturer x : result) { //toán tử với mọi - chữ A ngược trong toán học
            System.out.println(x);  //gọi thầm tên em toString()
        }

        //BIỂU THỨC LAMBDA - LAMBDA EXPRESSION, DÍNH DÁNG CỰC KÌ CHẶT CHẼ VỚI STREAM-API, CƠ CHẾ XỬ LÍ NHIỀU DỮ LIỆU Ở TRONG RAM
        //LAMBDA EXPRESSION LÀ HÀM VÔ DANH, HÀM ẨN DANH!!! HÀM KO CÓ TÊN
        //DÍNH ĐẾN KHÁI NIỆM LẬP TRÌNH HÀM - FUNCTIONAL PROGRAMMING
        //HÀM ĐC XEM LÀ 1 DATA, VÀ HÀM LÀ THAM SỐ ĐỂ TRUYỀN VÀO HÀM KHÁC
        System.out.println("The list of students printed by lambda expression");
        result.forEach(x -> {
            System.out.println(x);
        });

//        //làm điều nhảm với lambda
//        result.forEach(x ->
//        {
//            //System.out.println(x); //ko thèm lấy x để dùng, làm chơi trò khác
//            System.out.println("The list of numbers from 1 to 100");
//            for (int i = 1; i <= 100 ; i++) {
//                System.out.print(i + " ");
//            }
//        });

        em.close();
        emf.close();  //sau getAll() mà ko làm gì nữa thì close luôn connection
    }

    public static void insertLecturers() {
        //lôi cổ ông sếp quản lí các Entity ra để tạo table, chèn data vào table Lecturer - option XML create, hay update đều mlem!!!!
        //ĐI LÀM THẬT, CẤM OPTION "CREATE" TRÊN MÁY KHÁCH HÀNG NẾU TA FIX BUG, UPDATE APP
        //VÌ TOANG HẾT DATA KHÁCH HÀNG!!!!
        Lecturer an = new Lecturer("AN NGUYỄN", 1990, 20_000_000);
        Lecturer binh = new Lecturer("BÌNH LÊ", 1991, 20_000_001);

        EntityManager em = emf.createEntityManager();
        //VÌ CÓ THAY ĐỔI TRÊN CSDL (TABLE, DATA) NÊN TA CẦN THEO DÕI CHẶT CHẼ CÁC CÂU LỆNH -> DÙNG KHÁI NIỆM TRANSACTION: DO ALL OR NOTHING
        //HOẶC TẤT CẢ, HOẶC KO GÌ CẢ. NGUYÊN LÝ ACID CỦA TRANSACTION
        //VÍ DỤ: BẠN CHUYỂN TIỀN TRẢ NỢ THẰNG BẠN 1 TRIỆU ĐỒNG
        //TỪ TPBANK (MÌNH) SANG ACB (THẰNG BẠN)
        //TPBANK -1M  VÀ        ACB +1M   => CẢ 2 PHẢI XẢY RA MỚI OKIE
        //RỚT 1 TRONG 2, ROLLBACK, HOẶC TẤT CẢ, HOẶC CHƯA GÌ CẢ!!!
        //BÊN TPBANK: KHỞI ĐỘNG NGAY TRANSACTION THEO DÕI
        //MÌNH ĐÃ -1M, MÃI CHƯA THẤY BÊN KIA NOTI OKIE -> NHÀ MÌNH UNDO!!!
        em.getTransaction().begin();  //BẮT ĐẦU THEO DOÕI SỰ THAY ĐỔI DB NHENN
        em.persist(an);
        em.persist(binh);
        em.getTransaction().commit();  //KHOÁ SỔ, HOẶC 2 OBJ XUỐNG DB, HOẶC KO AI CẢ
        em.close();
        //emf.close();


    }

    //SPRING DATA, SPRING JPA

    //INSERT/TẠO MỚI SV...
    public static void insertStudents() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.superapp-PU"); //gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JDBC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL Server
        EntityManager em = emf.createEntityManager();
        //tạo ra 1 object dùng để quản lí các entity class ~ map ngang sang table. Class Student chịu sự quản lí của em/EntityManager
        //em/EntityManager sẽ lo CRUD trên 1 table nào đó!
        //qua mấy hàm huyền thoại: persit() find() merge() remove()
        //TOÀN CHƠI OBJECT, ĐẰNG SAU LÀ TABLE BỊ ẢNH HƯỞNG - TỰ SINH SQL NGẦM, VÀ NÓ CHO MÌNH THẤY CÂU SQL NÀY LUÔN KHI MÌNH CHẤM CÁC HÀM Ở TRÊN .persit() .find() .merge() .remove()
        //chuẩn bị data Student - object nhen - OOP nhen
        Student an = new Student("SE10", "AN NGUYỄN", 2004, 8.6);
        Student binh = new Student("SE2", "BÌNH LÊ", 2004, 8.7);
        Student cuong = new Student("SE3", "CƯỜNG VÕ", 2004, 8.8);

        //gọi sếp EntityManage giúp CRUD
        em.getTransaction().begin(); //BẮT BUỘC PHẢI CÓ TRANSACTION KHI CÓ SỰ THAY ĐỔI TRONG DB
        em.persist(an);      //CREATE TABLE DIỄN RA NGẦM
        em.persist(binh);    //GỌI LÀ CODE FIRST, CODE RA TABLE
        em.persist(cuong);   //                   CODE RA DATA
                             //INSERT INTO STUDENT VALUES
        em.getTransaction().commit();  //HOẶC CẢ 3 INSERT THÀNH CÔNG, HOẶC CHƯA BẠN NÀO ĐC INSERT
        //SELECT KO CẦN, VÌ KO THAY ĐỔI TRẠNG THÁI TABLE 
        em.close();  //sa thải ông sếp vì đã xong
        //emf.close(); //ngắt kết nối csdl vì đã xong
    }

    //SELECT * ĐỂ LẤY HẾT DATA...
    public static void getAllStudents() {

        EntityManager em = emf.createEntityManager();
        List<Student> result = em.createQuery("FROM Student", Student.class).getResultList();  //HẬU TRƯỜNG LÀ SELECT * FROM STUDENT SQL TRUYỀN THỐNG - SẼ IN XEM NẾU KHAI BÁO CẤU HÌNH TRONG FILE .XML

        //QUERY NÀY CÚ PHÁP GẦN GIỐNG SQL, NHƯNG THEO STYLE OOP, CÓ OBJECT VÀ DẤU CHẤM, GỌI LÀ JPQL, HQL

        System.out.println("The list of students (3 records)");
        for (Student x : result) {
            System.out.println(x); //gọi thầm tên em toString() của Student
        }
        //dùng biểu thức Lambda để in cx đc

        em.close();
        emf.close();
    }
}