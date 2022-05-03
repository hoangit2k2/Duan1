package model;

import dao.NhanVienDAO;
import entities.NhanVien;
import javax.swing.ImageIcon;

public class Cache_NV {
    
    private static NhanVien nv = new NhanVien();

    // Đăng nhập
    public static boolean Login(String NvID, String pass) {
        nv = NhanVien.parseNhanVien(new NhanVienDAO().SelectByID(NvID));
        if (nv != null) {
            if (nv.getMatKhau().equals(pass)) {
                return true;
            }
        }
        nv = null;
        return false;
    }

    public static NhanVien getNv() {
        return nv;
    }

    public static void setNv(NhanVien nv) {
        Cache_NV.nv = nv;
    }
    
    // Đăng xuất
    public static void Logout() {
        Cache_NV.nv = null;
    }

    // Đã đăng nhập
    public static boolean isLogin() {
        return Cache_NV.nv != null;
    }

    // Là quản lý
    protected static boolean isManager() {
        return Cache_NV.nv.getChucVu() == 1;
    }

    // Là nhân viên <&& isManager()> khác
    protected static boolean isStaff() {
        return Cache_NV.nv.getChucVu() == 0;
    }

    // Lấy mã nhân viên
    public static String getNvID() {
        return nv.getNvID();
    }

    // Lấy tên nhân viên
    public static String getName() {
        return nv.getHoTen();
    }

    // Lấy hình ảnh nhân viên
    public static ImageIcon getImg() {
        System.out.println(nv.getHinhAnh());
        if (nv != null) {
            ImageIcon images = nv.getHinhAnh() != null
                    ? Util.Image.getIcon("images/NhanVien/" + nv.getHinhAnh())
                    : Util.Image.getIcon("src/icons/none.png");
            return images;
        }
        return Util.Image.getIcon("src/icons/none.png");
    }
}
