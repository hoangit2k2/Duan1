package dao;

import entities.HoaDon;
import entities.ChiTietHD;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HoaDonDAO extends AbstractDAO {

    private static final String SELECT = "Select * from dbo.HoaDon ";
    private static final String INSERT = "INSERT into dbo.HoaDon "
            + "(HdID,NvID,DgID,NgayMua,GhiChu) "
            + "values (?,?,?,?,?);";
    private static final String UPDATE = "UPDATE dbo.HoaDon set "
            + "NvID=?,DgID=?,NgayMua=?,GhiChu=? where HdID = ?";
    private static final String DELETE = "DELETE FROM dbo.HoaDon where HdID = ?";
    private static final String SELECT_BY_ID = SELECT + "where HdID = ?";

    public HoaDonDAO() {
        super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID);
    }

    // ____________________________________________________________ĐỌC DỮ LIỆU_
    // Select by sql
    @Override
    public List<Object[]> SelectBySql(String sql, Object... colsSet) {
        return super.SelectBySql(sql, colsSet);
    }

    public List<HoaDon> SelectBySqlElement(String sql, Object... colsSet) {
        List<HoaDon> list = new LinkedList<>();
        super.SelectBySql(sql, colsSet).forEach((x)
                -> list.add(HoaDon.parseHoaDon(x))
        );
        return list;
    }

    public Map<Integer, HoaDon> SelectBySqlMap(String sql, Object... colsSet) {
        Map<Integer, HoaDon> map = new HashMap<>();
        super.SelectBySql(sql, colsSet).forEach((x) -> {
            HoaDon data = HoaDon.parseHoaDon(x);
            map.put(data.getHdID(), data);
        });
        return map;
    }

    // Select all
    @Override
    public List<Object[]> SelectAll() {
        return super.SelectAll();
    }

    public List<HoaDon> SelectAllElement() {
        List<HoaDon> list = new LinkedList<>();
        super.SelectAll().forEach((x) -> list.add(HoaDon.parseHoaDon(x)));
        return list;
    }

    public Map<Integer, HoaDon> SelectAllMap() {
        Map<Integer, HoaDon> list = new HashMap<>();
        super.SelectAll().forEach((x) -> {
            HoaDon data = HoaDon.parseHoaDon(x);
            list.put(data.getHdID(), data);
        });
        return list;
    }

    // Select by ID
    @Override
    public Object[] SelectByID(Object keyID) {
        return super.SelectByID(keyID);
    }

    public HoaDon SelectByIDNV(Object keyID) {
        return HoaDon.parseHoaDon(super.SelectByID(keyID));
    }

    // ___________________________________________________________THÊM DỮ LIỆU_
    @Override
    public boolean insert(Object[] data) {
        return super.insert(data);
    }

    public boolean insert(HoaDon data) {
        return super.insert(data.toArray());
    }

    // ____________________________________________________________SỬA DỮ LIỆU_
    @Override
    public boolean update(Object[] data) {
        return super.update(data);
    }

    public boolean update(HoaDon data) {
        return super.update(data.toArray());
    }

    // ____________________________________________________________XÓA DỮ LIỆU_
    @Override
    public boolean delete(Object keyID) {
        return super.delete(keyID);
    }

    // THÔNG TIN CHI TIẾT HÓA ĐƠN
    public static class ChiTietHDDAO extends AbstractDAO {

        private static final String SELECT = "Select * from dbo.ChiTietHD ";
        private static final String INSERT = "Select into dbo.ChiTietHD "
                + "(HdID,SachID,SoLuong,GiaCu)"
                + "values HdID=?,SachID=?,SoLuong=?,GiaCu=?";
        private static final String UPDATE = null;
        private static final String DELETE = null;
        private static final String SELECT_BY_ID = SELECT + "where HdID = ? "
                + "and SachID = ? and SoLuong = ? and GiaCu = ?";

        public ChiTietHDDAO() {
            super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID);
        }

        // ____________________________________________________________ĐỌC DỮ LIỆU_
        // Select by sql
        @Override
        public List<Object[]> SelectBySql(String sql, Object... colsSet) {
            return super.SelectBySql(sql, colsSet);
        }

        public List<ChiTietHD> SelectBySqlNV(String sql, Object... colsSet) {
            List<ChiTietHD> list = new LinkedList<>();
            super.SelectBySql(sql, colsSet).forEach((x)
                    -> list.add(ChiTietHD.parseChiTietHD(x))
            );
            return list;
        }

        // Select all
        @Override
        public List<Object[]> SelectAll() {
            return super.SelectAll();
        }

        public List<ChiTietHD> SelectAllNV() {
            List<ChiTietHD> list = new LinkedList<>();
            super.SelectAll().forEach((x) -> list.add(ChiTietHD.parseChiTietHD(x)));
            return list;
        }

        // Select by ID
        @Override
        public Object[] SelectByID(Object keyID) {
            return super.SelectByID(keyID);
        }

        public ChiTietHD SelectByIDNV(Object keyID) {
            return ChiTietHD.parseChiTietHD(super.SelectByID(keyID));
        }

        // ___________________________________________________________THÊM DỮ LIỆU_
        @Override
        public boolean insert(Object[] data) {
            return super.insert(data);
        }

        public boolean insert(ChiTietHD data) {
            return super.insert(data.toArray());
        }

        // ____________________________________________________________SỬA DỮ LIỆU_
        @Override
        public boolean update(Object[] data) {
            return super.update(data);
        }

        public boolean update(ChiTietHD data) {
            return super.update(data.toArray());
        }

        // ____________________________________________________________XÓA DỮ LIỆU_
        @Override
        public boolean delete(Object keyID) {
            return super.delete(keyID);
        }
    }
}
