package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import model.Jdbc;

public abstract class AbstractDAO {

    // +_________________________________________________SQL TRUY VẤN DỮ LIỆU_+
    private final String Select;
    private final String Insert;
    private final String Update;
    private final String Delete;
    private final String SelectByID;
    // Câu truy vấn thêm cho phép truy cập từ bên ngoài
    protected final String[] custom;

    // Contructor setQueries
    protected AbstractDAO(
            String Select, String Insert, String Update, String Delete,
            String SelectByID, String... custom) {
        this.Select = Select;
        this.Insert = Insert;
        this.Update = Update;
        this.Delete = Delete;
        this.SelectByID = SelectByID;
        this.custom = custom;
    }

    // ___________________________________________________________ĐỌC DỮ LIỆU_+
    // Lấy dữ liệu từ khóa chính
    protected Object[] SelectByID(Object keyID) {
        List<Object[]> list = SelectBySql(SelectByID, keyID);
        return list.isEmpty() ? null : list.get(0);
    }

    protected List<Object[]> SelectAll() {
        return this.SelectBySql(Select);
    }

    protected List<Object[]> SelectBySql(String sql, Object... colsSet) {
        List<Object[]> list = new LinkedList<>();
        try {
            ResultSet rs = Jdbc.getResultSet(sql, colsSet);
            while (rs.next()) {
                list.add(getData(rs));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            System.err.println("Select failed! -> " + e.getMessage());
        }
        return list;
    }

    @SuppressWarnings("unchecked") // Dữ liệu theo bảng từ "ResultSet"
    private Object[] getData(ResultSet rs) {
        try {
            Object[] datas = new Object[rs.getMetaData().getColumnCount()];
            for (int i = 0; i < datas.length;) {
                datas[i] = rs.getObject(++i);
            }
            return datas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // __________________________________________________________THÊM DỮ LIỆU_+
    // Thêm dữ liệu data[] => getStatemens.setObject => SQL_Query
    protected boolean insert(Object[] data) {
        try {
            Jdbc.Query(Insert, data);
            System.out.println("insert succesfully!");
            return true;
        } catch (SQLException e) {
            System.err.println("insert failed! -> " + e.getMessage());
        }
        return false;
    }

    // ___________________________________________________________SỬA DỮ LIỆU_+
    // ID[1](?) = value[max](?) => cắt bớt ?[0] chuyển xuống dưới cùng SQL_Query
    protected boolean update(Object[] data) {
        try {
            if (data.length > 0) {
                Object first = data[0];
                data = Arrays.copyOfRange(data, 1, data.length + 1);
                data[data.length - 1] = first;
                // Thực hiện cập nhật sau
                Jdbc.Query(Update, data);
                System.out.println("update succesfully!");
                return true;
            } else {
                System.out.println("update failed!!");
            }
        } catch (SQLException e) {
            System.err.println("update failed! -> " + e.getMessage());
        }
        return false;
    }

    // ___________________________________________________________XÓA DỮ LIỆU_+
    // Xóa dữ liệu từ khóa chính của bảng (database)
    protected boolean delete(Object keyID) {
        try {
            Jdbc.Query(Delete, keyID);
            System.out.println("delete succesfully!");
            return true;
        } catch (SQLException e) {
            System.err.println("delete failed! -> " + e.getMessage());
        }
        return false;
    }

    // +_______________________________________________LẤY CÂU TRUY VẤN CUSTOM+
    // Lấy câu truy vấn tùy chọn
    public String getCustomSQL(int index) {
        if (custom.length > 0) {
            return custom[index];
        } else {
            System.out.println("Cannot found sql query at index: " + index);
            return null;
        }
    }
}
