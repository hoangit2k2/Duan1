/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QLTV.DAO;

import com.QLTV.entities.ThongKe;
import java.util.List;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ThongKeDAO {

    protected List<ThongKe> selectBySql(String sql, Object... args) {

        List<ThongKe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    ThongKe enity = new ThongKe();
                    enity.setSL(rs.getInt("tong"));
                    enity.setTen(rs.getString("tenloai"));
                    list.add(enity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;

    }

    public List<ThongKe> selectAll() {
        String sql ="select sum(KhoSach.SoLuong) as\"tong\", LoaiSach.TenLoai\n" +
"from KhoSach inner join LoaiSach\n" +
"on KhoSach.LoaiID = LoaiSach.LoaiID\n" +
"group by LoaiSach.TenLoai";
        return this.selectBySql(sql);
    }
}
