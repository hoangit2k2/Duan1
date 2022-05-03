/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.lang.reflect.Field;

public class LoaiSach {

    private String LoaiID;
    private String TenLoai;
    private int TuSo;

    public LoaiSach() {
    }

    public String getLoaiID() {
        return LoaiID;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public int getTuSo() {
        return TuSo;
    }

    public void setLoaiID(String LoaiID) {
        this.LoaiID = LoaiID;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public void setTuSo(int TuSo) {
        this.TuSo = TuSo;
    }

    @Override
    public String toString() {
        return "LoaiID: " + LoaiID + ", TenLoai: " + TenLoai;
    }

    public Object[] toArray() {
        Object[] arr = {
            LoaiID, TenLoai, TuSo
        };
        return arr;
    }

    public static LoaiSach parseLoaiSach(Object... data) {
        if (data == null) {
            return null;
        }
        LoaiSach nv = new LoaiSach();
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
