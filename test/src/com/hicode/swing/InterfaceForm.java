/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.swing;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import java.awt.Component;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Msg;

public interface InterfaceForm<Element> {

    public enum alertType {
        insert1, insert2, insert3, update1, update2,
        update3, delete1, delete2, delete3, custom
    }

    /**
     * Thêm mới nhân viên
     */
    public void Insert();

    /**
     * Sửa thông tin nhân viên
     */
    public void update();

    /**
     * Xóa thông tin nhân viên cần tìm
     */
    public void delete();

    /**
     * @param key mã nhân viên cần được tìm
     * @return vị trí tìm được của danh sách
     */
    public int findList(Object key);

    /**
     * @return trả về đối tượng lấy thông tin từ form
     */
    public Element getForm();

    /**
     * @param panel (JPanel) chứa thông tin
     * @return kết quả dạng mảng <br>
     * <strong>#Dùng <em>entities.Element.parse...</em> để chuyển sang dạng lớp
     * bao (thực thể)</strong>
     * <hr>
     * #getArrayForm() sẽ lâu hơn 1 chút (không đáng kể nếu dữ liệu ít
     * "milliSeconds") so với tự viết get... từ thông tin dữ liệu trên form cần
     * lấy.<br>
     * #Cần đảm bảo thông tin cần lấy nằm trong Jpanel(Component) chứa
     */
    @Deprecated
    default Object[] getArrayForm(JPanel panel) {
        // LinkedList dùng các node sẽ tiện hơn cho việc thêm và
        List<Object> list = new LinkedList<>();
        Component[] cs = panel.getComponents();

        // Lọc các phần tử chứa thông tin cần lấy
        for (Component c : cs) {
            if (c instanceof JTextField) {
                // Dạng field kiểu String
                list.add(((JTextField) c).getText());
            } else if (c instanceof JComboBox) {
                // Dạng ComboBox kiểu int
                list.add(((JComboBox) c).getSelectedIndex());
            } else if (c instanceof JDateChooser) {
                // Dạng DateChooser kiểu java.sql.Date
                Calendar calendar = ((JDateChooser) c).getCalendar();
                long longTime = calendar.getTimeInMillis();
                list.add(new Date(longTime));
            } else if (c instanceof JTextArea) {
                // Dạng textArea kiểu String
                list.add(((JTextArea) c).getText());
            } else if (c instanceof JSpinField) {
                // Dạng SpinField integer
                list.add(((JSpinField) c).getValue());
            }
        }

        return list.toArray();
    }

    /**
     * @param data dữ liêu thực thể
     */
    public void setForm(Element data);

