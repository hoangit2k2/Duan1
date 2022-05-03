/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.service;
import java.sql.*;
/**
 *
 * @author HieuHoang
 */
public class ConnectSQL {
    public static Connection getConnectSQL(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;database=PRO1041";
            return DriverManager.getConnection(url, "sa", "songlong");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
