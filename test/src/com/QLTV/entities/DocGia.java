/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLTV.entities;


public class DocGia {

    private String DgID;
    private String HoTen;
    private String Email;
    private String SoDT;
    private boolean GioiTinh;
    private String Hinh;
    private String NvID;

    public DocGia(String DgID, String HoTen, String Email, String SoDT, boolean GioiTinh, String Hinh, String NvID) {
        this.DgID = DgID;
        this.HoTen = HoTen;
        this.Email = Email;
        this.SoDT = SoDT;
        this.GioiTinh = GioiTinh;
        this.Hinh = Hinh;
        this.NvID = NvID;
    }

    public DocGia() {
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

   
    
}
