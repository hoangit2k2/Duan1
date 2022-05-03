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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CuongNP
 */
public class BLLSanPham {
    //Hàm đổ dữ liệu User vào JTable 
    public static void DoDuLieu(JTable tbl, ResultSet rs ){
        //Tạo 1 DefaultTableModel 
        DefaultTableModel tbModel = (DefaultTableModel)tbl.getModel();
        //Xóa các dòng trong table
        tbModel.setRowCount(0);
        //Tạo 1 mảng Object có 5 phần tử
        Object obj[] = new Object[5];
        
        try {
            while(rs.next()){                
                obj[0] = rs.getString("MaSP");
                obj[1] = rs.getString("TenSp");
                obj[2] = rs.getString("GiaBan");                
                obj[3] = rs.getString("SoLuong"); 
                obj[4] = rs.getInt("IDSanPham"); 
                //Thêm obj vào table
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBao.ThongBao("Lỗi lấy dữ liệu Sản phẩm", "Thông báo");
        }
    }
    
   
}
