
package com.QLTV.DAO;

import com.QLTV.entities.TKluotMua;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThongKeLuotMuaDAO {
      protected List<TKluotMua> selectBySql(String sql, Object... args) {

        List<TKluotMua> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    TKluotMua enity = new TKluotMua();
                    enity.setLuot(rs.getInt("luotMua"));
                    enity.setThang(rs.getInt("Thang"));
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
       public List<TKluotMua> selectAll() {
        String sql =" select count(HdID) AS \"LuotMua\",month(ngaymua) AS \"Thang\"\n" +
" from HoaDon\n" +
" group by month(NgayMua)";
        return this.selectBySql(sql);
    }
}
