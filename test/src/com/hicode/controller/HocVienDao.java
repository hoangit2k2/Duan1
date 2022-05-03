/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.controller;

import com.hicode.model.HocVien;
import com.hicode.service.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HieuHoang
 */
public class HocVienDao {

    private Connection conn;

    private ArrayList<HocVien> list;

    public HocVienDao() {
        conn = ConnectSQL.getConnectSQL();
        list = new ArrayList<>();
        loadDataHocVien();
    }

    public int countKhoaHoc() {

        if (conn != null) {
            String sql = "select count(*) from HocVien";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return -1;

    }

    private void loadDataHocVien() {
        if (conn != null) {
            list.clear();
            String sql = "select * from HocVien";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    HocVien hv = new HocVien(rs.getString(1), rs.getString(2),
                            rs.getDate(3), (rs.getInt(4) == 1 ? true : false), rs.getString(5), rs.getString(6), (rs.getInt(7) == 1 ? true : false), rs.getString(8));
                    list.add(hv);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<HocVien> getList() {
        return list;
    }

    public void setList(ArrayList<HocVien> list) {
        this.list = list;
    }

    public boolean xoaHocVien(String ma) {
        if (conn != null) {
            String sql = "delete from HocVien where MaHV = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ma);
                int x = ps.executeUpdate();
                if (x > 0) {
                    loadDataHocVien();
                    return true;

                }
            } catch (SQLException ex) {
                return false;
            }
        }

        return false;

    }
    public HocVien timHocVien(String ma){
        for (HocVien hocVien : list) {
            if (hocVien.getMaSV().equalsIgnoreCase(ma)) return hocVien;
        }
        return null;
    }
}
