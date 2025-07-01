package com.tusry.superapp.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    //ta se dung cac ki hieu - annotation @ de yeu cau javac, jvm, jpa, hibernate, jdbc bien doi class thanh table
    @Id
    @Column(name = "Id" , columnDefinition = "CHAR(8)")
    private String id;
    //String mặc định sẽ là varchar255 -> muốn string biến thành char() thì ta cần thêm cấu hình
    @Column(name = "Name", nullable = false, length = 50)
    @Nationalized //thiếu khai báo này, spring -> nvarchar không lưu tiếng việt, để string -> nvarchar thì cần thêm khai báo @Nationalized
    private String name;
    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private int gpa;

    //bat

}
