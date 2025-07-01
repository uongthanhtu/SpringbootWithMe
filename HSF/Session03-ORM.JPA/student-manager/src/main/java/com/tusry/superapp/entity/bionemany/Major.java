package com.tusry.superapp.entity.bionemany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
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

    //BI-DIRECTIONAL RELATIONSHIP
    //ĐỨNG BÊN NÀY, NGÓ BÊN KIA, ĐỨNG BÊN MAJOR NGÓ BÊN STUDENTS
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    //Ủy quyền cho bên Student làm khóa ngoại
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setMajor(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        //1 sinh viên ra khỏi list chuyên ngành students
        // nhưng bản thân info chuyên ngành của bạn OBJ cũng phải không thuộc về chuyên ngành vừa xóa
        student.setMajor(null);
    }

    //trả về danh sách sinh viên của 1 chuyen ngành hàm get()
    //hậu trường chính là câu join select * from STUDENT s, MAJOR m WHERE .... AND m.id = 'SE'
    public List<Student> getStudents() {
        return students;
    }


    // đưa 1 sv vào chuyên ngành, sinh viên đăng kí chuyên ngành

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
