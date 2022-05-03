/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.controller;
import com.hicode.service.ConnectSQL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HieuHoang
 */
public class count {
    private Connection conn;

    public count() {
        conn = ConnectSQL.getConnectSQL();
    }
    public int countsachMuon(){
        
        if (conn!=null){
            String sql = "  select COUNT(PhieuID) \n" +
"  from PhieuMuon";
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
     public int countDocGia(){
        
        if (conn!=null){
            String sql = "  select count(DgID) as \"SL\"\n" +
"  from DocGia";
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
    
      public int countkhachhang(){
        
        if (conn!=null){
            String sql = "  select COUNT(HdID)\n" +
"  from HoaDon";
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
