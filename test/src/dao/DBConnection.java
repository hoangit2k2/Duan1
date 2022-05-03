/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CuongNP
 */
public class DBConnection {
    private static String DB_URL = "jdbc:sqlserver://localhost;"
            + "databaseName=QLSanPham;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "songlong"; 
    public static Connection conn;
    
    public DBConnection(){
        try {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi thiếu thư viện kết nối");
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối CSDL!");
        }
    }
    
    //Hàm thực hiện câu lệnh Select
    public static ResultSet GetData(String cauTruyVan){
        try {
            Statement stm = conn.createStatement();           
            ResultSet rs = stm.executeQuery(cauTruyVan);
            
            return rs;
            
        } catch (SQLException ex) {
            System.out.println("Lỗi lấy dữ liệu");
            return null; 
        }
    }
    //Hàm thực hiện 3 lệnh Insert, Update, Delete
    public static int ExecuteTruyVan(String cauTruyVan){
        try {
            Statement stm = conn.createStatement();
            int kq = stm.executeUpdate(cauTruyVan);
            return kq;
        } catch (SQLException ex) {
            System.out.println("Lỗi thực thi lệnh SQL");
            return -1;
        }        
    }
}
