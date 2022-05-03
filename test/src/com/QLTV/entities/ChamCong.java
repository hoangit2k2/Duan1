package com.QLTV.entities;

public class ChamCong {

    private String maNV;
    private double login;
    private double logout;
    private double tong;

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setLogin(double login) {
        this.login = login;
    }

    public void setLogout(double logout) {
        this.logout = logout;
    }

    public void setTong(double tong) {
        this.tong = tong;
    }

    public String getMaNV() {
        return maNV;
    }

    public double getLogin() {
        return login;
    }

    public double getLogout() {
        return logout;
    }

    public double getTong() {
        return tong;
    }

}
