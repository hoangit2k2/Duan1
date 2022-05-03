package entities;

// Chi tiết đơn hàng
import java.lang.reflect.Field;

public class ChiTietHD {

    private int HdID;
    private String SachID;
    private int SoLuong;
    private double GiaCu;

    public int getHdID() {
        return HdID;
    }

    public String getSachID() {
        return SachID;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getGiaCu() {
        return GiaCu;
    }

    public void setHdID(int HdID) {
        this.HdID = HdID;
    }

    public void setSachID(String SachID) {
        this.SachID = SachID;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setGiaCu(double GiaCu) {
        this.GiaCu = GiaCu;
    }

    @Override
    public String toString() {
        return "ChiTiet{" + "HdID=" + HdID + ", SoLuong=" + SoLuong + '}';
    }

    public Object[] toArray() {
        Object[] arr = {
            HdID, SachID, SoLuong, GiaCu
        };
        return arr;
    }

    public static ChiTietHD parseChiTietHD(Object... data) {
        if(data == null) return null;
        ChiTietHD nv = new ChiTietHD();
        Field[] fields = nv.getClass().getDeclaredFields();
        for (int i = 0; i < data.length; i++) {
            try {
                fields[i].set(nv, data[i]);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return nv;
    }
}
