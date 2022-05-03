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
public class DAOLoaiSanPham {
    //1. Hàm lấy tất cả

    public static ResultSet GetAll() {
        String cauTruyVan = "Select * from LoaiSanPham order by TenLoai";
        return DBConnection.GetData(cauTruyVan);
    }
}
