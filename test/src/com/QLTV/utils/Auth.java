package com.QLTV.utils;

import com.QLTV.entities.NhanVien;
import com.QLTV.DAO.NhanVienDAO;

public class Auth {
    public static NhanVien user = null; //thông tin của người dùng khi đăng nhập
    public Auth(String maCode){
     user = new NhanVienDAO().selectById(maCode);
    }    
    public static void setUser(NhanVien user){
        Auth.user = user;
    }
    public static NhanVien getUser(){
        return user;
    }
   public static void clear() {
       Auth.user = null; //Xóa thông tin người dùng khi có yêu cầu đăng xuất
    }

    public static boolean isLogin() {
        return Auth.user != null; // Kiểm tra đã đăng nhập hay chưa. Trả về kết quả đã đăng nhập hay chưa.
    }

    public static boolean isManager() {
        return Auth.isLogin() && user.isChucVu(); // Có sử dụng vai trò trưởng phòng hay không? Or nhân viên?
    }
}
