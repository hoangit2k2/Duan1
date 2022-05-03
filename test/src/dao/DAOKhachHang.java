/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;

/**
 *
 * @author CuongNP
 */
public class DAOKhachHang {
    public static ResultSet GetAll() {
        String cauTruyVan = "Select * from KhachHang order by TenKhachHang";
        return DBConnection.GetData(cauTruyVan);
    }
    
    public static  ResultSet GetByMaKH(String MaKH){
        String cauTruyVan = "Select * from KhachHang where MaKH = " + MaKH;
        return DBConnection.GetData(cauTruyVan);
    }
    
    public static  ResultSet GetByKeyword(String keyword){
        String cauTruyVan = "Select * from KhachHang where MaKH like '%" + keyword + "%'  or " 
                + " TenKhachHang like N'%" + keyword + "%'";
        return DBConnection.GetData(cauTruyVan);
    }
}
