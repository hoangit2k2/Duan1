/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;


import dto.KhachHang;
import dto.MyCombobox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author CuongNP
 */
public class BLLKhachHang {
     //3. Hàm đổ dữ liệu vào Combobox Loại sản phẩm
    public static void DoDuLieuVaoCBBKhachHang(JComboBox cbb, String keyword){
        cbb.removeAllItems();
        try {
            ResultSet rs = dao.DAOKhachHang.GetByKeyword(keyword);
            
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel)cbb.getModel();
           
            while(rs.next()){
                MyCombobox mb = new MyCombobox(rs.getString("TenKhachHang"), 
                                            rs.getInt("MaKH"));
                cbbModel.addElement(mb);                
            }
        } catch (SQLException ex) {
            ThongBao.ThongBao("Thông báo", "Lỗi truy vấn dữ liệu.");
        }
    }
    
    
    
    
    public static KhachHang GetKHByMaKH(String MaKH){
        ResultSet rs = dao.DAOKhachHang.GetByMaKH(MaKH);
        
        try {
            if(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setGhiGhu(rs.getString("GhiChu"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setLoaiKhachHang(rs.getString("LoaiKhachHang"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                
                return kh;
            }
        } catch (SQLException ex) {
            ThongBao.ThongBao("Lỗi lấy khách hàng theo mã", "Thông báo");
           
        }
        return null;
    }
}
