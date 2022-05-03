/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.MyCombobox;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author CuongNP
 */
public class BLLLoaiSanPham {
     //3. Hàm đổ dữ liệu vào Combobox Loại sản phẩm
    public static void DoDuLieuVaoCBBLoaiSanPham(JComboBox cbb){
        try {
            ResultSet rs = dao.DAOLoaiSanPham.GetAll();
            
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel)cbb.getModel();
            MyCombobox cbb0 = new MyCombobox("Tất cả", 0);
            cbbModel.addElement(cbb0);
            while(rs.next()){
                MyCombobox mb = new MyCombobox(rs.getString("TenLoai"), 
                                            rs.getInt("MaLoaiSP"));
                cbbModel.addElement(mb);                
            }
        } catch (SQLException ex) {
            ThongBao.ThongBao("Thông báo", "Lỗi truy vấn dữ liệu.");
        }
    }
}
