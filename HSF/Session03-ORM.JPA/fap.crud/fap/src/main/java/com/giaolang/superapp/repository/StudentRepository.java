package com.giaolang.superapp.repository;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepository {

    //CLASS NÀY CHỨA CÁC HÀM CRUD TABLE STUDENT, CHƠI TRỰC TIẾP VỚI TABLE, DATABASE

    // CÁC HÀM CÓ XU HƯỚNG ĐẶT TÊN NGẮN GỌN, FOCUS VÀO THAO TÁC TRÊN TABLE

    // save() update() delete() getAll() find() findById()

    //mọi hàm này đều nhận object student bên ngoài ddauw vào
    // object này đén từ UI chuyền xuống, ở ây chỉ chơi với object student và table

    public void save(Student studentObj) {
        // cần ông giám đốc quản lí entity
        EntityManager em = JPAUtil.getEntityManager();
        // transaction
        em.getTransaction().begin();
        em.persist(studentObj);
        em.getTransaction().commit();
        em.close();
    }

    public List<Student> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("from Student", Student.class).getResultList();
    }//trả về để in trên web hoặc trả về để còn ra JSON
    //select không ảnh hưởng table, không cần transaction

    //id là String, hoặc số, nhớ sửa cho phù hợp bài toán
    //JPA cung cấp sẵn 1 hàm tìm theo key em.find(class nào, key gì)
    public Student findById(String id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Student.class, id);
    }

    //HÀM UPDATE VÀ REMOVE SẼ KẾ THỪA HÀM FIND
    public void remove(String id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Student obj = em.find(Student.class, id);
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    //đưa id kèm object ể đổ ngang info
    // chỉ đưa object , đè vào
    public void update(Student studentObj) {
        //xóa là phải theo dõi transaction
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(studentObj);
        em.getTransaction().commit();
        em.close();
    }


}
