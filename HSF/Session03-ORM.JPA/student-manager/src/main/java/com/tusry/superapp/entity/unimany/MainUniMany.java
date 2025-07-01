package com.tusry.superapp.entity.unimany;
import com.tusry.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainUniMany {
    public static void main(String[] args) {
        Major major1 = new Major("SE", "SOFTWARE ENGINEERIN");
        Major major2 = new Major("GD", "SOFTWARE ENGINEERIN");


        Student se1 = new Student("SE100","Bình Lê", 2004, 9.2);
        Student se2 = new Student("SE101","Tú Nguyễn", 2004, 7.2);
        Student gd1 = new Student("GD100","Bình Lê", 2004, 9.2);
        Student gd2 = new Student("GD101","Tú Nguyễn", 2004, 7.2);

        se1.setMajor(major1);
        se2.setMajor(major1);
        gd1.setMajor(major2);
        gd2.setMajor(major2);

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major1);
        em.persist(major2);

        em.persist(se1);
        em.persist(se2);
        em.persist(gd1);
        em.persist(gd2);

        em.getTransaction().commit();
        em.close();

        //2. MAJOR ĐI XỐNG, 4 STUDENT ĐI THEO KÈM KHÓA NGOẠI TƯƠNG ỨNG

        // ĐỌC THÔNG TIN SINH VIÊN VÀ THẤY KHÔNG BIẾT CHUYÊN NGÀNH GÌ, TRONG ĐÓ CLASS STUDENT KHÔNG THAM CHIẾU ĐẾN MAJOR

        em = JpaUtil.getEntityManager();
        List<Student> result = em.createQuery("from Student").getResultList();
        result.forEach(System.out::println);

    }
}
