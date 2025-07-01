package com.tusry.superapp.entity.unione;

import com.tusry.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainUniOne {
    public static void main(String[] args) {
        Major major1 = new Major("SE", "SOFTWARE ENGINEERIN");
        Major major2 = new Major("GD", "GRAPHIC ENGINEERIN");
        Student se1 = new Student("SE1110","Bình Lê", 2004, 9.2);
        Student se2 = new Student("SE1200","Tú Nguyễn", 2004, 7.2);
        Student gd1 = new Student("GD1100","Bình Lê", 2004, 9.2);
        Student gd2 = new Student("GD1200","Tú Nguyễn", 2004, 7.2);
        major1.addStudent(se1);
        major1.addStudent(se2);
        major2.addStudent(gd1);
        major2.addStudent(gd2);
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major1);
        em.persist(major2);
        em.getTransaction().commit();
        em.close();

        //2. MAJOR ĐI XỐNG, 4 STUDENT ĐI THEO KÈM KHÓA NGOẠI TƯƠNG ỨNG

        // ĐỌC THÔNG TIN SINH VIÊN VÀ THẤY KHÔNG BIẾT CHUYÊN NGÀNH GÌ, TRONG ĐÓ CLASS STUDENT KHÔNG THAM CHIẾU ĐẾN MAJOR
        List<Student> result = em.createQuery("from Student").getResultList();
        result.forEach(System.out::println);

    }
}
