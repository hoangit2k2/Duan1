package com.hicode.swing;

import com.QLTV.utils.XImage;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author TVD
 */
public class TK_Tuan {

    public static JFreeChart createChart() {
       JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh Thu Trong Tuần",
                "Ngày Tháng", "VNĐ",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(375000, "VNĐ", "01/12");
        dataset.addValue(450000, "VNĐ", "02/12");
        dataset.addValue(350000, "VNĐ", "03/12");
        dataset.addValue(220000, "VNĐ", "04/12");
        dataset.addValue(440000, "VNĐ", "05/12");
        dataset.addValue(385000, "VNĐ", "06/12");
        dataset.addValue(475000, "VNĐ", "07/12");
        dataset.addValue(475000, "VNĐ", "08/12");
        return dataset;
    }

    public static void main() {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
                frame.setIconImage(XImage.getappicon());

        frame.add(chartPanel);
        frame.setTitle("Biểu ĐỒ Thống Kê Theo Tuần");
        frame.setSize(600, 400);
        frame.setLocation(570,330);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}