/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.component;

import javax.swing.Icon;

/**
 *
 * @author HieuHoang
 */
public class CardItem {
    Icon icon;
    int value;
    String title;

    public CardItem(Icon icon, int value, String title) {
        this.icon = icon;
        this.value = value;
        this.title = title;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
