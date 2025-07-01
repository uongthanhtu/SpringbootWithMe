package com.tusry.superapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ta dung jdbc , tu viet SQL -> mo hinh ket noi CSDL truyen thong
        // choi csdl thi phai them 1 depedency JDBC
        // luu y vao phong thi PE: bat buoc yeu cau giam thi cho vao WIFI de tai dependency
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HSF302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "12345";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");

            //Gui cau SQL xuong DB qua connection object "conn" - dang duy tri noi toi sqlserver

            String query = "select * from Subject";
            PreparedStatement ps = conn.prepareStatement(query);
            //gui cau query cho thang ps - object quan li cau query
            ResultSet rs = ps.executeQuery();
            //rs chua 1 loat cac dong dc select tu table Subject
            //ta dung vong while de duyet qua lay tung dong, tung codt cua tung dong
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int credits = rs.getInt("Credits");
                int studyHours=rs.getInt("StudyHours");
                System.out.printf("%10s | %-40s | %2d | %4d \n", code, name, credits, studyHours);
                //System.out.println(code + "|" + name + "|" + description + "|" + credits + "|" + studyHours);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String dbURL = "jdbc:sqlserver://TUSRY-UONG\\PIEDTEAM2;databaseName=BookStore;encrypt=true;trustServerCertificate=true";
    }
}