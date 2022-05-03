/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ChiTietHoaDon;

/**
 *
 * @author CuongNP
 */
public class DAOChiTietHoaDon {
    public static int Them(ChiTietHoaDon cthd){
        String cauTruyVan = "INSERT INTO [dbo].[ChiTietHoaDon]  " +
"           ([MaHD]  " +
"           ,[IDSanPham]  " +
"           ,[SoLuong]  " +
"           ,[ThanhTien]  " +
"           ,[GhiChu])  " +
"     VALUES  " +
"           (" + cthd.getMaHD() + 
"           ," + cthd.getIDSanPham()+ 
"           ," + cthd.getSoLuong() + 
"           ," + cthd.getThanhTien() + 
"           ,N'" + cthd.getGhiChu()+ "')";
        
        System.out.println(cauTruyVan);
        return DBConnection.ExecuteTruyVan(cauTruyVan);
    }
}
