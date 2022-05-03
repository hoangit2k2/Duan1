/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.lang.reflect.Field;
import java.sql.Date;

/**
 *
 * @author abc
 */
public class KhoSach {

    private String SachID;
    private String TenSach;
    private String nhaxb;
    private String TacGia;
    private String Hinh;
    private int SoLuong;
    private double DonGia;
    private Date ngayNhap;
    private int KeSo;
    private String LoaiID;

    public KhoSach() {
    }

    public String getSachID() {
        return SachID;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getNhaxb() {
        return nhaxb;
    }

    public String getTacGia() {
        return TacGia;
    }

    public String getHinh() {
        return Hinh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public int getKeSo() {
        return KeSo;
    }

    public String getLoaiID() {
        return LoaiID;
    }

    public void setSachID(String SachID) {
        this.SachID = SachID;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setNhaxb(String nhaxb) {
        this.nhaxb = nhaxb;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setKeSo(int KeSo) {
        this.KeSo = KeSo;
    }

    public void setLoaiID(String LoaiSach) {
        this.LoaiID = LoaiSach;
    }

    @Override
    public String toString() {
        return "KhoSach{" + "SachID=" + SachID + ", TenSach=" + TenSach + '}';
    }

    public Object[] toArray() {
        Object[] arr = {
            SachID, TenSach, nhaxb, TacGia, Hinh,
            SoLuong, DonGia, ngayNhap, KeSo, LoaiID
        };
        return arr;
    }

    public static KhoSach parseKhoSach(Object... data) {
        if (data == null) {
            return null;
        }
        KhoSach nv = new KhoSach();
        Field[] fields = nv.getClass().getDeclaredFields();
        for (int i = 0; i < data.length; i++) {
            try {
                fields[i].set(nv, data[i]);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return nv;
    }
}
