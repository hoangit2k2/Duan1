package com.QLTV.DAO;

import com.QLTV.entities.NhanVien;
import java.util.List;
import com.QLTV.entities.PhieuMuon;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieuMuonDAO extends QLTVDAO<PhieuMuon, String> {

    final String select = "Select * from dbo.PhieuMuon ";
    final String insert = "INSERT into dbo.PhieuMuon "
            + "(DgID,NvID,NgayMuon,NgayTra,GhiChu) "
            + "values(?,?,?,?,?);";
    final String update = "UPDATE dbo.PhieuMuon set "
            + "DgID=?,NvID=?,NgayMuon=?,NgayTra=?,"
            + "GhiChu=? where PhieuID = ?";
    final String delete = "DELETE FROM dbo.PhieuMuon "
            + "where PhieuID = ?";
    final String selectByID = select + "where PhieuID = ?";
    final String SelectSL = "select count(*) as 'COUNT' from PhieuMuon where DgID = ?";

    @Override
    public void insert(PhieuMuon entity) {
//           final String insert = "INSERT into dbo.PhieuMuon "
        //              + "(PhieuID,DgID,NvID,NgayMuon,NgayTra,GhiChu) "
        //            + "values(?,?,?,?,?,?);";
        XJdbc.update(insert,
                entity.getDgID(),
                entity.getNvID(),
                entity.getNgayMuon(),
                entity.getGhiChu());
    }

    public int demsoluong(String madg) throws SQLException {
        int dem = 0;
        // String sql = "SELECT COUNT(*) AS 'COUNT' FROM HoaDon";
        ResultSet rs = XJdbc.query(SelectSL, madg);
        while (rs.next()) {
            dem = rs.getInt("COUNT");
        }
        return dem;
    }

    public int ThongKe(String a, String b, String c, String d, String e, String g, String h, String i) throws SQLException {
        int dem = 0;
        // String sql = "SELECT COUNT(*) AS 'COUNT' FROM HoaDon";
        String sql = "SELECT SUM(soluong) AS FROM KhoSach WHERE  LoaiID = ?;";
        ResultSet rs = XJdbc.query(SelectSL, a, b, c, d, e, g, h, i);
        while (rs.next()) {
            dem = rs.getInt("COUNT");
        }
        return dem;
    }

    @Override
    public void update(PhieuMuon entity) {
        XJdbc.update(update,
                entity.getDgID(),
                entity.getNvID(),
                entity.getNgayMuon(),
                entity.getNgayTra(),
                entity.getGhiChu(),
                entity.getPhieuID());
//         final String update = "UPDATE dbo.PhieuMuon set "
//                + "DgID=?,NvID=?,NgayMuon=?,NgayTra=?,"
//                + "GhiChu=? where PhieuID = ?";
    }

    @Override
    public void delete(String Manv) {
        XJdbc.update(delete, Manv);
    }

    @Override
    public PhieuMuon selectById(String manv) {
        List<PhieuMuon> list = this.selectBySql(selectByID, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<PhieuMuon> selectAll() {
        return this.selectBySql(select);
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {

        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    PhieuMuon enity = new PhieuMuon();
                    enity.setPhieuID(rs.getInt("phieuID"));
                    enity.setDgID(rs.getString("NVID"));
                    enity.setNvID(rs.getString("NVID"));
                    enity.setNgayMuon(rs.getDate("NgayMuon"));
                    enity.setNgayTra(rs.getDate("ngaytra"));
                    enity.setGhiChu(rs.getString("Ghichu"));
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
