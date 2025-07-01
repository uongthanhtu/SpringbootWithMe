package com.giaolang.superapp.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // class này chứa hàm static để liên kết kết ối với DB
    // nó khởi động 1 lần duy nhất khi app được khời động, tránh mỗi lần nó khởi động, nó sẽ đọc lại thông số kết nói, csdl và nó sẽ có khả năng reset database (tùy option trong file Persistence.xml)
    private static final String PERSISTENCE_UNIT_NAME = "com.giaolang.superapp-PU";
    private static EntityManagerFactory emf;

    // khối lệnh static sẽ được chạy duy nhất 1 lần khi class này được chạm vào đầu tiên ~ giống contructor chạy đầu tiên
    //đoạn code này hay dùng cho việc khởi động cho những giá trị gì đó
    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            // kĩ thuật viết code mà chỉ có 1 object được tạo ra, không có 2 nhát new() cái gì đó, kĩ thuật này gọi là : SINGLETON
            // làm sao để có 1 SINGLETON: Phi STATIC BẤT THÀNH SINGLETON
        }catch (Exception e) {
            System.out.println("Failed to create entity manager factory");
            throw  new RuntimeException(e);
        }



    }
    // HÀM TRẢ RA ÔNG SẾP ENTITYMANAGER CHO CÁC NƠI KHÁC XÀI ĐỂ QUẢN LÍ CÁC ENTITY KHÁC
    public static EntityManager getEntityManager(){
        return emf.createEntityManager(); // new 1 ôn g đếp EMF (ông kết nối) thì ta trả thêm ông này
    }

    //Đóng kết nối EMF
    public static void shutdown(EntityManager em){
        em.close();
    }
}
