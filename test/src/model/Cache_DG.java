package model;

import dao.DocGiaDAO;
import entities.DocGia;
import javax.swing.ImageIcon;

/**
 *
 * @author abc
 */
public class Cache_DG {
    
    private static DocGia dg;

    // Đăng nhập
    public static boolean Login(String DgID) {
        dg = DocGia.parseDocGia(new DocGiaDAO().SelectByID(DgID));
        if (dg != null) {
            return true;
        }
        dg = null;
        return false;
    }
    
    public static DocGia getDg() {
        return dg;
    }
    
    public static void setDg(DocGia dg) {
        Cache_DG.dg = dg;
    }
    
    public static boolean isLogin() {
        return dg != null;
    }
    
    public static ImageIcon getImage(int weight, int height) {
        if (Cache_DG.isLogin()) {
            if (dg.getHinh() != null) {
                return Convert.Image(
                        Util.Image.getIcon("images/DocGia/" + dg.getHinh()),
                        weight, height
                );
            }
        }
        return Convert.Image(Util.Image.getIcon("src/icons/none.png"),
                weight, height);
    }
}
