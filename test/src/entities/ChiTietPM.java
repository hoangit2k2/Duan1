/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.lang.reflect.Field;

public class ChiTietPM {

    private String SachID;
    private int SoLuong;

    public String getSachID() {
        return SachID;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSachID(String SachID) {
        this.SachID = SachID;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return "ChiTietPM{" + "SachID=" + SachID + ", SoLuong=" + SoLuong + '}';
    }

    public Object[] toArray() {
        Object[] arr = {
            SachID, SoLuong
        };
        return arr;
    }
    
    public static ChiTietPM parseChiTietPM(Object... data) {
        if(data == null) return null;
        ChiTietPM nv = new ChiTietPM();
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
