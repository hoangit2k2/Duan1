package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

    // Hằng dữ liệu
    private final static String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041";
    private final static String USER = "sa";
    private final static String PASSWORD = "songlong";

    private static Connection connection;

    // Nạp driver lần đầu
    static {
        try {
            Class.forName(CLASSNAME); // Nạp driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // getStatement
    public static PreparedStatement getStatement(String sql, Object... columns)
            throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement statement = sql.trim().startsWith("{")
                ? connection.prepareCall(sql)
                : connection.prepareStatement(sql);
        for (int i = 0; i < columns.length; i++) {
            statement.setObject(
                    i + 1, columns[i] != null ? columns[i] : java.sql.Types.NULL
            );
        }
        return statement;
    }

    // Lấy resultSet
    public static ResultSet getResultSet(String sql, Object... columns)
            throws SQLException {
        try {
            return getStatement(sql, columns).executeQuery();
        } catch (SQLException e) {
            connection.rollback();
            connection.close();
            throw e;
        }
    }

    // Thao tác dữ liệu với database
    public static int Query(String sql, Object... agrs) throws SQLException {
        try {
            PreparedStatement statement = getStatement(sql, agrs);
            try {
                return statement.executeUpdate();
            } finally {
                statement.getConnection().close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
