/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hicode.component;

import com.hicode.event.EventMenuSelected;
import com.hicode.swing.MenuItem;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author HieuHoang
 */
public class ListMenu<E extends Object> extends JList<E> {

    private int seleted = 0;
    private DefaultListModel dlm;
    private int overIndex = -1;
     private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
    }
    public ListMenu() {
        dlm = new DefaultListModel();
        setModel(dlm);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    Object o = dlm.getElementAt(index);
                    if (o instanceof MenuModel) {
                        MenuModel mm = (MenuModel) o;
                        if (mm.getType() == MenuModel.MenuType.MENU) {
                            seleted = index;
                            if (event!=null){
                                event.selected(index);
                            }
                        }
                    }
                }
                repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                overIndex = -1;
                repaint();
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
               int index= locationToIndex(e.getPoint());
               if (index!=overIndex){
                   Object o = dlm.getElementAt(index);
                   if (o instanceof MenuModel){
                       MenuModel mm = (MenuModel) o;
                       if (mm.getType()==MenuModel.MenuType.MENU){
                           overIndex = index;
                       }
                else{
                           overIndex=-1;
                       }
                       repaint();
                   }
               }
                
            }
            
        });
        

    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                MenuModel mm;
                if (value instanceof MenuModel) {
                    mm = (MenuModel) value;
                } else {
                    mm = new MenuModel("", "", MenuModel.MenuType.EMPTY);
                }
                MenuItem mi = new MenuItem(mm);
                mi.setSelected(seleted == index);
                mi.setOver(overIndex==index);
                return mi;
            }

        };
    }

    public void addItem(MenuModel mm) {
        dlm.addElement(mm);
    }
}
