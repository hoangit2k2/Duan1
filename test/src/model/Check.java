package model;

import java.sql.Date;

/**
 * lớp kiểm tra định dạng
 */
public class Check {

    // Kiểm tra chuỗi kí tự
    public static boolean String(String str, String regex, String sizeRegex) {
        return str.matches(regex + sizeRegex);
    }

    // Kiểm tra độ dài
    public static boolean String(String str, int length) {
        return str.length() < length;
    }

    // Kiểm tra độ dài trong khoảng
    public static boolean String(String str, int min, int max) {
        return str.length() >= min && max > str.length();
    }

    // Kiểm tra ngày sinh
    public static boolean Date(Date NgaySinh, int year) {
        if (NgaySinh == null) {
            return false;
        }
        long min = 31557600000L * year; // 31557600000 = 1 năm
        long now = new java.util.Date().getTime();
        long birth = NgaySinh.getTime();
        return now - birth > min;
    }

    public static class regex {

        public static final String CODE = "^[A-Za-z0-9]";
        public static final String PASS = "\\w";
        public static final String NAME
                = "/^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơ"
                + "ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘ"
                + "ỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]";
        public static final String EMAIL = "^[A-Za-z0-9+_.]+@(.+)$";
        public static final String PHONE_NUMBER = "[0-9]";
    }
}
