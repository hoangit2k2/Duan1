package model;

import java.awt.Image;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

public class Convert {

    // Chuyển đổi ngày theo định dạng
    public static Date ToDate(String x, String type) {
        try {
            long ls = new SimpleDateFormat(type).parse(x).getTime();
            return new Date(ls);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    // Chuyển đổi ảnh theo kích cỡ
    public static ImageIcon Image(ImageIcon image, int wight, int heigh) {
        if (image == null) {
            return null;
        }
        Image img = image.getImage().getScaledInstance(wight, heigh, 4);
        return new ImageIcon(img);
    }
}
