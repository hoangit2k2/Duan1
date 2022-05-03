package com.QLTV.DAO;

import com.QLTV.entities.NhanVien;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends QLTVDAO<NhanVien, String> {

    String selectbyid = "select * from nhanvien where NVID = ?";
    final String select = "SELECT * FROM nhanvien ";
    final String insert = "INSERT into dbo.NhanVien"
            + " (NvID,MatKhau,HoTen,NgaySinh,DiaChi,SoDT,Email,ChucVu,HinhAnh,ThoiGian)"
            + " values(?,?,?,?,?,?,?,?,?,?);";
    final String updatetime = "update UPDATE dbo.NhanVien set thoigian = ? where nvid = ? ";
    final String update = "UPDATE dbo.NhanVien set "
            + "MatKhau=?,HoTen=?,NgaySinh=?,DiaChi=?"
            + ",SoDT=?,Email=?,ChucVu=?,HinhAnh=?,ThoiGian = ? where NvID = ?";
    final String delete = "DELETE FROM dbo.NhanVien where NvID = ?";

    ;
    @Override
    public void insert(NhanVien entity) {
//            final String insert = "INSERT into dbo.NhanVien"
//            + " (NvID,MatKhau,HoTen,NgaySinh,DiaChi,SoDT,Email,ChucVu,HinhAnh)"
        XJdbc.update(insert,
                entity.getNvID(),
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.getDiaChi(),
                entity.getSoDT(),
                entity.getEmail(),
                entity.isChucVu(),
                entity.getHinhAnh()
        );
    }

    @Override
    public void update(NhanVien entity) {
        XJdbc.update(update,
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.getDiaChi(),
                entity.getSoDT(),
                entity.getEmail(),
                entity.isChucVu(),
                entity.getHinhAnh(),
                entity.getThoiGian(),
                entity.getNvID()
        );
    }

    @Override
    public void delete(String MaNV) {
        XJdbc.update(delete, MaNV);
    }

    @Override
    public NhanVien selectById(String manv) {
        List<NhanVien> list = this.selectBySql(selectbyid, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(select);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien enity = new NhanVien();
                    enity.setNvID(rs.getString("NvID"));
                    enity.setHoTen(rs.getString("HoTen"));
                    enity.setMatKhau(rs.getString("MatKhau"));
                    enity.setChucVu(rs.getBoolean("chucvu"));
                    enity.setNgaySinh(rs.getDate("NgaySinh"));
                    enity.setDiaChi(rs.getString("DiaChi"));
                    enity.setSoDT(rs.getString("SoDT"));
                    enity.setEmail(rs.getString("Email"));
                    enity.setHinhAnh(rs.getString("HinhAnh"));
                    enity.setThoiGian(rs.getInt("ThoiGian"));
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
