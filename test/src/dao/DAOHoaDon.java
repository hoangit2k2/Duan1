/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bll.ChuyenDoi;
import dto.HoaDon;
import java.sql.ResultSet;

/**
 *
 * @author CuongNP
 */
public class DAOHoaDon {
    public static ResultSet CountSoHoaDon(String SoHoaDon) {
        String cauTruyVan = "select Count(*) from hoadon where SoHoaDon like N'%" + SoHoaDon + "%'";
        return DBConnection.GetData(cauTruyVan);
    }
    
    //7 Hàm lấy theo SoHoaDon
    public static ResultSet GetBySoHoaDon(String SoHoaDon) {
        String cauTruyVan = "select * from hoadon where SoHoaDon = N'" + SoHoaDon + "'";
        return DBConnection.GetData(cauTruyVan);
    }
    
    public static int ThemHoaDon(HoaDon hd){
        String cauTruyVan = "set dateformat dmy INSERT INTO [dbo].[HoaDon]  " +
"           ([SoHoaDon]  " +
"           ,[NgayTaoHD]  " +
"           ,[MaNhanVien]  " +
"           ,[MaKhachHang]  " +
"           ,[TongTien]  " +
"           ,[GhiChu])  " +
"     VALUES  " +
"           ('" +hd.getSoHoaDon()+ "'  " +
"           ,'" + ChuyenDoi.DinhDangNgay(hd.getNgayTao())+ "'  " +
"           ," +hd.getMaNhanVien()+ "  " +
"           ," +hd.getMaKhachHang()+ "  " +
"           ," +hd.getTongTien()+ "  " +
"           ,N'" +hd.getGhiChu()+ "')";
        
        System.out.println(cauTruyVan);
        return DBConnection.ExecuteTruyVan(cauTruyVan);
    }
}
