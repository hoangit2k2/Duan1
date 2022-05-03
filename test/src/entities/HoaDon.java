/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.lang.reflect.Field;
import java.sql.Date;

public class HoaDon {

    private int HdID;
    private String NvID;
    private String DgID;
    private Date NgayMua;
    private String GhiChu;

    public HoaDon() {
    }

    public int getHdID() {
        return HdID;
    }

    public void setHdID(int HdID) {
        this.HdID = HdID;
    }

    public String getNvID() {
        return NvID;
    }

    public void setNvID(String NvID) {
        this.NvID = NvID;
    }

    public String getDgID() {
        return DgID;
    }

    public void setDgID(String DgID) {
        this.DgID = DgID;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "HdID=" + HdID + ", NgayMua=" + NgayMua + '}';
    }

    public Object[] toArray() {
        Object[] arr = {
            HdID, NvID, DgID, NgayMua, GhiChu
        };
        return arr;
    }

    public static HoaDon parseHoaDon(Object... data) {
        if(data == null) return null;
        HoaDon nv = new HoaDon();
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
