/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.SanPham;
import gui.MainFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CuongNP
 */
public class DAOSanPham {
    public static ResultSet GetAll(){
        String sql="SELECT * FROM SanPham";        
        return DBConnection.GetData(sql);
    }
    
    public static ResultSet Search(String MaLoai,String keyword ){
        String sql="SELECT * FROM SanPham where "
                + "(MaSP  like N'%"  + keyword 
                + "%' or TenSP like N'%" + keyword + "%' or '' = '" + keyword 
                + "') and (MaLoaiSP  = " + MaLoai + " or 0 = " + MaLoai + ")";        
        return DBConnection.GetData(sql);
    }
   
}
