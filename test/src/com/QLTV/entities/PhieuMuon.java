/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLTV.entities;
import java.sql.Date;
import java.util.List;

public class PhieuMuon {

    private int PhieuID;
    private String DgID;
    private String NvID;
    private Date NgayMuon;
    private Date NgayTra;
    private String GhiChu;
    private List<ChiTietPM> listSachMuon;

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

    public List<ChiTietPM> getListSachMuon() {
        return listSachMuon;
    }

    public void setListSachMuon(List<ChiTietPM> listSachMuon) {
        this.listSachMuon = listSachMuon;
    }

    public static class ChiTietPM {

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
    }
}
