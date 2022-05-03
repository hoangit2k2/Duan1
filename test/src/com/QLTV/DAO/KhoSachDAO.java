package com.QLTV.DAO;

import com.QLTV.entities.KhoSach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.QLTV.utils.XJdbc;
import java.sql.SQLException;
import com.QLTV.utils.XJdbc;

public class KhoSachDAO extends QLTVDAO<KhoSach, String> {

    final String select = "Select * from dbo.KhoSach ";
    final String insert = "INSERT into dbo.KhoSach "
            + "(SachID,TenSach,nhaxb,TacGia,Hinh,SoLuong,DonGia,"
            + "ngayNhap,KeSo,LoaiID) values (?,?,?,?,?,?,?,?,?,?);";
    final String update = "UPDATE dbo.KhoSach set "
            + "TenSach=?,nhaxb=?,TacGia=?,Hinh=?,SoLuong=?,DonGia=?,"
            + "ngayNhap=?,KeSo=?,LoaiID=? where SachID = ?";
    final String delete = "DELETE FROM dbo.KhoSach "
            + "where SachID = ?";
    final String selectByID = select + "where SachID = ?";
    // Câu truy vấn thêm
    final String custom1 = select + " where LoaiID = ?";
    // Tạo câu truy vấn dữu liệu

    @Override
    public void insert(KhoSach entity) {
//         final String insert = "INSERT into dbo.KhoSach "
//            + "(SachID,TenSach,nhaxb,TacGia,Hinh,SoLuong,DonGia,"
//            + "ngayNhap,KeSo,LoaiID) values (?,?,?,?,?,?,?,?,?,?);";
        XJdbc.update(insert, 
                entity.getSachID(),
                entity.getTenSach(),
                entity.getNhaxb(),
                entity.getTacGia(),
                entity.getHinh(),
                entity.getSoLuong(),
                entity.getDonGia(),
                entity.getNgayNhap(),
                entity.getKeSo(),
                entity.getLoaiID());
    }

    @Override
    public void update(KhoSach entity) {
        XJdbc.update(update,
                    entity.getTenSach(),
                    entity.getNhaxb(),
                    entity.getTacGia(),
                    entity.getHinh(),
                    entity.getSoLuong(),
                    entity.getDonGia(),
                    entity.getNgayNhap(),
                    entity.getKeSo(),
                    entity.getLoaiID(),
                    entity.getSachID());
    }
    
//    final String update = "UPDATE dbo.KhoSach set "
//            + "TenSach=?,nhaxb=?,TacGia=?,Hinh=?,SoLuong=?,DonGia=?,"
//            + "ngayNhap=?,KeSo=?,LoaiID=? where SachID = ?";
    @Override
    public void delete(String manv) {
        XJdbc.update(manv, delete);
    }

    @Override
    public KhoSach selectById(String manv) {
        List<KhoSach> list = this.selectBySql(selectByID, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<KhoSach> selectAll() {
        return this.selectBySql(select);
    }

    @Override
    protected List<KhoSach> selectBySql(String sql, Object... args) {
        List<KhoSach> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
//                     final String select = "Select * from dbo.KhoSach ";
//        final String insert = "INSERT into dbo.KhoSach "
//                + "(SachID,TenSach,nhaxb,TacGia,Hinh,SoLuong,DonGia,"
//                + "ngayNhap,KeSo,LoaiID) values (?,?,?,?,?,?,?,?,?,?);";
//        final String update = "UPDATE dbo.KhoSach set "
//                + "TenSach=?,nhaxb=?,TacGia=?,Hinh=?,SoLuong=?,DonGia=?,"
//                + "ngayNhap=?,KeSo=?,LoaiID=? where SachID = ?";
//        final String delete = "DELETE FROM dbo.KhoSach "
//                + "where SachID = ?";
//        final String selectByID = select + "where SachID = ?";
//        // Câu truy vấn thêm
//        final String custom1 = select + " where LoaiID = ?";
//        // Tạo câu truy vấn dữu liệu

                    KhoSach enity = new KhoSach();
                    enity.setSachID(rs.getString("SachID"));
                    enity.setTenSach(rs.getString("TenSach"));
                    enity.setNhaxb(rs.getString("nhaXB"));
                    enity.setTacGia(rs.getString("TacGia"));
                    enity.setHinh(rs.getString("Hinh"));
                    enity.setSoLuong(rs.getInt("SoLuong"));
                    enity.setDonGia(rs.getDouble("DonGia"));
                    enity.setNgayNhap(rs.getDate("NgayNhap"));
                    enity.setKeSo(rs.getInt("KeSo"));
                    enity.setLoaiID("LoaiID");
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
