package com.QLTV.DAO;

import com.QLTV.entities.DocGia;
import com.QLTV.entities.NhanVien;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocGiaDAO extends QLTVDAO<DocGia, String> {

    final String select = "Select * from dbo.DocGia ";
    final String insert = "INSERT into dbo.DocGia "
            + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
            + "values (?,?,?,?,?,?,?);";
    final String update = "UPDATE dbo.DocGia set "
            + "HoTen=?,Email=?,SoDT=?,GioiTinh=?,"
            + "Hinh=?,NvID=? where DgID= ?";
    final String delete = "DELETE FROM dbo.DocGia where DgID = ?";
    final String selectByID = select + " where DgID = ?";
    final String keywork = select + "Where Hoten Like ?";

    @Override
    public void insert(DocGia entity) {

        XJdbc.update(insert, entity.getDgID(),
                entity.getHoTen(),
                entity.getEmail(),
                entity.getSoDT(),
                entity.isGioiTinh(),
                entity.getHinh(),
                entity.getNvID());
    }

    @Override
    public void update(DocGia entity) {
//         final String update = "UPDATE dbo.DocGia set "
//            + "HoTen=?,Email=?,SoDT=?,GioiTinh=?,"
//            + "Hinh=?,NvID=? where DgID= ?";
        XJdbc.update(select, entity.getHoTen(),
                entity.getEmail(),
                entity.getSoDT(),
                entity.isGioiTinh(),
                entity.getHinh(),
                entity.getNvID(),
                entity.getDgID());
    }

    @Override
    public void delete(String MaNV) {
                XJdbc.update(delete, MaNV);

    }

    @Override
    public DocGia selectById(String manv) {
          List<DocGia> list = this.selectBySql(selectByID, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DocGia> selectAll() {
    return this.selectBySql(select);
    }

    @Override
    protected List<DocGia> selectBySql(String sql, Object... args) {
        List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                //         final String insert = "INSERT into dbo.DocGia "
//            + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
//            + "values (?,?,?,?,?,?,?);";
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

    public List<DocGia>KeyWork(String keyWork){
        return this.selectBySql(keywork, "%"+keyWork+"%");
    }
   
}
