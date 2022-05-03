package dao;

import entities.KhoSach;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KhoSachDAO extends AbstractDAO {

    private static final String SELECT = "Select * from dbo.KhoSach ";
    private static final String INSERT = "INSERT into dbo.KhoSach "
            + "(SachID,TenSach,nhaxb,TacGia,Hinh,SoLuong,DonGia,"
            + "ngayNhap,KeSo,LoaiID) values (?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE dbo.KhoSach set "
            + "TenSach=?,nhaxb=?,TacGia=?,Hinh=?,SoLuong=?,DonGia=?,"
            + "ngayNhap=?,KeSo=?,LoaiID=? where SachID = ?";
    private static final String DELETE = "DELETE FROM dbo.KhoSach "
            + "where SachID = ?";
    private static final String SELECT_BY_ID = SELECT + "where SachID = ?";
    // Câu truy vấn thêm
    private static final String[] CUSTOM = {
        SELECT + " where LoaiID = ?" // Lấy dữ liệu theo loại
    };

    public KhoSachDAO() {
        super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID, CUSTOM);
    }

    // ____________________________________________________________ĐỌC DỮ LIỆU_
    // Select by sql
    @Override
    public List<Object[]> SelectBySql(String sql, Object... colsSet) {
        return super.SelectBySql(sql, colsSet);
    }

    public List<KhoSach> SelectBySqlElement(String sql, Object... colsSet) {
        List<KhoSach> list = new LinkedList<>();
        super.SelectBySql(sql, colsSet).forEach((x)
                -> list.add(KhoSach.parseKhoSach(x))
        );
        return list;
    }

    public Map<String, KhoSach> SelectBySqlMap(String sql, Object... colsSet) {
        Map<String, KhoSach> map = new HashMap<>();
        super.SelectBySql(sql, colsSet).forEach((x) -> {
            KhoSach data = KhoSach.parseKhoSach(x);
            map.put(data.getSachID(), data);
        });
        return map;
    }

    // Select all
    @Override
    public List<Object[]> SelectAll() {
        return super.SelectAll();
    }

    public List<KhoSach> SelectAllElement() {
        List<KhoSach> list = new LinkedList<>();
        super.SelectAll().forEach((x) -> {
            list.add(KhoSach.parseKhoSach(x));
        });
        return list;
    }

    public Map<String, KhoSach> SelectAllMap() {
        Map<String, KhoSach> list = new HashMap<>();
        super.SelectAll().forEach((x) -> {
            KhoSach data = KhoSach.parseKhoSach(x);
            list.put(data.getSachID(), data);
        });
        return list;
    }

    // Select by ID
    @Override
    public Object[] SelectByID(Object keyID) {
        return super.SelectByID(keyID);
    }

    public KhoSach SelectByIDNV(Object keyID) {
        return KhoSach.parseKhoSach(super.SelectByID(keyID));
    }

    // ___________________________________________________________THÊM DỮ LIỆU_
    @Override
    public boolean insert(Object[] data) {
        return super.insert(data);
    }

    public boolean insert(KhoSach data) {
        return super.insert(data.toArray());
    }

    // ____________________________________________________________SỬA DỮ LIỆU_
    @Override
    public boolean update(Object[] data) {
        return super.update(data);
    }

    public boolean update(KhoSach data) {
        return super.update(data.toArray());
    }

    // ____________________________________________________________XÓA DỮ LIỆU_
    @Override
    public boolean delete(Object keyID) {
        return super.delete(keyID);
    }
}
