/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.KhachHang;
import com.QLTV.utils.XJdbc1;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAO {
    String insert="INSERT INTO [dbo].[KhachHang]\n" +
"           ([TenKhachHang]\n" +
"           ,[DiaChi]\n" +
"           ,[GioiTinh]\n" +
"           ,[SoDienThoai]\n" +
"           ,[LoaiKhachHang]\n" +
"           ,[GhiChu])\n" +
"     VALUES(?,?,?,?,?,?)";
  protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                //         final String insert = "INSERT into dbo.DocGia "
//            + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
//            + "values (?,?,?,?,?,?,?);";
                rs = XJdbc1.query(sql, args);
                while (rs.next()) {
                    KhachHang enity = new KhachHang();
                    enity.setTenKhachHang(rs.getString("tenkhachhang"));
                    enity.setDiaChi(rs.getString("Diachi"));
                    enity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    enity.setSoDienThoai(rs.getString("sodienthoai"));
                    enity.setLoaiKhachHang(rs.getString("LoaiKhachHang"));
                    enity.setGhiGhu(rs.getString("Ghichu"));
                   
                    list.add(enity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
    public void insert(KhachHang entity) {

        XJdbc1.update(insert, 
                entity.getTenKhachHang(),
                entity.getDiaChi(),
                entity.getGioiTinh(),
                entity.getSoDienThoai(),
                entity.getLoaiKhachHang(),
                entity.getGhiGhu()
                
                );
    }
}
