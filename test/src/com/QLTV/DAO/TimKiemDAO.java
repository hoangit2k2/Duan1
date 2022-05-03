package com.QLTV.DAO;

import com.QLTV.entities.DocGia;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TimKiemDAO {
          protected List<DocGia> selectBySql(String sql, Object... args) {
        List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    DocGia enity = new DocGia();
                    enity.setDgID(rs.getString("DgID"));
                    enity.setHoTen(rs.getString("HoTen"));
                    enity.setEmail(rs.getString("Email"));
                    enity.setSoDT(rs.getString("SoDT"));
                    enity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    enity.setHinh(rs.getString("Hinh"));
                    enity.setNvID(rs.getString("NvID"));
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

}
