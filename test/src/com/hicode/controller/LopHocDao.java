/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.controller;

import com.hicode.service.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HieuHoang
 */
public class LopHocDao {
        private Connection conn;

    public LopHocDao() {
        conn = ConnectSQL.getConnectSQL();
    }
    public int countKhoaHoc(){
        
        if (conn!=null){
            String sql = "select count(*) from LopHoc";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {                    
                    return rs.getInt(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return -1;
        
    }
}
