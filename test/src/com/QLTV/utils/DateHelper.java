/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLTV.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Owner
 */
  public class DateHelper {

    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Chuyển đổi String sang Date
     *
     * @param date là String cần chuyển
     * @param pattern là định dạng thời gian
     * @return Date kết quả
     */
    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateHelper.now();
            }
            return DATE_FORMATER.parse(date);
            //return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Chuyển đổi từ Date sang String
     *
     * @param date là Date cần chuyển đổi
     * @param pattern là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMATER.format(date);
    }

    /**
     * Lấy thời gian hiện tại
     *
     * @return Date kết quả
     */
    public static Date now() {
        return new Date();
    }

    /**
     * Bổ sung số ngày vào thời gian
     *
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung vào date
     * @return Date kết quả
     */
    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    /**
     * Bổ sung số ngày vào thời gian hiện hành
     *
     * @param days số ngày cần bổ sung vào thời gian hiện tại
     * @return Date kết quả
     */
    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }

    /**
     * Hàm thực hiện phép tính trừ hai ngày
     *
     * @param date1 - ngày trừ
     * @param date2 - ngày bị trừ
     * @param timeUnit - kiểu kết quả trả về
     * @return số năm
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    
    /*
     * Hàm tính thứ trong tuần và trả về ngày của thứ hai
        - i = 0: dd-MM-yyyy
        - i = 1: yyyy-MM-dd
     */
    public static String tinhNgayDauTuan(int i) {
        String getThu = new SimpleDateFormat("EE").format(DateHelper.now());
        Date date = DateHelper.now();
        switch (getThu) {
            case "Mon":
                break;
            case "Tue":
                date = DateHelper.addDays(DateHelper.now(), -1);
                break;
            case "Wed":
                date = DateHelper.addDays(DateHelper.now(), -2);
                break;
            case "Thu":
                date = DateHelper.addDays(DateHelper.now(), -3);
                break;
            case "Fri":
                date = DateHelper.addDays(DateHelper.now(), -4);
                break;    
            case "Sat":
                date = DateHelper.addDays(DateHelper.now(), -5);
                break;
            case "Sun":
                date = DateHelper.addDays(DateHelper.now(), -6);
                break;
        }
        if (i == 0)
            return DateHelper.toString(date, "dd-MM-yyyy");
        else 
            return DateHelper.toString(date, "yyyy-MM-dd");
    }
    
    /*
     * Hàm tính quý thứ mấy trong năm
        quý 1: tháng 1 đến tháng 3
        quý 2: tháng 4 đến tháng 6
        quý 3: tháng 7 đến tháng 9
        quý 4: tháng 10 đến tháng 12
     */
    public static int tinhSoQuyTrongNam() {
        int Quy = 0;
        String NgayHienTai = DateHelper.toString(DateHelper.now(), "dd-MM-yyyy");
        String ThangHienTai = NgayHienTai.substring(3, 5);
        switch (ThangHienTai) {
            case "01": case "02": case "03":
                Quy = 1;
                break;
            case "04": case "05": case "06":
                Quy = 2;
                break;
            case "07": case "08": case "09":
                Quy = 3;
                break;
            case "10": case "11": case "12":
                Quy = 4;
                break;
        }
        return Quy;
    }
    
    /*
     * Hàm kiểm tra năm nhuận
        true: nhuận
        false: không nhuận
     */
    public static boolean xetNamNhuan(int Nam) {
        if (Nam % 4 == 0) {
            if (Nam % 100 == 0) {
                return Nam % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
      
}