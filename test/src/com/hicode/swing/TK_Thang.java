
package com.hicode.swing;

import com.QLTV.utils.XImage;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class TK_Thang {
    
    public static JFreeChart createChart() {
       JFreeChart barChart = ChartFactory.createBarChart(
                "Biếu Đồ Sách Bán Được",
                "Tháng", "Lượt Mua",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(45, "Lượt Mua", "1");
        dataset.addValue(65, "Lượt Mua", "2");

        dataset.addValue(80, "Lượt Mua", "3");

        dataset.addValue(45, "Lượt Mua", "4");

        dataset.addValue(50, "Lượt Mua", "5");

        dataset.addValue(15, "Lượt Mua", "6");

        dataset.addValue(15, "Lượt Mua", "7");

        dataset.addValue(19, "Lượt Mua", "8");

        dataset.addValue(27, "Lượt Mua", "9");
        dataset.addValue(35, "Lượt Mua", "10");

        dataset.addValue(26, "Lượt Mua", "11");

        dataset.addValue(70, "Lượt Mua", "12");

        return dataset;
    }

    public static void main() {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

        JFrame frame = new JFrame();
                                frame.setIconImage(XImage.getappicon());

        frame.add(chartPanel);
        frame.setTitle("Biểu Đồ Thống Kê Theo Tháng");
        frame.setSize(600, 400);
        frame.setLocation(570,330);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
