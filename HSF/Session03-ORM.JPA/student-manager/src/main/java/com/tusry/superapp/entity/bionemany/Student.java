package com.tusry.superapp.entity.bionemany;
import com.tusry.superapp.entity.bionemany.Major;
import jakarta.persistence.*;


@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;
    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;
    @Column(name = "Yob")
    private int yob;
    @Column(name = "Gpa")
    private double gpa;

    //SV PHẢI THUỘC  CHUYÊN NGÀNH NÀO ĐÓ, CHỈ 1 THÔI, BIẾN ĐƠN, KHÔNG PHI LIST
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MajorId")
    private Major major;
    public void setMajor(Major obj) {
        major = obj;
        //sinh viên join vào chuyên ngành -> về hướng ngược lại chuyên ngành phải nhận sinb viên -> Major phải đc thêm sinh viên vào list
        // hãy đi vào list của obj
    }

    // nhu caafu cho been ngoài biết mình học chuyên ngành gì


    public Major getMajor() {
        return major;
    }

    public Student() {}
    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public int getYob() {
        return yob;
    }
}