    /**
     * @param data mảng dữ liệu cần đổ thông tin
     * @param panel panel (FORM - "fillForm") chứa thông tin cần xem
     */
    default void setForm(Object[] data, JPanel panel) {
        Component[] cs = panel.getComponents();
        int count = 0; // Biến đếm fill dữ liệu

        for (Component c : cs) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText(data[++count].toString());
            } else if (c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            } else if (c instanceof JDateChooser) {
                long longTime = Long.parseLong(data[++count].toString());
                ((JDateChooser) c).setDate(new Date(longTime));
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setText(data[++count].toString());
            } else if (c instanceof JSpinField) {
                int i = Integer.parseInt(data[++count].toString());
                ((JSpinField) c).setValue(i);
            }
        }
    }

    /**
     * Xóa thông tin trên form hiển thị
     */
    public void clearForm();

    default void clearForm(JPanel panel) {
        Component[] cs = panel.getComponents();
        for (Component c : cs) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText(null);
            } else if (c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            } else if (c instanceof JDateChooser) {
                ((JDateChooser) c).setCalendar(null);
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setText(null);
            } else if (c instanceof JSpinField) {
                ((JSpinField) c).setValue(0);
            }
        }
    }

    /**
     * Đổ dữ liệu bảng
     *
     * @param list danh sách dữ liệu
     * @param table bảng cần đổ
     */
    default void fillTable(List<Object[]> list, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (list != null) {
            list.forEach((x) -> model.addRow(x));
        } else {
            System.err.println("check list<Object[]>!");
        }
    }

    /**
     * #alertType: insert: thêm <br>
     * update: sửa <br>
     * delete: xóa<br>
     * custom: tự chọn (khác)<br>
     * #Phân loại:
     * <ul>
     * <li>Loại 1: báo thành công</li>
     * <li>Loại 2: báo tồn thiếu điều kiện</li>
     * <li>Loại 3: báo lỗi thao tác dữ liệu</li>
     * </ul>
     *
     * @param content // Nội dung thông báo
     * @param mes // Kiểu thông báo
     */
    default void alertGroup(String content, alertType mes) {
        switch (mes) {
            case insert1:
                Msg.Alert("Thêm " + content + " thành công",
                        "Thêm " + content, Msg.MesType.ThongTin);
                break;
            case insert2:
                Msg.Alert(content + " đã tồn tại",
                        "Thêm " + content, Msg.MesType.CanhBao);
                break;
            case insert3:
                Msg.Alert("Thêm " + content + " thất bại!",
                        "Thêm " + content, Msg.MesType.BaoLoi);
                break;
            case update1:
                Msg.Alert("Sửa " + content + " thành công",
                        "Sửa " + content, Msg.MesType.ThongTin);
                break;
            case update2:
                Msg.Alert(content + " không tồn tại",
                        "Sửa " + content, Msg.MesType.CanhBao);
                break;
            case update3:
                Msg.Alert("Sửa " + content + " thất bại!",
                        "Sửa " + content, Msg.MesType.BaoLoi);
                break;
            case delete1:
                Msg.Alert("Xóa " + content + " thành công",
                        "Xóa " + content, Msg.MesType.ThongTin);
                break;
            case delete2:
                Msg.Alert(content + " không tồn tại",
                        "Xóa " + content, Msg.MesType.CanhBao);
                break;
            case delete3:
                Msg.Alert("Xóa " + content + " thất bại!",
                        "Xóa " + content, Msg.MesType.BaoLoi);
                break;
            default:
                System.out.println("Khong ton tai thong bao!");
        }
    }

    /**
     * * <h3>Kiểm tra dữ liệu:</h3>
     * Phương thức sử dụng: Check.methods(...)<br>
     * Data.[HẰNG]: các loại định dạng<br>
     * size: độ dài cho phép của kí tự<br>
     * <Strong>Ví dụ: "{5,10}"</Strong> độ dài cho phép từ 5 - 10 kí tự
     * |******************************************************************|
     *
     * @param data dữ liệu thực thể "element" cần kiểm tra
     * @return trả về vị trí lỗi
     */
    public boolean validateData(Element data);

    /**
     * @param tblData dữ liệu bảng
     * @param nameColumn tên cột cần tìm
     * @return vị trí tìm thấy cột
     */
    default int findColumnName(JTable tblData, String nameColumn) {
        for (int i = 0; i < tblData.getColumnCount(); i++) {
            if (tblData.getColumnName(i).equalsIgnoreCase(nameColumn)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param table tên bảng dữ liệu (database)
     * @param findText tìm khớp theo kí tự
     * @return trả câu truy vấn mới được tạo
     */
    @Deprecated
    default String createSqlFindLike(JTable table, String findText) {
        if (sp.checkName(table) != null) {
            Object[] cols = sp.SelectedColsName(table);
            StringBuilder str = new StringBuilder("Select * from ");
            str.append(table.getName());
            if (cols != null) {
                str.append(" where ");
                for (Object col : cols) {
                    str.append(col).append(" like N'%").append(findText);
                    str.append("%'").append(" or ");
                }
                String sql = str.toString();
                return sql.substring(0, sql.lastIndexOf("or"));
            }
            return str.toString();
        } else {
            System.out.println("Name table does not exist!");
        }
        return null;
    }

    /**
     * @param tblData bảng dữ liệu
     * @param txtSetText Jtextfield cần hiển thị trạng thái cột được chọn
     */
    default void colSelected(JTable tblData, JTextField txtSetText) {
        int[] selectedColumns = tblData.getSelectedColumns();
        txtSetText.setText(null);
        String text = "";
        for (int i : selectedColumns) {
            text += tblData.getColumnName(i) + ", ";
        }
        text = "Selected: " + text.substring(0, text.lastIndexOf(", "));
        txtSetText.setText(text);
    }

    static class sp {

        // Kiểm tra tên
        static String checkName(JTable table) {
            return table.getName() != null ? table.getName() : null;
        }

        // Kiểm tra cột được chọn
        static Object[] SelectedColsName(JTable table) {
            int[] slds = table.getSelectedColumns();
            if (slds.length > 0) {
                @SuppressWarnings("unchecked")
                ArrayList<String> cols = new ArrayList<>();
                for (int sld : slds) {
                    String name = table.getColumnName(sld);
                    cols.add(convertColName(name));
                }
                return cols.toArray();
            }
            return null;
        }

        /**
         * @param name Tên cột trên bảng
         * @return tên cột trong database
         */
        private static String convertColName(String name) {
            // case: tên cột Jtable
            // return: tên cột tương ứng trong database
            switch (name) {
                // __________________________________________Quản lý nhân viên_
                case "NvID":
                    return "NvID";
                case "MẬT KHẨU":
                    return "HoTen";
                case "HỌ VÀ TÊN":
                    return "HoTen";
                case "NGÀY SINH":
                    return "NgaySinh";
                case "ĐỊA CHỈ":
                    return "DiaChi";
                case "SỐ ĐIỆN THOẠI":
                    return "SoDT";
                case "ĐỊA CHỈ EMAIL":
                    return "Email";
                case "CHỨC VỤ":
                    return "ChucVu";
                // _______________________________________________Quản lý sách_
                case "LoaiID":
                    return "LoaiID";
                case "SachID":
                    return "SachID";
                case "TÊN SÁCH":
                    return "TenSach";
                case "NHÀ XUẤT BẢN":
                    return "NhaXb";
                case "TÁC GIẢ":
                    return "TacGia";
                case "SỐ LƯỢNG":
                    return "SoLuong";
                case "ĐƠN GIÁ":
                    return "DonGia";
                case "KỆ SỐ":
                    return "KeSo";
                // ____________________________________________Quản lý đọc giả_
                case "DgID":
                    return "DgID";
                case "GIỚI TÍNH":
                    return "HoTen";
                case "NHÂN VIÊN THÊM":
                    return "NvID";
                default:
                    return null;
            }
        }
    }
}
