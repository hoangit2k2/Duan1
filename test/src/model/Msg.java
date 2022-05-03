/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

public class Msg {

    public enum MesType {
        KhongCo, BaoLoi, ThongTin, CanhBao, CauHoi
    }

    public enum OptiType {
        Ok, Ok_No, Type_3, Yes_Cancel
    }
    // Thông báo không icon

    // Thông báo hỗ trợ chung
    public static void Alert(String str, String title, MesType type) {
        switch (type) {
            case BaoLoi:
                JOptionPane.showMessageDialog(null, str, title, 0);
                break;
            case ThongTin:
                JOptionPane.showMessageDialog(null, str, title, 1);
                break;
            case CanhBao:
                JOptionPane.showMessageDialog(null, str, title, 2);
                break;
            case CauHoi:
                JOptionPane.showMessageDialog(null, str, title, 3);
                break;
            default:
                JOptionPane.showMessageDialog(null, str, title, -1);
                break;
        }
    }

    // Thông báo chọn hỗ trợ chung
    public static int Confirm(String str, String title, OptiType option) {
        switch (option) {
            case Ok_No:
                return JOptionPane.showConfirmDialog(null, str, title, 0);
            case Type_3:
                return JOptionPane.showConfirmDialog(null, str, title, 1);
            case Yes_Cancel:
                return JOptionPane.showConfirmDialog(null, str, title, 2);
            default:
                return JOptionPane.showConfirmDialog(null, str, title, -1);
        }
    }

    // Thông báo nhập hỗ trợ chung
    public static String Prompt(String str, String title, MesType type) {
        switch (type) {
            case BaoLoi:
                return JOptionPane.showInputDialog(null, str, title, 0);
            case ThongTin:
                return JOptionPane.showInputDialog(null, str, title, 1);
            case CanhBao:
                return JOptionPane.showInputDialog(null, str, title, 2);
            case CauHoi:
                return JOptionPane.showInputDialog(null, str, title, 3);
            default:
                return JOptionPane.showInputDialog(null, str, title, -1);
        }
    }
}
