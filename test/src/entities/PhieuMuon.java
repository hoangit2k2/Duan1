/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.lang.reflect.Field;
import java.sql.Date;

public class PhieuMuon {

    private int PhieuID;
    private String DgID;
    private String NvID;
    private Date NgayMuon;
    private Date NgayTra;
    private String GhiChu;

    public PhieuMuon() {
    }

    public int getPhieuID() {
        return PhieuID;
    }

    public void setPhieuID(int PhieuID) {
        this.PhieuID = PhieuID;
    }

    public String getDgID() {
        return DgID;
    }

    public void setDgID(String DgID) {
        this.DgID = DgID;
    }

    public String getNvID() {
        return NvID;
    }

    public void setNvID(String NvID) {
        this.NvID = NvID;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return "PhieuMuon{" + "PhieuID=" + PhieuID + ", NgayMuon=" + NgayMuon + '}';
    }

    public Object[] toArray() {
        Object[] arr = {
            PhieuID, DgID, NvID, NgayMuon, NgayTra, GhiChu
        };
        return arr;
    }

    public static PhieuMuon parsePhieuMuon(Object... data) {
        if(data == null) return null;
        PhieuMuon nv = new PhieuMuon();
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
