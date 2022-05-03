package com.QLTV.entities;

import java.sql.Date;

public class NhanVien {

    private String NvID;
    private String MatKhau;
    private String HoTen;
    private Date NgaySinh;
    private String DiaChi;
    private String SoDT;
    private String Email;
    private boolean ChucVu;
    private String HinhAnh;
    private int thoiGian;
    public NhanVien() {
    }

    public NhanVien(String NvID, String HoTen, String SoDT) {
        this.NvID = NvID;
        this.HoTen = HoTen;
        this.SoDT = SoDT;
    }

    

    @Override
    public String toString() {
        return "NhanVien{" + "NvID=" + NvID + ", HoTen=" + HoTen + '}';
    }

    public void setNhanVien(
            String NvID, String MatKhau, String HoTen, Date NgaySinh,
            String DiaChi, String SoDT, String Email, boolean ChucVu) {
        this.NvID = NvID;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
        this.Email = Email;
        this.ChucVu = ChucVu;
    }

    public void setNvID(String NvID) {
        this.NvID = NvID;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setChucVu(boolean ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNvID() {
        return NvID;
    }

    public String getMatKhau() {
        
        return MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public String getEmail() {
        return Email;
    }

    public boolean isChucVu() {
        return ChucVu;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public int getThoiGian() {
        return thoiGian;
    }
    public String getString(){
        String o = "***";
        return o;
    }
  
}
