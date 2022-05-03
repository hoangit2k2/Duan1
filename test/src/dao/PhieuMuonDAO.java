package dao;

import entities.ChiTietPM;
import entities.PhieuMuon;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhieuMuonDAO extends AbstractDAO {

    private static final String SELECT = "Select * from dbo.PhieuMuon ";
    private static final String INSERT = "INSERT into dbo.PhieuMuon "
            + "(PhieuID,DgID,NvID,NgayMuon,NgayTra,GhiChu) "
            + "values(?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE dbo.PhieuMuon set "
            + "DgID=?,NvID=?,NgayMuon=?,NgayTra=?,"
            + "GhiChu=? where PhieuID = ?";
    private static final String DELETE = "DELETE FROM dbo.PhieuMuon "
            + "where PhieuID = ?";
    private static final String SELECT_BY_ID = SELECT + "where PhieuID = ?";

    // Câu truy vấn khác
    private static final String[] CUSTOMS = {
        SELECT + "where DgID = ?", // Lấy dữ liệu từ khóa phụ
        "{CALL sp_PhieuMuon(?)}" // Gọi procedure
    };

    public PhieuMuonDAO() {
        super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID, CUSTOMS);
    }

    // ____________________________________________________________ĐỌC DỮ LIỆU_
    // Select by sql
    @Override
    public List<Object[]> SelectBySql(String sql, Object... colsSet) {
        return super.SelectBySql(sql, colsSet);
    }

    public List<PhieuMuon> SelectBySqlElement(String sql, Object... colsSet) {
        List<PhieuMuon> list = new LinkedList<>();
        super.SelectBySql(sql, colsSet).forEach((x) -> list.add(PhieuMuon.parsePhieuMuon(x))
        );
        return list;
    }

    public Map<Integer, PhieuMuon> SelectBySqlMap(String sql, Object... colsSet) {
        Map<Integer, PhieuMuon> map = new HashMap<>();
        super.SelectBySql(sql, colsSet).forEach((x) -> {
            PhieuMuon data = PhieuMuon.parsePhieuMuon(x);
            map.put(data.getPhieuID(), data);
        });
        return map;
    }

    // Select all
    @Override
    public List<Object[]> SelectAll() {
        return super.SelectAll();
    }

    public List<PhieuMuon> SelectAllElement() {
        List<PhieuMuon> list = new LinkedList<>();
        super.SelectAll().forEach((x) -> list.add(PhieuMuon.parsePhieuMuon(x)));
        return list;
    }

    public Map<Integer, PhieuMuon> SelectAllMap() {
        Map<Integer, PhieuMuon> list = new HashMap<>();
        super.SelectAll().forEach((x) -> {
            PhieuMuon data = PhieuMuon.parsePhieuMuon(x);
            list.put(data.getPhieuID(), data);
        });
        return list;
    }

    // Select by ID
    @Override
    public Object[] SelectByID(Object keyID) {
        return super.SelectByID(keyID);
    }

    public PhieuMuon SelectByIDNV(Object keyID) {
        return PhieuMuon.parsePhieuMuon(super.SelectByID(keyID));
    }

    // ___________________________________________________________THÊM DỮ LIỆU_
    @Override
    public boolean insert(Object[] data) {
        return super.insert(data);
    }

    public boolean insert(PhieuMuon data) {
        return super.insert(data.toArray());
    }

    // ____________________________________________________________SỬA DỮ LIỆU_
    @Override
    public boolean update(Object[] data) {
        return super.update(data);
    }

    public boolean update(PhieuMuon data) {
        return super.update(data.toArray());
    }

    // ____________________________________________________________XÓA DỮ LIỆU_
    @Override
    public boolean delete(Object keyID) {
        return super.delete(keyID);
    }

    // THÔNG TIN CHI TIẾT HÓA ĐƠN
    public static class ChiTietPMDAO extends AbstractDAO {

        private static final String SELECT = "Select * from dbo.ChiTietPM ";
        private static final String INSERT = "Select into dbo.ChiTietPM "
                + "(PhieuID,SachID,SoLuong)"
                + "values PhieuID=?,SachID=?,SoLuong=?";
        private static final String UPDATE = null;
        private static final String DELETE = null;
        private static final String SELECT_BY_ID = SELECT + "where HdID = ? "
                + "and SachID = ? and SoLuong = ? and GiaCu = ?";

        public ChiTietPMDAO() {
            super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID);
        }

        // ____________________________________________________________ĐỌC DỮ LIỆU_
        // Select by sql
        @Override
        public List<Object[]> SelectBySql(String sql, Object... colsSet) {
            return super.SelectBySql(sql, colsSet);
        }

        public List<ChiTietPM> SelectBySqlNV(String sql, Object... colsSet) {
            List<ChiTietPM> list = new LinkedList<>();
            super.SelectBySql(sql, colsSet).forEach((x)
                    -> list.add(ChiTietPM.parseChiTietPM(x))
            );
            return list;
        }

        // Select all
        @Override
        public List<Object[]> SelectAll() {
            return super.SelectAll();
        }

        public List<ChiTietPM> SelectAllNV() {
            List<ChiTietPM> list = new LinkedList<>();
            super.SelectAll().forEach((x) -> list.add(ChiTietPM.parseChiTietPM(x)));
            return list;
        }

        // Select by ID
        @Override
        public Object[] SelectByID(Object keyID) {
            return super.SelectByID(keyID);
        }

        public ChiTietPM SelectByIDNV(Object keyID) {
            return ChiTietPM.parseChiTietPM(super.SelectByID(keyID));
        }

        // ___________________________________________________________THÊM DỮ LIỆU_
        @Override
        public boolean insert(Object[] data) {
            return super.insert(data);
        }

        public boolean insert(ChiTietPM data) {
            return super.insert(data.toArray());
        }

        // ____________________________________________________________SỬA DỮ LIỆU_
        @Override
        public boolean update(Object[] data) {
            return super.update(data);
        }

        public boolean update(ChiTietPM data) {
            return super.update(data.toArray());
        }

        // ____________________________________________________________XÓA DỮ LIỆU_
        @Override
        public boolean delete(Object keyID) {
            return super.delete(keyID);
        }
    }
}
