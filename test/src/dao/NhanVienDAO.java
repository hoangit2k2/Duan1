package dao;

import entities.NhanVien;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NhanVienDAO extends AbstractDAO {

    private static final String SELECT = "SELECT * FROM dbo.NhanVien ";
    private static final String INSERT = "INSERT into dbo.NhanVien"
            + " (NvID,MatKhau,HoTen,NgaySinh,DiaChi,SoDT,Email,ChucVu,HinhAnh)"
            + " values(?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE dbo.NhanVien set "
            + "MatKhau=?,HoTen=?,NgaySinh=?,DiaChi=?"
            + ",SoDT=?,Email=?,ChucVu=?,HinhAnh=? where NvID = ?";
    private static final String DELETE = "DELETE FROM dbo.NhanVien where NvID = ?";
    private static final String SELECT_BY_ID = SELECT + "where NvID = ?";

    public NhanVienDAO() {
        super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID);
    }

    // ____________________________________________________________ĐỌC DỮ LIỆU_
    // Select by sql
    @Override
    public List<Object[]> SelectBySql(String sql, Object... colsSet) {
        return super.SelectBySql(sql, colsSet);
    }

    public List<NhanVien> SelectBySqlElement(String sql, Object... colsSet) {
        List<NhanVien> list = new LinkedList<>();
        super.SelectBySql(sql, colsSet).forEach((x)
                -> list.add(NhanVien.parseNhanVien(x))
        );
        return list;
    }

    public Map<String, NhanVien> SelectBySqlMap(String sql, Object... colsSet) {
        Map<String, NhanVien> map = new HashMap<>();
        super.SelectBySql(sql, colsSet).forEach((x) -> {
            NhanVien data = NhanVien.parseNhanVien(x);
            map.put(data.getNvID(), data);
        });
        return map;
    }

    // Select all
    @Override
    public List<Object[]> SelectAll() {
        return super.SelectAll();
    }

    public List<NhanVien> SelectAllElement() {
        List<NhanVien> list = new LinkedList<>();
        super.SelectAll().forEach((x) -> list.add(NhanVien.parseNhanVien(x)));
        return list;
    }

    public Map<String, NhanVien> SelectAllMap() {
        Map<String, NhanVien> list = new HashMap<>();
        super.SelectAll().forEach((x) -> {
            NhanVien data = NhanVien.parseNhanVien(x);
            list.put(data.getNvID(), data);
        });
        return list;
    }

    // Select by ID
    @Override
    public Object[] SelectByID(Object keyID) {
        return super.SelectByID(keyID);
    }

    public NhanVien SelectByIDNV(Object keyID) {
        return NhanVien.parseNhanVien(super.SelectByID(keyID));
    }

    // ___________________________________________________________THÊM DỮ LIỆU_
    @Override
    public boolean insert(Object[] data) {
        return super.insert(data);
    }

    public boolean insert(NhanVien data) {
        return super.insert(data.toArray());
    }

    // ____________________________________________________________SỬA DỮ LIỆU_
    @Override
    public boolean update(Object[] data) {
        return super.update(data);
    }

    public boolean update(NhanVien data) {
        return super.update(data.toArray());
    }

    // ____________________________________________________________XÓA DỮ LIỆU_
    @Override
    public boolean delete(Object keyID) {
        return super.delete(keyID);
    }
}
