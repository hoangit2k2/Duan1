package dao;

import entities.LoaiSach;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LoaiSachDAO extends AbstractDAO {

    private static final String SELECT = "Select * from dbo.LoaiSach ";
    private static final String INSERT = "INSERT into dbo.LoaiSach "
            + "(LoaiID,TenLoai,TuSo) values (?,?,?);";
    private static final String UPDATE = "UPDATE dbo.LoaiSach set "
            + "TenLoai=?,TuSo=? where LoaiID = ?";
    private static final String DELETE = "DELETE FROM dbo.LoaiSach "
            + "where LoaiID = ?";
    private static final String SELECT_BY_ID = SELECT + "where LoaiID = ?";

    public LoaiSachDAO() {
        super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID);
    }

    // ____________________________________________________________ĐỌC DỮ LIỆU_
    // Select by sql
    @Override
    public List<Object[]> SelectBySql(String sql, Object... colsSet) {
        return super.SelectBySql(sql, colsSet);
    }

    public List<LoaiSach> SelectBySqlElement(String sql, Object... colsSet) {
        List<LoaiSach> list = new LinkedList<>();
        super.SelectBySql(sql, colsSet).forEach((x)
                -> list.add(LoaiSach.parseLoaiSach(x))
        );
        return list;
    }

    public Map<String, LoaiSach> SelectBySqlMap(String sql, Object... colsSet) {
        Map<String, LoaiSach> map = new HashMap<>();
        super.SelectBySql(sql, colsSet).forEach((x) -> {
            LoaiSach data = LoaiSach.parseLoaiSach(x);
            map.put(data.getLoaiID(), data);
        });
        return map;
    }

    // Select all
    @Override
    public List<Object[]> SelectAll() {
        return super.SelectAll();
    }

    public List<LoaiSach> SelectAllElement() {
        List<LoaiSach> list = new LinkedList<>();
        super.SelectAll().forEach((x) -> list.add(LoaiSach.parseLoaiSach(x)));
        return list;
    }

    public Map<String, LoaiSach> SelectAllMap() {
        Map<String, LoaiSach> list = new HashMap<>();
        super.SelectAll().forEach((x) -> {
            LoaiSach data = LoaiSach.parseLoaiSach(x);
            list.put(data.getLoaiID(), data);
        });
        return list;
    }

    // Select by ID
    @Override
    public Object[] SelectByID(Object keyID) {
        return super.SelectByID(keyID);
    }

    public LoaiSach SelectByIDElement(Object keyID) {
        return LoaiSach.parseLoaiSach(super.SelectByID(keyID));
    }

    // ___________________________________________________________THÊM DỮ LIỆU_
    @Override
    public boolean insert(Object[] data) {
        return super.insert(data);
    }

    public boolean insert(LoaiSach data) {
        return super.insert(data.toArray());
    }

    // ____________________________________________________________SỬA DỮ LIỆU_
    @Override
    public boolean update(Object[] data) {
        return super.update(data);
    }

    public boolean update(LoaiSach data) {
        return super.update(data.toArray());
    }

    // ____________________________________________________________XÓA DỮ LIỆU_
    @Override
    public boolean delete(Object keyID) {
        return super.delete(keyID);
    }
}
