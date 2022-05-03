package dao;

import entities.DocGia;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class DocGiaDAO extends AbstractDAO {

    private static final String SELECT = "Select * from dbo.DocGia ";
    private static final String INSERT = "INSERT into dbo.DocGia "
            + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
            + "values (?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE dbo.DocGia set "
            + "HoTen=?,Email=?,SoDT=?,GioiTinh=?,"
            + "Hinh=?,NvID=? where DgID= ?";
    private static final String DELETE = "DELETE FROM dbo.DocGia where DgID = ?";
    private static final String SELECT_BY_ID = SELECT + " where DgID = ?";

    public DocGiaDAO() {
        super(SELECT, INSERT, UPDATE, DELETE, SELECT_BY_ID);
    }

    // ____________________________________________________________ĐỌC DỮ LIỆU_
    // Select by sql
    @Override
    public List<Object[]> SelectBySql(String sql, Object... colsSet) {
        return super.SelectBySql(sql, colsSet);
    }

    public List<DocGia> SelectBySqlElement(String sql, Object... colsSet) {
        List<DocGia> list = new LinkedList<>();
        super.SelectBySql(sql, colsSet).forEach((x)
                -> list.add(DocGia.parseDocGia(x))
        );
        return list;
    }

    public Map<String, DocGia> SelectBySqlMap(String sql, Object... colsSet) {
        Map<String, DocGia> map = new HashMap<>();
        super.SelectBySql(sql, colsSet).forEach((x) -> {
            DocGia data = DocGia.parseDocGia(x);
            map.put(data.getDgID(), data);
        });
        return map;
    }

    // Select all
    @Override
    public List<Object[]> SelectAll() {
        return super.SelectAll();
    }

    public List<DocGia> SelectAllElement() {
        List<DocGia> list = new LinkedList<>();
        super.SelectAll().forEach((x) -> list.add(DocGia.parseDocGia(x)));
        return list;
    }

    public Map<String, DocGia> SelectAllMap() {
        Map<String, DocGia> list = new HashMap<>();
        super.SelectAll().forEach((x) -> {
            DocGia data = DocGia.parseDocGia(x);
            list.put(data.getDgID(), data);
        });
        return list;
    }

    // Select by ID
    @Override
    public Object[] SelectByID(Object keyID) {
        return super.SelectByID(keyID);
    }

    public DocGia SelectByIDNV(Object keyID) {
        return DocGia.parseDocGia(super.SelectByID(keyID));
    }

    // ___________________________________________________________THÊM DỮ LIỆU_
    @Override
    public boolean insert(Object[] data) {
        return super.insert(data);
    }

    public boolean insert(DocGia data) {
        return super.insert(data.toArray());
    }

    // ____________________________________________________________SỬA DỮ LIỆU_
    @Override
    public boolean update(Object[] data) {
        return super.update(data);
    }

    public boolean update(DocGia data) {
        return super.update(data.toArray());
    }

    // ____________________________________________________________XÓA DỮ LIỆU_
    @Override
    public boolean delete(Object keyID) {
        return super.delete(keyID);
    }

}
