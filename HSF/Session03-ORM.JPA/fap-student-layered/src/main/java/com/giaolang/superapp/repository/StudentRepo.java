package com.giaolang.superapp.repository;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepo {

    //CLASS NÀY CHỨA CÁC HÀM CRUD TRỰC TIẾP TABLE STUDENT - REPO: NHÀ KHO VỀ DỮ LIỆU
    //MUỐN CRUD TABLE THÌ PHẢI NHỜ VẢ ÔNG ENTITY-MANAGER ĐC CUNG CẤP TỪ JpaUtil SINGLETON
    //FLOW:  UI --- SERVICE --- REPO (ĐÂY) --- JPAUTIL (ENTITY-MANAGER VÀ FACTORY) --- TABLE

    //CÁC HÀM CRUD Ở ĐÂY THƯỜNG ĐẶT TÊN NGẮN GỌN, HƯỚNG HÀNH ĐỘNG GIỐNG NHƯ LỆNH SQL CHUẨN (INSERT, UPDATE, DELETE)
    //TÊN HÀM GỢI Ý: save()  update()   delete()   remove()   find() findAll() findById()
    //TUỲ HÀM, NHƯNG NẾU CÓ THAY ĐỔI TRONG TABLE (INSERT, UPDATE, DELETE) THÌ
    //HÀM SẼ NHẬN VÀO OBJECT (INSERT, UPDATE), HOẶC KEY (DELETE) DELETE ĐƯA OBJECT VẪN ĐC VÌ VÀO TRONG OBJECT, GET FIELD KEY ĐỂ XOÁ
    //NHỚ DÙNG TRANSACTION KHI THAY ĐỔI DATA TRONG TABLE (INSERT, UPDATE, DELETE)
    //SELECT KO CẦN, VÌ KO THAY ĐỔI DATA

    //HÀM INSERT XUỐNG TABLE
    public void save(Student obj) {
        //gọi EM (Entity Manager) nhờ giúp, kèm transaction - có thay đổi data
        EntityManager em = JpaUtil.getEntityManager(); //đoạn lệnh trôi nổi static {}
        //chạy duy nhất 1 lần, khởi động heavy connection
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        //try catch khi save bị lỗi - từ từ...
        em.close();  //giám đốc xong việc!!!
    }

    //HÀM LẤY TẤT CẢ SINH VIÊN - JPQL SELECT s FROM Student s
    public List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("FROM Student", Student.class).getResultList();
    }

    //SỬA THÔNG TIN SINH VIÊN - CẬP NHẬT
    public void update(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(obj);       //merge() nghĩa là tích hợp object đưa vào vào trong EM
        //EM nó sẽ đổ ngang, copy ngang obj vào TRONG obj ứng với dòng trong tabl
        //nếu bạn cố tình đưa object mà key ko tồn tại trong table, sẽ insert mới
        em.getTransaction().commit();
    }

    public void delete(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    //OVERLOAD
    public void delete(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        Student x = em.find(Student.class, id); //tìm ku sv có id = id đưa vào, gọi là x
        //và remove x, remove obj giống như trên
        em.remove(x);
        //em.remove(em.find(Student.class, id)); //VIẾT GỘP

        em.getTransaction().commit();
    }

    //TODO AT HOME: LÀM THÊM HÀM WHERE THEO CỘT NÀO ĐÓ, findById() TRẢ VỀ 1 STUDENT
}
