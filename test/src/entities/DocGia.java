/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.lang.reflect.Field;

public class DocGia {

    private String DgID;
    private String HoTen;
    private String Email;
    private String SoDT;
    private boolean GioiTinh;
    private String Hinh;
    private String NvID;

    public DocGia() {
    }

    public String getDgID() {
        return DgID;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public String getHinh() {
        return Hinh;
    }

    public String getNvID() {
        return NvID;
    }

    public void setDgID(String DgID) {
        this.DgID = DgID;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public void setNvID(String NvID) {
        this.NvID = NvID;
    }

    @Override
    public String toString() {
        StringBuilder x = new StringBuilder("(Mã: ").append(this.NvID);
        x.append(") - Họ và Tên: ").append(this.HoTen);
        return x.toString();
    }

    public Object[] toArray() {
        Object[] arr = {
            DgID, HoTen, Email, SoDT, GioiTinh, Hinh, NvID
        };
        return arr;
    }

    public static DocGia parseDocGia(Object... data) {
        if(data == null) return null;
        DocGia nv = new DocGia();
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
