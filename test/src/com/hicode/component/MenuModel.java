/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.component;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author HieuHoang
 */
public class MenuModel {
    private String icon;
    private String title;
    private MenuType type;

    public MenuModel(String icon, String title, MenuType type) {
        this.icon = icon;
        this.title = title;
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
    
    
    public static enum MenuType{
        MENU,EMPTY;
    }
}
