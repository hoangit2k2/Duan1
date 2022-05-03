/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author abc
 */
public class Util {

    @SuppressWarnings("unchecked")
    public static String createDocument(String title, Object[] arrs) {
        StringBuilder data = new StringBuilder("File save at: ");
        if (arrs.length > 0) {
            data.append(new java.util.Date());
            data.append("\n=======================================================");
            data.append("\nTitle: ").append(title);
            data.append("\nColumn count: ").append(((Vector) arrs[0]).size());
            data.append("\nRows count: ").append(arrs.length);
            data.append("\n=======================================================");

            for (Object arr : arrs) {
                Vector<Object> x = (Vector<Object>) arr;
                data.append("\n");
                x.forEach((object) -> {
                    data.append(object).append("\t");
                });
            }
        } else {
            data.append(new java.util.Date()).append("\t-\tno data!");
        }
        return data.toString();
    }

    // Tạo hàm lấy mã người dùng giỏ hàng
    public static String ramdomCode(String code, int size) {
        Random r = new Random();
        if (code == null) {
            code = "";
        }
        while (code.length() < size) {
            int i = r.nextInt(122);
            if (i > 47 && i < 58) {
                code += (char) i;
            } else if (i > 64 && i < 91) {
                code += (char) i;
            } else if (i > 96 && i < 123) {
                code += (char) i;
            }
        }
        return code;
    }

    public static boolean ExportToTXT(String data) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("TXT", "txt"));
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            boolean check = file.getName().endsWith(".txt");
            WriteByte(check ? file.getAbsolutePath()
                    : file.getAbsolutePath() + ".txt", data.getBytes());
            return true;
        }
        return false;
    }

    public static boolean ExportToExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("XLSX", "xlsx"));
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            boolean check = file.getName().endsWith(".xlsx");
            file = check ? file : new File(file.getAbsolutePath() + ".xlsx");

            // Export Jtable -> cells excel
            try (FileOutputStream os = new FileOutputStream(file.getAbsolutePath())) {
                try (Workbook wb = new XSSFWorkbook()) {
                    Sheet sheet = wb.createSheet(
                            table.getName().isEmpty()
                            ? "Nhóm 3 - data export" : table.getName()
                    );

                    // Header
                    Row headRow = sheet.createRow(0);
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        headRow.createCell(i, CellType.STRING).setCellValue(
                                table.getColumnName(i)
                        );
                    }

                    // Row
                    Object[] arrs = model.getDataVector().toArray();
                    for (int i = 1; i <= table.getRowCount(); i++) {
                        Row row = sheet.createRow(i);
                        Object[] rowData = ((Vector) arrs[i - 1]).toArray();
                        // Column
                        for (int j = 0; j < rowData.length; j++) {
                            row.createCell(j).setCellValue(rowData[j].toString());
                        }
                    }
                    wb.write(os);
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public static boolean ExportToExcell(JTable table) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

        }
        return false;

    }

    // Ghi file trong đường dẫn bằng byte
    public static void WriteByte(String path, byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data);
        } catch (HeadlessException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    // Chạy đồng hồ
    public static Timer setTimer(JButton lblThoiGian, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(pattern);
        Timer timer = new Timer(1000, (e) -> {
            lblThoiGian.setText(format.format(e.getWhen()));
        });
        return timer;

    }

    /**
     * <h3>Lớp hỗ trợ đọc ảnh</h3>
     * Hỗ trợ đọc file ảnh, ghi file ảnh, chọn ảnh hoặc file theo đường dẫn
     */
    public static class Image {

        // Lấy ảnh có sẵn đường dẫn
        public static ImageIcon getIcon(String path) {
            if (path.isEmpty()) {
                return null;
            }
            ImageIcon icon = new ImageIcon(path);
            return icon.getImage() == null ? null : icon;
        }

        // Lấy đường dẫn tới file
        public static File ChooserFile(Component Parent) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileNameExtensionFilter("PNG, JPG", "png", "jpg"));
                if (chooser.showOpenDialog(Parent) == JFileChooser.APPROVE_OPTION) {
                    return chooser.getSelectedFile();
                }
            } catch (HeadlessException e) {
                System.err.println("Hủy chọn!");
            }
            return null;
        }

        // Lấy file từ đường dẫn
        public static File getFile(String path) {
            if (path == null) {
                return null;
            }
            return new File(path);
        }

        /**
         * @param LinkParent folders chứa
         * @param src file source
         * @param newName tên file mới
         * @return kết quả thực hiện được
         */
        public static boolean SaveIcon(String LinkParent, File src, String newName) {
            if (src == null) {
                return false;
            }
            if (src.getName().endsWith("none.png")) {
                return false;
            }
            File dst = new File(LinkParent, newName);
            if (!dst.getParentFile().exists()) {
                dst.getParentFile().mkdirs();
            }
            try {
                Files.copy(
                        Paths.get(src.getAbsolutePath()),
                        Paths.get(dst.getAbsolutePath()),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

        // phương thức xóa file trược tiếp theo đường dẫn
        public static void DeleteIcon(File src) {
            try {
                Files.deleteIfExists(src.getAbsoluteFile().toPath());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
