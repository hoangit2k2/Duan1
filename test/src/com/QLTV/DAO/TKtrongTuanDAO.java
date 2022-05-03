
package com.QLTV.DAO;

import com.QLTV.entities.tktrongtuan;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TKtrongTuanDAO {
     protected List<tktrongtuan> selectBySql(String sql, Object... args) {

        List<tktrongtuan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    tktrongtuan enity = new tktrongtuan();
                    enity.setNgay(rs.getDate("NgayMua"));
                    enity.setDT(rs.getInt("doanhthu"));
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
       public List<tktrongtuan> selectAll() {
        String sql ="select HoaDon.NgayMua,(ChiTietHD.SoLuong * KhoSach.DonGia) as \"doanhthu\"\n" +
"  from ChiTietHD inner join KhoSach \n" +
" on ChiTietHD.SachID = KhoSach.SachID\n" +
" inner join HoaDon\n" +
" on HoaDon.HdID = ChiTietHD.HdID\n" +
" where  HoaDon.NgayMua between '2021-12-01' and '2021-12-08'";
        return this.selectBySql(sql);
    }
}
