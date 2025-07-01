package com.tusry.superapp.entity.unimany;

import com.tusry.superapp.entity.unimany.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
//@Entity
//@Table
public class Major {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;
    @Column(name = "name", columnDefinition = "NVARCHAR(50)")
    //KHÔNG DÙNG @Nationalized => sẽ phụ thuộc hibernate
    private String name;

    //c1: cách trong mqh 1-N nó chứa nhiều thằng N
    //chỉ nhìn 1 chiều trong mối quan hệ UNI-DIRECTIONAL
    //
   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //cascade: cha đi xuống, con xuống theo
    //major xuống table, student xuống theo luôn
    //fetch: 1 load vào ram, thì đám N có đi theo luôn không
    //EARGE: ĐỌC LUÔN ĐÁM N, LAZY: TỪ TỪ HÃNG LẤY
//    @JoinColumn(name = "MajorID")
//    private List<com.tusry.superapp.entity.unione.Student> students = new ArrayList<>();

    //có 3 các hđể ta sờ vào students.Add(new Student() nào đó )
    //C1: cho students là public -> vi phạm Encapsulation
    //C2: cho sờ vào students qua getStudents() và get() truyền thống
    //C3: thêm hàm addStudent() ở class này, new Major() sau đó addStudent()
    //  Nguyên lý : S : SINGLE RESPONSIBILITY
    //TUI, MAJOR ĐANG NẮM DANH SÁCH SV, THÌ ADD THÊM 1 BẠN LÀ HỢP LÍ
//    public void  addStudent(Student obj) {
//        students.add(obj);
//    }
//
    public Major(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Major() {}


    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
