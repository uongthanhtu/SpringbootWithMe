package com.tusry.fap;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //có 2 kĩ thuật ết nối vào csdl
        //kĩ thuật truyền thống
        // kĩ  thuật hiện đại: ORM- chơi với csdl theo style oop, thậm chí không cần viết bất cừ câu sql nào
        // 2 nhánh con: code first vs database first
        //thi PE la code first, tư code ra table
        //-> tự động insert data
        //kĩ thuật hiện đại: JDBC là nền
        // ta cn thm: JPA, Hibernate -> 1 đống dependency


        // KĨ THUẬT TRUYỀN THÔNG: TỰ LÀM MỌI THỨ VỚI SQL
        // XAÀI JDBC CỦA MICROSOFT LÀ ĐỦ

        Connection conn = null;


        //Dù hiện đại hay truyền thống đều phải chỉ ra CSDL nằm ở đâu, cái thông tin này gọi là Connection String, viết theo 1 cú pháp quy ước trước
        String dbConn= "jdbc:sqlserver://localhost:1433;databaseName=??;encrypt:true;trustServerCertificate=true;";
        String user = "sa";
        String password = "12345";

        // luôn có nguy ngơ bị Exception
        try {
            conn = DriverManager.getConnection(dbConn, user, password);
            String sql = "select * from student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int yob = rs.getInt("yob");
                double gpa = rs.getDouble("gpa");
                System.out.println("id: " + id + " name: " + name + " yob: " + yob + " gpa: " + gpa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}