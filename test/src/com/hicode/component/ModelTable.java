/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.component;

import com.hicode.model.HocVien;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HieuHoang
 */
public class ModelTable extends AbstractTableModel{
   private final Class[] classes = {String.class,String.class, String.class, String.class, String.class, Boolean.class};
   private final String[] columnNames = {"MSSV","Họ và tên","Ngày sinh","Số điện thoại","Địa chỉ","Tình trạng"};
   private List<HocVien> list;

    public ModelTable(List<HocVien> list) {
        this.list = list;
    }
   
    
    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         HocVien hv = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return hv.getMaSV();
            case 1:
                return hv.getHoTen();
            case 2:
                return hv.getNgaySinh();
            case 3:
                return hv.getSoDT();
            case 4:
                return hv.getDiaChi();
            case 5:
                return hv.isTinhTrang();
        }
        return null;
    }
     @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];

    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }
}
